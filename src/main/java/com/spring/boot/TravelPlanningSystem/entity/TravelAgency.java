package com.spring.boot.TravelPlanningSystem.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Component
public class TravelAgency 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int travelAgencyId;
	private String travelAgencyName;
	private long travelAgencyContact;
	private String travelAgencyEmail;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Trip> trips;

}
