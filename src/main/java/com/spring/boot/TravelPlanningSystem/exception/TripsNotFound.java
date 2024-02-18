package com.spring.boot.TravelPlanningSystem.exception;

public class TripsNotFound extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public TripsNotFound(String message) {
		this.message = message;
	}

}