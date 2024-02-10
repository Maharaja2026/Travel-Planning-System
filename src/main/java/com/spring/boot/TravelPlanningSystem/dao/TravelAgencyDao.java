package com.spring.boot.TravelPlanningSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.TravelPlanningSystem.entity.TravelAgency;
import com.spring.boot.TravelPlanningSystem.repo.TravelAgencyRepository;

@Repository
public class TravelAgencyDao 
{
	@Autowired
	TravelAgencyRepository repo;
	
	public TravelAgency saveTravelAgency(TravelAgency travelAgency)
	{
		return repo.save(travelAgency);
	}
	
	public TravelAgency findTravelAgency(int travelAgencyId)
	{
		Optional<TravelAgency> opTravelAgency = repo.findById(travelAgencyId);
		if(opTravelAgency.isPresent())
		{
			return opTravelAgency.get();
		}
		return null;
	}
	
	public TravelAgency deleteTravelAgency(int travelAgencyId)
	{
		TravelAgency travelAgency = findTravelAgency(travelAgencyId);
		repo.delete(travelAgency);
		return travelAgency;
	}
	
	public TravelAgency updateTravelAgency(TravelAgency travelAgency,int travelAgencyId)
	{
		TravelAgency exTravelAgency = findTravelAgency(travelAgencyId);
		if(exTravelAgency != null)
		{
			travelAgency.setTravelAgencyId(travelAgencyId);
			return repo.save(travelAgency);
		}
		return null;
	}
	
	public List<TravelAgency> findAllTravelAgencies()
	{
		return repo.findAll();
	}
	
	
	
	
	
	
	
	
	
	

}
