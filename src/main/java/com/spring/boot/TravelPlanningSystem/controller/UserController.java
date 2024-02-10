package com.spring.boot.TravelPlanningSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.TravelPlanningSystem.entity.User;
import com.spring.boot.TravelPlanningSystem.service.UserService;
import com.spring.boot.TravelPlanningSystem.util.ResponseStructure;

@RestController
@RequestMapping("user")
public class UserController 
{
	@Autowired
	UserService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user)
	{
		return service.saveUser(user);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<User>> findUser(@RequestParam int userId)
	{
		return service.findUser(userId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<User>> deleteUser(@RequestParam int userId)
	{
		return service.deleteUser(userId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user,@RequestParam int userId)
	{
		return service.updateUser(user, userId);
	}
	
	@GetMapping("findall")
	public ResponseEntity<ResponseStructure<List<User>>> findAllUsers()
	{
		return service.findAllUsers();
	}
}
