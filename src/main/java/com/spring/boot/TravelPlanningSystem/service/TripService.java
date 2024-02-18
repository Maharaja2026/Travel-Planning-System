package com.spring.boot.TravelPlanningSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.boot.TravelPlanningSystem.dao.DestinationReviewDao;
import com.spring.boot.TravelPlanningSystem.dao.ExpenseDao;
import com.spring.boot.TravelPlanningSystem.dao.ItineraryItemDao;
import com.spring.boot.TravelPlanningSystem.dao.TripDao;
import com.spring.boot.TravelPlanningSystem.entity.AccommodationType;
import com.spring.boot.TravelPlanningSystem.entity.DestinationReview;
import com.spring.boot.TravelPlanningSystem.entity.Expense;
import com.spring.boot.TravelPlanningSystem.entity.ItineraryItem;
import com.spring.boot.TravelPlanningSystem.entity.TransportationMode;
import com.spring.boot.TravelPlanningSystem.entity.Trip;
import com.spring.boot.TravelPlanningSystem.exception.DestinationReviewNotFound;
import com.spring.boot.TravelPlanningSystem.exception.ExpenseNotFound;
import com.spring.boot.TravelPlanningSystem.exception.ItineraryItemNotFound;
import com.spring.boot.TravelPlanningSystem.exception.TripNotFound;
import com.spring.boot.TravelPlanningSystem.exception.TripsNotFound;
import com.spring.boot.TravelPlanningSystem.util.ResponseStructure;

@Service
public class TripService 
{
	@Autowired
	TripDao dao;
	
	@Autowired
	ItineraryItemDao idao;
	
	@Autowired
	ExpenseDao edao;
	
	@Autowired
	DestinationReviewDao ddao;

	//save trip
	public ResponseEntity<ResponseStructure<Trip>> saveTrip(Trip trip)
	{
		ResponseStructure<Trip> structure = new ResponseStructure<>();
	    structure.setMessage("User save success..!");
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
		throw new TripNotFound("Trip does not Found");	
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
		throw new TripNotFound("Trip does not Found");
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
		throw new TripNotFound("Trip does not Found");
	}
	
	//find all trips
	public ResponseEntity<ResponseStructure<List<Trip>>> findAllTrips()
	{
		List<Trip> trips = dao.findAllTrips();
		if(trips.isEmpty())
		{
			ResponseStructure<List<Trip>> structure = new ResponseStructure<>();
			structure.setMessage("Trips found..!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(trips);
			return new ResponseEntity<ResponseStructure<List<Trip>>>(structure,HttpStatus.FOUND);
		}
		throw new TripsNotFound("Trips does not Found");
	}
	
	//assign Itineraryitems to trip
	public ResponseEntity<ResponseStructure<Trip>> assignItineraryItemsToTrip(int ItineraryItemId,int tripId)
	{
		ItineraryItem itineraryItem = idao.findItineraryItem(ItineraryItemId);
		Trip trip = dao.findTrip(tripId);
		
		if(itineraryItem != null)
		{
			if(trip != null)
			{
				trip.getItineraryItems().add(itineraryItem);
			    Trip updatedTrip = dao.updateTrip(trip, trip.getTripId());
				ResponseStructure<Trip> structure = new ResponseStructure<>();
				structure.setData(updatedTrip);
				structure.setMessage("ItineraryItem assigned.!");
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Trip>>(structure,HttpStatus.OK);
			}
			throw new TripNotFound("Trip does not Found");
		}
		throw new ItineraryItemNotFound("ItineraryItem does not Found");	
	}	
	
	//assign expense to trip
	public ResponseEntity<ResponseStructure<Trip>> assignExpenseToTrip(int expenseId,int tripId)
	{
		Expense expense = edao.findExpense(expenseId);
		Trip trip = dao.findTrip(tripId);
		
		if(expense != null)
		{
			if(trip != null)
			{
				trip.getExpenses().add(expense);
			    Trip updatedTrip = dao.updateTrip(trip, trip.getTripId());
				ResponseStructure<Trip> structure = new ResponseStructure<>();
				structure.setData(updatedTrip);
				structure.setMessage("Expense assigned.!");
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Trip>>(structure,HttpStatus.OK);
			}
			throw new TripNotFound("Trip does not Found");
		}
		throw new ExpenseNotFound("Expense does not exist");	
	}	
	
	//assign destination review to trip
	public ResponseEntity<ResponseStructure<Trip>> assignReviewToTrip(int destinationReviewId,int tripId)
	{
		DestinationReview destinationReview = ddao.findDestinationReview(destinationReviewId);
		Trip trip = dao.findTrip(tripId);
		
		if(destinationReview != null)
		{
			if(trip != null)
			{
				trip.getDestinationReviews().add(destinationReview);
			    Trip updatedTrip = dao.updateTrip(trip, trip.getTripId());
				ResponseStructure<Trip> structure = new ResponseStructure<>();
				structure.setData(updatedTrip);
				structure.setMessage("Destination review assigned.!");
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Trip>>(structure,HttpStatus.OK);
			}
			throw new TripNotFound("Trip does not Found");
		}
		throw new DestinationReviewNotFound("DestinationReview does not Found");	
	}	

	
	//assign accommodation type
	public ResponseEntity<ResponseStructure<Trip>> assignAccommodationType(int value,int tripId)
	{
		Trip trip = dao.findTrip(tripId);
		if(trip != null)
		{
			switch(value)
			{
			case 0 : trip.setAccommodationType(AccommodationType.AIRBNB);break;
			case 1 : trip.setAccommodationType(AccommodationType.HOSTEL);break;
			case 2 : trip.setAccommodationType(AccommodationType.HOTEL);break;
			default : //AccommodationType does not exist
			}
			Trip updatedTrip = dao.updateTrip(trip, trip.getTripId());
			ResponseStructure<Trip> structure = new ResponseStructure<>();
			structure.setMessage("assign accommodation type success..!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(updatedTrip);
			return new ResponseEntity<ResponseStructure<Trip>>(structure,HttpStatus.OK);
		}
		throw new TripNotFound("Trip does not Found");
	}
	
	//assign transportaion mode
	public ResponseEntity<ResponseStructure<Trip>> assignTransportationMode(int value,int tripId)
	{
		Trip trip = dao.findTrip(tripId);
		if(trip != null)
		{
			switch(value)
			{
			case 0 : trip.setTransportationMode(TransportationMode.BUS);break;
			case 1 : trip.setTransportationMode(TransportationMode.CAR_RENTAL);break;
			case 2 : trip.setTransportationMode(TransportationMode.FLIGHT);break;
			case 3 : trip.setTransportationMode(TransportationMode.TRAIN);break;
			default : //transportationMode does not exist
			}
			Trip updatedTrip = dao.updateTrip(trip, trip.getTripId());
			ResponseStructure<Trip> structure = new ResponseStructure<>();
			structure.setMessage("assign transportation mode success..!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(updatedTrip);
			return new ResponseEntity<ResponseStructure<Trip>>(structure,HttpStatus.OK);
		}
		throw new TripNotFound("Trip does not Found");
	}
	
}
