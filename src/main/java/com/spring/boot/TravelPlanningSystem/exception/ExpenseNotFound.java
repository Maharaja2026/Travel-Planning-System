package com.spring.boot.TravelPlanningSystem.exception;

public class ExpenseNotFound extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public ExpenseNotFound(String message) {
		this.message = message;
	}

}
