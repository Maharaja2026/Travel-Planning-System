package com.spring.boot.TravelPlanningSystem.exception;

public class UsersNotFound extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public UsersNotFound(String message) {
		this.message = message;
	}

}
