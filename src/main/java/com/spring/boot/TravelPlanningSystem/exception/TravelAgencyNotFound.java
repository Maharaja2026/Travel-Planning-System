package com.spring.boot.TravelPlanningSystem.exception;

public class TravelAgencyNotFound extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public TravelAgencyNotFound(String message) {
		this.message = message;
	}

}