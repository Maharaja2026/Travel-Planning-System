package com.spring.boot.TravelPlanningSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.TravelPlanningSystem.entity.DestinationReview;

public interface DestinationReviewRepository extends JpaRepository<DestinationReview, Integer>
{

}
