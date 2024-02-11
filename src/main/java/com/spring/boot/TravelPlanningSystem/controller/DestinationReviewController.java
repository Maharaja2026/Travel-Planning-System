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

import com.spring.boot.TravelPlanningSystem.entity.DestinationReview;
import com.spring.boot.TravelPlanningSystem.service.DestinationReviewService;
import com.spring.boot.TravelPlanningSystem.util.ResponseStructure;

@RestController
@RequestMapping("destinationreview")
public class DestinationReviewController 
{
	@Autowired
	DestinationReviewService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<DestinationReview>> saveDestinationReview(@RequestBody DestinationReview destinationReview)
	{
		return service.saveDestinationReview(destinationReview);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<DestinationReview>> findDestinationReview(@RequestParam int destinationReviewId)
	{
		return service.findDestinationReview(destinationReviewId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<DestinationReview>> deleteDestinationReview(@RequestParam int destinationReviewId)
	{
		return service.deleteDestinationReview(destinationReviewId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<DestinationReview>> updateDestinationReview(@RequestBody DestinationReview destinationReview,@RequestParam int destinationReviewId)
	{
		return service.updateDestinationReview(destinationReview, destinationReviewId);
	}
	
	@GetMapping("findall")
	public ResponseEntity<ResponseStructure<List<DestinationReview>>> findAllDestinationReviews()
	{
		return service.findAllDestinationReviews();			
	}

	
}
