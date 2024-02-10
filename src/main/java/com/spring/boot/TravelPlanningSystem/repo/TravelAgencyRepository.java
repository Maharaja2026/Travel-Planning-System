package com.spring.boot.TravelPlanningSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.TravelPlanningSystem.entity.TravelAgency;

public interface TravelAgencyRepository extends JpaRepository<TravelAgency, Integer>
{

}
