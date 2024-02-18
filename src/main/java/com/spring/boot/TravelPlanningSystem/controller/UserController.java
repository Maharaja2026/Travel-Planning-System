package com.spring.boot.TravelPlanningSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.TravelPlanningSystem.dto.UserDto;
import com.spring.boot.TravelPlanningSystem.entity.User;
import com.spring.boot.TravelPlanningSystem.service.UserService;
import com.spring.boot.TravelPlanningSystem.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController 
{
	@Autowired
	UserService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<UserDto>> saveUser(@Valid @RequestBody User user,BindingResult result)
	{
		return service.saveUser(user);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<UserDto>> findUser(@RequestParam int userId)
	{
		return service.findUser(userId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<UserDto>> deleteUser(@RequestParam int userId)
	{
		return service.deleteUser(userId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<UserDto>> updateUser(@RequestBody User user,@RequestParam int userId)
	{
		return service.updateUser(user, userId);
	}
	
	@GetMapping("findall")
	public ResponseEntity<ResponseStructure<List<User>>> findAllUsers()
	{
		return service.findAllUsers();
	}
	
	@PutMapping("assignTrip")
	public ResponseEntity<ResponseStructure<User>> assignTripToUser(@RequestParam int tripId,@RequestParam int userId)
	{
		return service.assignTripToUser(tripId, userId);
	}
	
	@PutMapping("assignAgency")
	public ResponseEntity<ResponseStructure<User>> assignAgencyToUser(@RequestParam int travelAgencyId,@RequestParam int userId)
	{
		return service.assignAgencyToUser(travelAgencyId, userId);
	}
	
	@GetMapping("findByEmail")
	public ResponseEntity<ResponseStructure<UserDto>> findByuserEmail(@RequestParam String userEmail)
	{
		return service.findByEmail(userEmail);
	}
	
	//user login
	@GetMapping("login")
	public ResponseEntity<ResponseStructure<User>> loginUser(@RequestParam String email,@RequestParam String password)
	{
		return service.loginUser(email, password);
	}
}
