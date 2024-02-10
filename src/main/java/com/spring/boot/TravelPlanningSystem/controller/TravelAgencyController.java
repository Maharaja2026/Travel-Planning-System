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

import com.spring.boot.TravelPlanningSystem.entity.TravelAgency;
import com.spring.boot.TravelPlanningSystem.service.TravelAgencyService;
import com.spring.boot.TravelPlanningSystem.util.ResponseStructure;

@RestController
@RequestMapping("travelagency")
public class TravelAgencyController 
{
	@Autowired
	TravelAgencyService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<TravelAgency>> saveTravelAgency(@RequestBody TravelAgency travelAgency)
	{
		return service.saveTravelAgency(travelAgency);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<TravelAgency>> findTravelAgency(@RequestParam int travelAgencyId)
	{
		return service.findTravelAgency(travelAgencyId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<TravelAgency>> deleteTravelAgency(@RequestParam int travelAgencyId)
	{
		return service.deleteTravelAgency(travelAgencyId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<TravelAgency>> updateTravelAgency(@RequestBody TravelAgency travelAgency,@RequestParam int travelAgencyId)
	{
		return service.updateTravelAgency(travelAgency, travelAgencyId);
	}
	
	@GetMapping("findall")
	public ResponseEntity<ResponseStructure<List<TravelAgency>>> findAllTravelAgencies()
	{
		return service.findAllTravelAgencies();
	}
}
