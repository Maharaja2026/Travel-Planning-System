package com.spring.boot.TravelPlanningSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.TravelPlanningSystem.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer>
{

}
