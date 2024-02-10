package com.spring.boot.TravelPlanningSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.TravelPlanningSystem.entity.Expense;
import com.spring.boot.TravelPlanningSystem.service.ExpenseService;
import com.spring.boot.TravelPlanningSystem.util.ResponseStructure;

@RestController
@RequestMapping("expense")
public class ExpenseController 
{
	@Autowired
	ExpenseService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Expense>> saveExpense(@RequestBody Expense expense)
	{
		return service.saveExpense(expense);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Expense>> findExpense(@RequestParam int expenseId)
	{
		return service.findExpense(expenseId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Expense>> deleteExpense(@RequestParam int expenseId)
	{
		return service.deleteExpense(expenseId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Expense>> updateExpense(@RequestBody Expense expense,@RequestParam int expenseId)
	{
		return service.updateExpense(expense, expenseId);
	}
	
	@GetMapping("findall")
	public ResponseEntity<ResponseStructure<List<Expense>>> findAllExpenses()
	{
		return service.findAllExpenses();
	}

}
