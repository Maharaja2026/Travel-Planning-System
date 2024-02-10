package com.spring.boot.TravelPlanningSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.TravelPlanningSystem.entity.Expense;
import com.spring.boot.TravelPlanningSystem.repo.ExpenseRepository;

@Repository
public class ExpenseDao 
{
	@Autowired
	ExpenseRepository repo;

	public Expense saveExpense(Expense expense)
	{
		return repo.save(expense);
	}
	
	public Expense findExpense(int expenseId)
	{
		Optional<Expense> opExpense = repo.findById(expenseId);
		if(opExpense.isPresent())
		{
			return opExpense.get();
		}
		return null;
	}
	
	public Expense deleteExpense(int expenseId)
	{
		Expense expense = findExpense(expenseId);
		repo.delete(expense);
		return expense;
	}
	
	public Expense updateExpense(Expense expense, int expenseId)
	{
		Expense exExpense = findExpense(expenseId);
		if(exExpense != null)
		{
			expense.setExpenseId(expenseId);
			return repo.save(expense);
		}
		return null;
	}
	
	public List<Expense> findAllExpenses()
	{
		return repo.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
