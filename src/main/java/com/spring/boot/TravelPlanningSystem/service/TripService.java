package com.spring.boot.TravelPlanningSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.boot.TravelPlanningSystem.dao.TripDao;
import com.spring.boot.TravelPlanningSystem.dao.UserDao;
import com.spring.boot.TravelPlanningSystem.entity.AccommodationType;
import com.spring.boot.TravelPlanningSystem.entity.TransportationMode;
import com.spring.boot.TravelPlanningSystem.entity.Trip;
import com.spring.boot.TravelPlanningSystem.entity.User;
import com.spring.boot.TravelPlanningSystem.util.ResponseStructure;

@Service
public class TripService 
{
	@Autowired
	TripDao dao;
	
	@Autowired
	UserDao udao;

	//save trip
	public ResponseEntity<ResponseStructure<Trip>> saveTrip(int userId,Trip trip,int transportValue,int value)
	{
		User user = udao.findUser(userId);
		if(user != null)
		{
			trip.setUser(user);
			List<Trip> userTrips = findAllTripsByUser(user.getUserId()); 
			user.setTrips(userTrips);
			udao.updateUser(user, user.getUserId());
			trip.setTransportationMode(saveTransportationMode(transportValue));
		    trip.setAccommodationType(saveAccomaodationType(value));
			ResponseStructure<Trip> structure = new ResponseStructure<>();
			structure.setMessage("Trip save success..!");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.saveTrip(trip));
			return new ResponseEntity<ResponseStructure<Trip>>(structure,HttpStatus.CREATED);
		}
		return null;	
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
	
	//find all trips
	public ResponseEntity<ResponseStructure<List<Trip>>> findAllTrips()
	{
		List<Trip> trips = dao.findAllTrips();
		ResponseStructure<List<Trip>> structure = new ResponseStructure<>();
		structure.setMessage("Trips found..!");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(trips);
		return new ResponseEntity<ResponseStructure<List<Trip>>>(structure,HttpStatus.FOUND);
	}
	
	//---------------------------------------------------------------
	
	//find all trips by user
	public List<Trip> findAllTripsByUser(int userId)
	{
		List<Trip> allTrips = dao.findAllTrips();
		List<Trip> userTrips = new ArrayList<>();
		for(Trip trip : allTrips)
		{
			if(trip.getUser() != null)
			{
				if(trip.getUser().equals(udao.findUser(userId)))
					userTrips.add(trip);	
			}
			else
				return null;
		}
		return userTrips;
	}
	
	
	//save AccommodationType
	public AccommodationType saveAccomaodationType(int value)
	{
		AccommodationType accommodationType = null;
		switch(value)
		{
		case 0 : accommodationType = AccommodationType.AIRBNB;break;
		case 1 : accommodationType = AccommodationType.HOSTEL;break;
		case 2 : accommodationType = AccommodationType.HOTEL;break;
		default : //AccommodationType does not exist
		}
		return accommodationType;
	}
	
	//save TransportationMode
	public TransportationMode saveTransportationMode(int transportValue)
	{
		TransportationMode transportationMode = null;
	
		switch(transportValue)
		{
		case 0 : transportationMode = TransportationMode.BUS;break;
		case 1 : transportationMode = TransportationMode.CAR_RENTAL;break;
		case 2 : transportationMode = TransportationMode.FLIGHT;break;
		case 3 : transportationMode = TransportationMode.TRAIN;break;
		default : //AccommodationType does not exist
		}
		return transportationMode;
	}
	
	
	
}
