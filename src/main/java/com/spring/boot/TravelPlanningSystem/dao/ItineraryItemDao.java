package com.spring.boot.TravelPlanningSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.TravelPlanningSystem.entity.ItineraryItem;
import com.spring.boot.TravelPlanningSystem.repo.ItineraryItemRepository;

@Repository
public class ItineraryItemDao 
{
	@Autowired
	ItineraryItemRepository repo;

	public ItineraryItem saveItineraryItem(ItineraryItem itineraryItem)
	{
		return repo.save(itineraryItem);
	}
	
	public ItineraryItem findItineraryItem(int itineraryItemId)
	{
		Optional<ItineraryItem> opItineraryItem = repo.findById(itineraryItemId);
		if(opItineraryItem.isPresent())
		{
			return opItineraryItem.get();
		}
		return null;
	}
	
	public ItineraryItem deleteItineraryItem(int itineraryItemId)
	{
		ItineraryItem itineraryItem = findItineraryItem(itineraryItemId);
		repo.delete(itineraryItem);
		return itineraryItem;
	}
	
	public ItineraryItem updateItineraryItem(ItineraryItem itineraryItem,int itineraryItemId)
	{
		ItineraryItem exItineraryItem = findItineraryItem(itineraryItemId);
		if(exItineraryItem != null)
		{
			itineraryItem.setItineraryItemId(itineraryItemId);
			return repo.save(itineraryItem);
		}
		return null;
	}
	
	public List<ItineraryItem> findAllItineraryItems()
	{
		return repo.findAll();
	}
	
	
	
}
