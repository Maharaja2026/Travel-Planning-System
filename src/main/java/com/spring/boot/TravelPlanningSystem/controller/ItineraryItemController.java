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

import com.spring.boot.TravelPlanningSystem.entity.ItineraryItem;
import com.spring.boot.TravelPlanningSystem.service.ItineraryItemService;
import com.spring.boot.TravelPlanningSystem.util.ResponseStructure;

@RestController
@RequestMapping("itineraryitem")
public class ItineraryItemController
{
	@Autowired
	ItineraryItemService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<ItineraryItem>> saveItineraryItem(@RequestBody ItineraryItem itineraryItem)
	{
		return service.saveItineraryItem(itineraryItem);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<ItineraryItem>> findItineraryItem(@RequestParam int itineraryItemId)
	{
		return service.findItineraryItem(itineraryItemId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<ItineraryItem>> deleteItineraryItem(@RequestParam int itineraryItemId)
	{
		return service.deleteItineraryItem(itineraryItemId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<ItineraryItem>> updateItineraryItem(@RequestBody ItineraryItem itineraryItem,@RequestParam int itineraryItemId)
	{
		return service.updateItineraryItem(itineraryItem, itineraryItemId);
	}
	
	@GetMapping("findall")
	public ResponseEntity<ResponseStructure<List<ItineraryItem>>> findAllItineraryItems()
	{
		return service.findALlItineraryItems();
	}
	
}
