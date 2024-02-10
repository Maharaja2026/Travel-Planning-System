package com.spring.boot.TravelPlanningSystem.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Component
public class Expense 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int expenseId;
	private String description;
	private double amount;
	private LocalDate expenseDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Trip trip;
}
