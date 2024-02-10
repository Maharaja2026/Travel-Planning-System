package com.spring.boot.TravelPlanningSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.boot.TravelPlanningSystem.dao.TripDao;
import com.spring.boot.TravelPlanningSystem.entity.Trip;
import com.spring.boot.TravelPlanningSystem.util.ResponseStructure;

@Service
public class TripService 
{
	@Autowired
	TripDao dao;

	
	public ResponseEntity<ResponseStructure<Trip>> saveTrip(Trip trip)
	{
		ResponseStructure<Trip> structure = new ResponseStructure<>();
		structure.setMessage("Trip save success..!");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveTrip(trip));
		return new ResponseEntity<ResponseStructure<Trip>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Trip>> findTrip(int tripId)
	{
		Trip trip = dao.findTrip(tripId);
		if(trip != null)
		{
			ResponseStructure<Trip> structure = new ResponseStructure<>();
			structure.setMessage("Trip found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(trip);
			return new ResponseEntity<ResponseStructure<Trip>>(structure,HttpStatus.FOUND);
		}
		return null;	
	}
	
	public ResponseEntity<ResponseStructure<Trip>> deleteTrip(int tripId)
	{
		Trip trip = dao.findTrip(tripId);
		if(trip != null)
		{
			ResponseStructure<Trip> structure = new ResponseStructure<>();
			structure.setMessage("Trip delete success..!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteTrip(trip.getTripId()));
			return new ResponseEntity<ResponseStructure<Trip>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	
	public ResponseEntity<ResponseStructure<Trip>> updateTrip(Trip trip,int tripId)
	{
		Trip exTrip = dao.findTrip(tripId);
		if(exTrip != null)
		{
			ResponseStructure<Trip> structure = new ResponseStructure<>();
			structure.setMessage("Trip update success");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateTrip(trip, trip.getTripId()));
			return new ResponseEntity<ResponseStructure<Trip>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<List<Trip>>> findAllTrips()
	{
		List<Trip> trips = dao.findAllTrips();
		ResponseStructure<List<Trip>> structure = new ResponseStructure<>();
		structure.setMessage("Trips found..!");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(trips);
		return new ResponseEntity<ResponseStructure<List<Trip>>>(structure,HttpStatus.FOUND);
	}
}
