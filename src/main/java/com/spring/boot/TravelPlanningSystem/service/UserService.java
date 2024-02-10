package com.spring.boot.TravelPlanningSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.boot.TravelPlanningSystem.dao.UserDao;
import com.spring.boot.TravelPlanningSystem.entity.User;
import com.spring.boot.TravelPlanningSystem.util.ResponseStructure;


@Service
public class UserService
{
	@Autowired
	UserDao dao;
	
	//save user
	public ResponseEntity<ResponseStructure<User>> saveUser(User user)
	{
		ResponseStructure<User> structure = new ResponseStructure<>();
	    structure.setMessage("User save success..!");
	    structure.setStatus(HttpStatus.CREATED.value());
	    structure.setData(dao.saveUser(user));
	    return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
	}
	
	//find user
    public ResponseEntity<ResponseStructure<User>> findUser(int userId)
    {
    	User user = dao.findUser(userId);
    	if(user != null)
    	{
    		ResponseStructure<User> structure = new ResponseStructure<>();
    		structure.setMessage("User found..!");
        	structure.setStatus(HttpStatus.FOUND.value());
        	structure.setData(user);	
        	return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
    	}
    	return null; //user does not exist
    }
    
    //delete user
    public ResponseEntity<ResponseStructure<User>> deleteUser(int userId)
    {
    	User user = dao.findUser(userId);
    	if(user != null)
    	{
    		ResponseStructure<User> structure = new ResponseStructure<>();
    		structure.setMessage("User delete success");
    		structure.setStatus(HttpStatus.OK.value());
    		structure.setData(dao.deleteUser(user.getUserId()));
    		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
    	}
    	return null; // user does not exist
    }
    
    //update user
    public ResponseEntity<ResponseStructure<User>> updateUser(User user,int userId)
    {
    	User exUser = dao.findUser(userId);
    	if(exUser != null)
    	{
    		ResponseStructure<User> structure = new ResponseStructure<>();
    		structure.setMessage("User update success..!");
    		structure.setStatus(HttpStatus.OK.value());
            structure.setData(dao.updateUser(user,exUser.getUserId()));
            return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
    	}
    	return null; //user does not exist
    }
    
    //find all users
    public ResponseEntity<ResponseStructure<List<User>>> findAllUsers()
    {
    	List<User> users = dao.findAllUsers();
    	ResponseStructure<List<User>> structures = new ResponseStructure<>();
    	structures.setMessage("users found..!");
    	structures.setStatus(HttpStatus.FOUND.value());
    	structures.setData(users);
    	return new ResponseEntity<ResponseStructure<List<User>>>(structures,HttpStatus.FOUND);
    }
      
}
