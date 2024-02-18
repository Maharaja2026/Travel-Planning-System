package com.spring.boot.TravelPlanningSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.boot.TravelPlanningSystem.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
	@Query("select u from User u where u.userEmail= ?1")
	User findByuserEmail(String userEmail);
}
