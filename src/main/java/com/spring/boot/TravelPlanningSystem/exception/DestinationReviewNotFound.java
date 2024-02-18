package com.spring.boot.TravelPlanningSystem.exception;

public class DestinationReviewNotFound extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public DestinationReviewNotFound(String message) {
		this.message = message;
	}

}
