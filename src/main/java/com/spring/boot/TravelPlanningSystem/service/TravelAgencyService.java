package com.spring.boot.TravelPlanningSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.boot.TravelPlanningSystem.dao.TravelAgencyDao;
import com.spring.boot.TravelPlanningSystem.entity.TravelAgency;
import com.spring.boot.TravelPlanningSystem.util.ResponseStructure;

@Service
public class TravelAgencyService 
{
	@Autowired
	TravelAgencyDao dao;

	public ResponseEntity<ResponseStructure<TravelAgency>> saveTravelAgency(TravelAgency travelAgency)
	{
		
		
		ResponseStructure<TravelAgency> structure = new ResponseStructure<>();
		structure.setMessage("TravelAgency save success..!");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveTravelAgency(travelAgency));
		return new ResponseEntity<ResponseStructure<TravelAgency>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<TravelAgency>> findTravelAgency(int travelAgencyId)
	{
		TravelAgency travelAgency = dao.findTravelAgency(travelAgencyId);
		if(travelAgency != null)
		{
			ResponseStructure<TravelAgency> structure = new ResponseStructure<>();
			structure.setMessage("TravelAgency found..!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(travelAgency);
			return new ResponseEntity<ResponseStructure<TravelAgency>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<TravelAgency>> updateTravelAgency(TravelAgency travelAgency,int travelAgencyId)
	{
		TravelAgency exTravelAgency = dao.findTravelAgency(travelAgencyId);
		if(exTravelAgency != null)
		{
			ResponseStructure<TravelAgency> structure = new ResponseStructure<>();
			structure.setMessage("TravelAgency updated..!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateTravelAgency(travelAgency, exTravelAgency.getTravelAgencyId()));
			return new ResponseEntity<ResponseStructure<TravelAgency>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<TravelAgency>> deleteTravelAgency(int travelAgencyId)
	{
		TravelAgency travelAgency = dao.findTravelAgency(travelAgencyId);
		if(travelAgency != null)
		{
			ResponseStructure<TravelAgency> structure = new ResponseStructure<>();
			structure.setMessage("TravelAgency delete success..!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteTravelAgency(travelAgency.getTravelAgencyId()));
			return new ResponseEntity<ResponseStructure<TravelAgency>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<List<TravelAgency>>> findAllTravelAgencies()
	{
		List<TravelAgency> travelAgencies = dao.findAllTravelAgencies();
		ResponseStructure<List<TravelAgency>> structure = new ResponseStructure<>();
		structure.setMessage("TravelAgencies found..!");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(travelAgencies);
		return new ResponseEntity<ResponseStructure<List<TravelAgency>>>(structure,HttpStatus.FOUND);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
