package com.spring.boot.TravelPlanningSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.TravelPlanningSystem.entity.ItineraryItem;

public interface ItineraryItemRepository extends JpaRepository<ItineraryItem, Integer>
{

}
