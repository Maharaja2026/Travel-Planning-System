package com.spring.boot.TravelPlanningSystem.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Component
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@NotBlank(message = "User name cannot be blank")
	@NotNull(message = "User name cannot be null")
	private String userName;
	@Email
	private String userEmail;
	@Min(value = 6000000000L)
	@Max(value = 9999999999L)
	private long userContact;
	@NotBlank(message = "Password cannot be blank")
	@NotNull(message = "Password cannot be null")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*+=_-]).{8,}$", message = "Enter the valid password!")
	private String userPassword;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Trip> userTrips;
	
	@OneToOne(cascade = CascadeType.ALL)
	private TravelAgency travelAgency;
}
