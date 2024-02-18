package com.spring.boot.TravelPlanningSystem.exception;

public class ItineraryItemNotFound extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public ItineraryItemNotFound(String message) {
		this.message = message;
	}

}
