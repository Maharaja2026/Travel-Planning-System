package com.spring.boot.TravelPlanningSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.TravelPlanningSystem.entity.Trip;

public interface TripRepository extends JpaRepository<Trip, Integer>
{

}
