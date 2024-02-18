package com.spring.boot.TravelPlanningSystem.exception;

public class TripNotFound extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public TripNotFound(String message) {
		this.message = message;
	}

}
