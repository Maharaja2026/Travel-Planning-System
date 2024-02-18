package com.spring.boot.TravelPlanningSystem.exception;

public class ItineraryItemsNotFound extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public ItineraryItemsNotFound(String message) {
		this.message = message;
	}

}
