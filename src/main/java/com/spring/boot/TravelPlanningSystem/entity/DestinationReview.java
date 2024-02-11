package com.spring.boot.TravelPlanningSystem.entity;

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
public class DestinationReview
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int destinationReviewId;
	private String destination;
	private int rating;
	private String comments;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Trip trip;
	
}
