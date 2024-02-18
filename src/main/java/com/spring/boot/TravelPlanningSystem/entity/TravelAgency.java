package com.spring.boot.TravelPlanningSystem.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	@NotBlank(message = "Travel agency name cannot be blank")
	@NotNull(message = "Travel agency cannot be null")
	private String travelAgencyName;
	@Min(value = 6000000000L)
	@Max(value = 9999999999L)
	private long travelAgencyContact;
	@Email
	private String travelAgencyEmail;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Trip> trips;
	
}
