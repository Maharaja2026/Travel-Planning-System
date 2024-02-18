package com.spring.boot.TravelPlanningSystem.exception;

public class DestinationReviewsNotFound extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public DestinationReviewsNotFound(String message) {
		this.message = message;
	}

}
