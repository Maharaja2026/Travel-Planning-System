package com.spring.boot.TravelPlanningSystem.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Component
public class Trip 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tripId;
	private String destination;
	private LocalDate startDate;
	private LocalDate endDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<ItineraryItem> itineraryItems;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Expense> expenses;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<DestinationReview> destinationReviews;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private TravelAgency trevelAgency;
}
