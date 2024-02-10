package com.spring.boot.TravelPlanningSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.boot.TravelPlanningSystem.dao.ItineraryItemDao;
import com.spring.boot.TravelPlanningSystem.entity.ItineraryItem;
import com.spring.boot.TravelPlanningSystem.util.ResponseStructure;

@Service
public class ItineraryItemService
{
	@Autowired
	ItineraryItemDao dao;
	
	public ResponseEntity<ResponseStructure<ItineraryItem>> saveItineraryItem(ItineraryItem itineraryItem)
	{
		ResponseStructure<ItineraryItem> structure = new ResponseStructure<>();
		structure.setMessage("ItineraryItem save success..!");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveItineraryItem(itineraryItem));
		return new ResponseEntity<ResponseStructure<ItineraryItem>>(structure,HttpStatus.CREATED);
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
	
	public ResponseEntity<ResponseStructure<List<ItineraryItem>>> findALlItineraryItems()
	{
		List<ItineraryItem> itineraryItems = dao.findAllItineraryItems();
		ResponseStructure<List<ItineraryItem>> structure = new ResponseStructure<>();
		structure.setMessage("ItineraryItems found..!");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(itineraryItems);
		return new ResponseEntity<ResponseStructure<List<ItineraryItem>>>(structure,HttpStatus.FOUND);
	}
	
}

