package com.spring.boot.TravelPlanningSystem.exception;

public class ExpensesNotFound extends RuntimeException
{
	String message;

	public String getMessage() {
		return message;
	}

	public ExpensesNotFound(String message) {
		this.message = message;
	}

}
