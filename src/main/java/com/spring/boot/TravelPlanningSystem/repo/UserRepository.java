package com.spring.boot.TravelPlanningSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.TravelPlanningSystem.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>
{

}
