package com.spring.boot.TravelPlanningSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.TravelPlanningSystem.entity.DestinationReview;
import com.spring.boot.TravelPlanningSystem.repo.DestinationReviewRepository;

@Repository
public class DestinationReviewDao
{
	@Autowired
	DestinationReviewRepository repo;

	public DestinationReview saveDestinationReview(DestinationReview destinationReview)
	{
		return repo.save(destinationReview);
	}
	
	public DestinationReview findDestinationReview(int destinationReviewId)
	{
		Optional<DestinationReview> opDestinationReview = repo.findById(destinationReviewId);
		if(opDestinationReview.isPresent())
		{
			return opDestinationReview.get();
		}
		return null;
	}
	
	public DestinationReview deleteDestinationReview(int destinationReviewId)
	{
		DestinationReview destinationReview = findDestinationReview(destinationReviewId);
		repo.delete(destinationReview);
		return destinationReview;
	}
	
	public DestinationReview upadteDestinationReview(DestinationReview destinationReview,int destinationReviewId)
	{
		DestinationReview exDestinationReview = findDestinationReview(destinationReviewId);
		if(exDestinationReview != null)
		{
			destinationReview.setDestinationReviewId(destinationReviewId);
			return repo.save(destinationReview);
		}
		return null;
	}
	
	public List<DestinationReview> findAllDestinationReviews()
	{
		return repo.findAll();
	}
}















