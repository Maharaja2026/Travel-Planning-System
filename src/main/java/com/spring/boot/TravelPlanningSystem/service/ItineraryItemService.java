package com.spring.boot.TravelPlanningSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.boot.TravelPlanningSystem.dao.ItineraryItemDao;
import com.spring.boot.TravelPlanningSystem.dao.TripDao;
import com.spring.boot.TravelPlanningSystem.entity.ItineraryItem;
import com.spring.boot.TravelPlanningSystem.entity.Trip;
import com.spring.boot.TravelPlanningSystem.util.ResponseStructure;

@Service
public class ItineraryItemService
{
	@Autowired
	ItineraryItemDao dao;
	
	@Autowired
	TripDao tdao;
	
	public ResponseEntity<ResponseStructure<ItineraryItem>> saveItineraryItem(int tripId,ItineraryItem itineraryItem)
	{
		Trip trip = tdao.findTrip(tripId);
		if(trip != null)
		{
			List<ItineraryItem> tripItineraryItems = findAllItineraryItemsByTrip(tripId);
//			trip.getItineraryItems().add(itineraryItem);
			trip.setItineraryItems(tripItineraryItems);
			tdao.updateTrip(trip, tripId);
			itineraryItem.setTrip(trip);
			ResponseStructure<ItineraryItem> structure = new ResponseStructure<>();
			structure.setMessage("ItineraryItem save success..!");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.saveItineraryItem(itineraryItem));
			return new ResponseEntity<ResponseStructure<ItineraryItem>>(structure,HttpStatus.CREATED);
		}
		return null; //trip does not exist
	}
	
	public ResponseEntity<ResponseStructure<ItineraryItem>> findItineraryItem(int itineraryItemId)
	{
		ItineraryItem itineraryItem = dao.findItineraryItem(itineraryItemId);
		if(itineraryItem != null)
		{
			ResponseStructure<ItineraryItem> structure = new ResponseStructure<>();
			structure.setMessage("ItineraryItem found..!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(itineraryItem);
			return new ResponseEntity<ResponseStructure<ItineraryItem>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<ItineraryItem>> deleteItineraryItem(int itineraryItemId)
	{
		ItineraryItem itineraryItem = dao.findItineraryItem(itineraryItemId);
		if(itineraryItem != null)
		{
			ResponseStructure<ItineraryItem> structure = new ResponseStructure<>();
			structure.setMessage("ItineraryItem delete success..!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteItineraryItem(itineraryItem.getItineraryItemId()));
			return new ResponseEntity<ResponseStructure<ItineraryItem>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<ItineraryItem>> updateItineraryItem(ItineraryItem itineraryItem,int itineraryItemId)
	{
		ItineraryItem exItineraryItem = dao.findItineraryItem(itineraryItemId);
		if(exItineraryItem != null)
		{
			ResponseStructure<ItineraryItem> structure = new ResponseStructure<>();
			structure.setMessage("ItineraryItem update success..!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateItineraryItem(itineraryItem, exItineraryItem.getItineraryItemId()));
			return new ResponseEntity<ResponseStructure<ItineraryItem>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	//find all Itineraryitems
	public ResponseEntity<ResponseStructure<List<ItineraryItem>>> findALlItineraryItems()
	{
		List<ItineraryItem> itineraryItems = dao.findAllItineraryItems();
		ResponseStructure<List<ItineraryItem>> structure = new ResponseStructure<>();
		structure.setMessage("ItineraryItems found..!");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(itineraryItems);
		return new ResponseEntity<ResponseStructure<List<ItineraryItem>>>(structure,HttpStatus.FOUND);
	}
	
	//find all Itineraryitems by trip
	public List<ItineraryItem> findAllItineraryItemsByTrip(int tripId)
	{
		List<ItineraryItem> allItineraryItems = dao.findAllItineraryItems();
		List<ItineraryItem> tripItineraryItems = new ArrayList<>();
		for(ItineraryItem itineraryItem : allItineraryItems)
		{
			if(itineraryItem.getTrip() != null)
			{
				if(itineraryItem.getTrip().equals(tdao.findTrip(tripId)))
				{
					tripItineraryItems.add(itineraryItem);
				}
			}
			else
				return null;
		}
		return tripItineraryItems;	
	}
	
	
}

