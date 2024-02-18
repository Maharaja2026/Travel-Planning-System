package com.spring.boot.TravelPlanningSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.TravelPlanningSystem.entity.Trip;
import com.spring.boot.TravelPlanningSystem.service.TripService;
import com.spring.boot.TravelPlanningSystem.util.ResponseStructure;

@RestController
@RequestMapping("trip")
public class TripController 
{
	@Autowired
	TripService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<Trip>> saveTrip(@RequestBody Trip trip)
	{
		return service.saveTrip(trip);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Trip>> findTrip(@RequestParam int tripId)
	{
		return service.findTrip(tripId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Trip>> deleteTrip(@RequestParam int tripId)
	{
		return service.deleteTrip(tripId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Trip>> updateTrip(@RequestBody Trip trip,@RequestParam int tripId)
	{
		return service.updateTrip(trip, tripId);
	}
	
	@GetMapping("findall")
	public ResponseEntity<ResponseStructure<List<Trip>>> findAllTrips()
	{
		return service.findAllTrips();
	}
	
	@PutMapping("assignItem")
	public ResponseEntity<ResponseStructure<Trip>> assignItineraryItemToTrip(@RequestParam int itineraryItemId,@RequestParam int tripId)
	{
		return service.assignItineraryItemsToTrip(itineraryItemId, tripId);
	}
	
	@PutMapping("assignExpense")
	public ResponseEntity<ResponseStructure<Trip>> assignExpenseToTrip(@RequestParam int expenseId,@RequestParam int tripId)
	{
		return service.assignExpenseToTrip(expenseId, tripId);
	}
	
	@PutMapping("assignReview")
	public ResponseEntity<ResponseStructure<Trip>> assignReviewToTrip(@RequestParam int destinationReviewId,@RequestParam int tripId)
	{
		return service.assignReviewToTrip(destinationReviewId, tripId);
	}
	
	@PutMapping("assignAccommodation")
	public ResponseEntity<ResponseStructure<Trip>> assignAccommodationToTrip(@RequestParam int value,@RequestParam int tripId)
	{
		return service.assignAccommodationType(value, tripId);
	}
	
	@PutMapping("assignTransportation")
	public ResponseEntity<ResponseStructure<Trip>> assignTransportationToTrip(@RequestParam int value,@RequestParam int tripId)
	{
		return service.assignTransportationMode(value, tripId);
	}
}
