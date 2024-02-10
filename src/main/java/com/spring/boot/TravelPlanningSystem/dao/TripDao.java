package com.spring.boot.TravelPlanningSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.TravelPlanningSystem.entity.Trip;
import com.spring.boot.TravelPlanningSystem.repo.TripRepository;

@Repository
public class TripDao 
{
	@Autowired
	TripRepository repo;
	
	public Trip saveTrip(Trip trip)
	{
		return repo.save(trip);
	}
	
	public Trip findTrip(int tripId)
	{
		Optional<Trip> opTrip = repo.findById(tripId);
		if(opTrip.isPresent())
		{
			return opTrip.get();
		}
		return null;
	}

	public Trip deleteTrip(int tripId)
	{
		Trip trip = findTrip(tripId);
		repo.delete(trip);
		return trip;
	}
	
	public Trip updateTrip(Trip trip,int tripId)
	{
		Trip exTrip = findTrip(tripId);
		if(exTrip != null)
		{
			trip.setTripId(tripId);
			return repo.save(trip);
		}
		return null;
	}
	
	public List<Trip> findAllTrips()
	{
		return repo.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
