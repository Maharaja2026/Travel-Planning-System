package com.spring.boot.TravelPlanningSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.boot.TravelPlanningSystem.dao.DestinationReviewDao;
import com.spring.boot.TravelPlanningSystem.dao.TripDao;
import com.spring.boot.TravelPlanningSystem.entity.DestinationReview;
import com.spring.boot.TravelPlanningSystem.exception.DestinationReviewNotFound;
import com.spring.boot.TravelPlanningSystem.exception.DestinationReviewsNotFound;
import com.spring.boot.TravelPlanningSystem.util.ResponseStructure;

@Service
public class DestinationReviewService 
{
	@Autowired
	DestinationReviewDao dao;
	
	@Autowired
	TripDao tdao;

	public ResponseEntity<ResponseStructure<DestinationReview>> saveDestinationReview(DestinationReview destinationReview)
	{
		ResponseStructure<DestinationReview> structure = new ResponseStructure<>();
	    structure.setMessage("Destination Review save success..!");
	    structure.setStatus(HttpStatus.CREATED.value());
	    structure.setData(dao.saveDestinationReview(destinationReview));
	    return new ResponseEntity<ResponseStructure<DestinationReview>>(structure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<DestinationReview>> findDestinationReview(int destinationReviewId)
	{
		DestinationReview destinationReview = dao.findDestinationReview(destinationReviewId);
		if(destinationReview != null)
		{
			ResponseStructure<DestinationReview> structure = new ResponseStructure<>();
			structure.setMessage("Destination Review found..!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(destinationReview);
			return new ResponseEntity<ResponseStructure<DestinationReview>>(structure,HttpStatus.FOUND);
		}
		throw new DestinationReviewNotFound("DestinationReview does not Found");	
	}
	
	public ResponseEntity<ResponseStructure<DestinationReview>> deleteDestinationReview(int destinationReviewId)
	{
		DestinationReview destinationReview = dao.findDestinationReview(destinationReviewId);
		if(destinationReview != null)
		{
			ResponseStructure<DestinationReview> structure = new ResponseStructure<>();
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("DestinationReview delete success..!");
			structure.setData(dao.deleteDestinationReview(destinationReview.getDestinationReviewId()));
			return new ResponseEntity<ResponseStructure<DestinationReview>>(structure,HttpStatus.OK);
		}
		throw new DestinationReviewNotFound("DestinationReview does not Found");
	}
	
	public ResponseEntity<ResponseStructure<DestinationReview>> updateDestinationReview(DestinationReview destinationReview,int destinationReviewId)
	{
		DestinationReview exDestinationReview = dao.findDestinationReview(destinationReviewId);
		if(exDestinationReview != null)
		{
			ResponseStructure<DestinationReview> structure = new ResponseStructure<>();
			structure.setData(dao.upadteDestinationReview(destinationReview, exDestinationReview.getDestinationReviewId()));
			structure.setMessage("DestinationReview update success..!");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<DestinationReview>>(structure,HttpStatus.OK);
		}
		throw new DestinationReviewNotFound("DestinationReview does not Found");
	}
	
	public ResponseEntity<ResponseStructure<List<DestinationReview>>> findAllDestinationReviews()
	{
		List<DestinationReview> destinationReviews = dao.findAllDestinationReviews();
		if(destinationReviews.isEmpty())
		{
			ResponseStructure<List<DestinationReview>> structure = new ResponseStructure<>();
			structure.setMessage("DestinationReviews Found..!");
			structure.setData(destinationReviews);
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<DestinationReview>>>(structure,HttpStatus.FOUND);
		}
		throw new DestinationReviewsNotFound("DestinationReviews does not Found");
	}
	
}
