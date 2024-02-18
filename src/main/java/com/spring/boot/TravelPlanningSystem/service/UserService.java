package com.spring.boot.TravelPlanningSystem.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.boot.TravelPlanningSystem.dao.TravelAgencyDao;
import com.spring.boot.TravelPlanningSystem.dao.TripDao;
import com.spring.boot.TravelPlanningSystem.dao.UserDao;
import com.spring.boot.TravelPlanningSystem.dto.UserDto;
import com.spring.boot.TravelPlanningSystem.entity.TravelAgency;
import com.spring.boot.TravelPlanningSystem.entity.Trip;
import com.spring.boot.TravelPlanningSystem.entity.User;
import com.spring.boot.TravelPlanningSystem.exception.TravelAgencyNotFound;
import com.spring.boot.TravelPlanningSystem.exception.TripNotFound;
import com.spring.boot.TravelPlanningSystem.exception.UserNotFound;
import com.spring.boot.TravelPlanningSystem.exception.UsersNotFound;
import com.spring.boot.TravelPlanningSystem.util.ResponseStructure;


@Service
public class UserService
{
	@Autowired
	UserDao dao;
	
	@Autowired
	TripDao tdao;
	
	@Autowired
	TravelAgencyDao taDao;
	
	//save user
	public ResponseEntity<ResponseStructure<UserDto>> saveUser(User user)
	{
		UserDto dto = new UserDto();
		User savedUser = dao.saveUser(user);
		ModelMapper mapper = new ModelMapper();
		mapper.map(savedUser,dto);
		ResponseStructure<UserDto> structure = new ResponseStructure<>();
	    structure.setMessage("User save success..!");
	    structure.setStatus(HttpStatus.CREATED.value());
	    structure.setData(dto);
	    return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.CREATED);
	}
	
	//find user
    public ResponseEntity<ResponseStructure<UserDto>> findUser(int userId)
    {
        UserDto dto = new UserDto();
    	User user = dao.findUser(userId);
    	if(user != null)
    	{
    		ModelMapper mapper = new ModelMapper();
    		mapper.map(user,dto);
    		ResponseStructure<UserDto> structure = new ResponseStructure<>();
    		structure.setMessage("User found..!");
        	structure.setStatus(HttpStatus.FOUND.value());
        	structure.setData(dto);	
        	return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.FOUND);
    	}
    	throw new UserNotFound("User does not Found");
    }
    
    //delete user
    public ResponseEntity<ResponseStructure<UserDto>> deleteUser(int userId)
    {
    	UserDto dto = new UserDto();
    	User user = dao.deleteUser(userId);
    	if(user != null)
    	{
    		ModelMapper mapper = new ModelMapper();
    		mapper.map(user,dto);
    		ResponseStructure<UserDto> structure = new ResponseStructure<>();
    		structure.setMessage("User delete success");
    		structure.setStatus(HttpStatus.OK.value());
    		structure.setData(dto);
    		return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.OK);
    	}
    	throw new UserNotFound("User does not Found");
    }
    
    //update user
    public ResponseEntity<ResponseStructure<UserDto>> updateUser(User user,int userId)
    {
    	UserDto dto = new UserDto();
    	User exUser = dao.updateUser(user, userId);
    	if(exUser != null)
    	{
    		ModelMapper mapper = new ModelMapper();
    		mapper.map(exUser,dto);
    		ResponseStructure<UserDto> structure = new ResponseStructure<>();
    		structure.setMessage("User update success..!");
    		structure.setStatus(HttpStatus.OK.value());
            structure.setData(dto);
            return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.OK);
    	}
    	throw new UserNotFound("User does not Found");
    }
    
    //find all users
    public ResponseEntity<ResponseStructure<List<User>>> findAllUsers()
    {
    	List<User> users = dao.findAllUsers();
    	if(users.isEmpty())
    	{
    		ResponseStructure<List<User>> structures = new ResponseStructure<>();
        	structures.setMessage("users found..!");
        	structures.setStatus(HttpStatus.FOUND.value());
        	structures.setData(users);
        	return new ResponseEntity<ResponseStructure<List<User>>>(structures,HttpStatus.FOUND);
    	}
    	throw new UsersNotFound("Users does not Found");
    }
    
  //assign trip to user
  	public ResponseEntity<ResponseStructure<User>> assignTripToUser(int tripId,int userId)
  	{
  		Trip trip = tdao.findTrip(tripId);
  		User user = dao.findUser(userId);
  		
  		if(trip != null)
  		{
  			if(user != null)
  			{
  				user.getUserTrips().add(trip);
  			    User updatedUser = dao.updateUser(user, user.getUserId());
  				ResponseStructure<User> structure = new ResponseStructure<>();
  				structure.setData(updatedUser);
  				structure.setMessage("trip assigned.!");
  				structure.setStatus(HttpStatus.OK.value());
  				return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
  			}
  			throw new UserNotFound("User does not Found");
  		}
  		throw new TripNotFound("Trip does not Found");	
  	}	
      
  	
    //assign travel agency to user
  	public ResponseEntity<ResponseStructure<User>> assignAgencyToUser(int travelAgencyId,int userId)
  	{
  		TravelAgency travelAgency = taDao.findTravelAgency(travelAgencyId);
  		User user = dao.findUser(userId);
  		
  		if(travelAgency != null)
  		{
  			if(user != null)
  			{
  				user.setTravelAgency(travelAgency);
  			    User updatedUser = dao.updateUser(user, user.getUserId());
  				ResponseStructure<User> structure = new ResponseStructure<>();
  				structure.setData(updatedUser);
  				structure.setMessage("travel agency assigned.!");
  				structure.setStatus(HttpStatus.OK.value());
  				return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
  			}
  			throw new UserNotFound("User does not Found");
  		}
  		throw new TravelAgencyNotFound("TravelAgency does not Found");	
  	}	
  	
  	//find by email
  	public ResponseEntity<ResponseStructure<UserDto>> findByEmail(String userEmail)
  	{
		ResponseStructure<UserDto> structure = new ResponseStructure<>();
		User user = dao.findByEmail(userEmail);
		UserDto dto = new UserDto();
		if(user != null)
		{
			ModelMapper mapper = new ModelMapper();
    		mapper.map(user,dto);
			structure.setMessage("User found..!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.OK);
		}
		throw new UserNotFound("User does not Found");
	}
  	
  	//user login
  	public ResponseEntity<ResponseStructure<User>> loginUser(String userEmail,String userPassword) 
  	{
  		User user = dao.findByEmail(userEmail);
  		UserDto dto = new UserDto();
  		
		if (user != null)
		{ 
	        if (user.getUserEmail().equals(userEmail) && user.getUserPassword().equals(userPassword))
	        {
	            ResponseStructure<User> structure = new ResponseStructure<>();
	            structure.setMessage("Login success..!");
	            structure.setStatus(HttpStatus.OK.value());
	            return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	        }
	        ResponseStructure<User> errorStructure = new ResponseStructure<User>();
		    errorStructure.setMessage(userPassword);
		    errorStructure.setStatus(HttpStatus.UNAUTHORIZED.value());
		    return new ResponseEntity<ResponseStructure<User>>(errorStructure, HttpStatus.UNAUTHORIZED);
	    }
		throw new UserNotFound("User does not exist");
	}
  	
}
