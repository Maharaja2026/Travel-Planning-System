package com.spring.boot.TravelPlanningSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.boot.TravelPlanningSystem.dao.ExpenseDao;
import com.spring.boot.TravelPlanningSystem.entity.Expense;
import com.spring.boot.TravelPlanningSystem.util.ResponseStructure;

@Service
public class ExpenseService
{
	@Autowired
	ExpenseDao dao;

	public ResponseEntity<ResponseStructure<Expense>> saveExpense(Expense expense)
	{
		ResponseStructure<Expense> structure = new ResponseStructure<>();
		structure.setMessage("Expense save success..!");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveExpense(expense));
		return new ResponseEntity<ResponseStructure<Expense>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Expense>> findExpense(int expenseId)
	{
		Expense expense = dao.findExpense(expenseId);
		if(expense != null)
		{
			ResponseStructure<Expense> structure = new ResponseStructure<>();
			structure.setMessage("Expense found..!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(expense);
			return new ResponseEntity<ResponseStructure<Expense>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Expense>> deleteExpense(int expenseId)
	{
		Expense expense = dao.findExpense(expenseId);
		if(expense != null)
		{
			ResponseStructure<Expense> structure = new ResponseStructure<>();
			structure.setMessage("Expense delete success..!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteExpense(expense.getExpenseId()));
			return new ResponseEntity<ResponseStructure<Expense>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Expense>> updateExpense(Expense expense,int expenseId)
	{
		Expense exiExpense = dao.findExpense(expenseId);
		if(exiExpense != null)
		{
			ResponseStructure<Expense> structure = new ResponseStructure<>();
			structure.setMessage("Expense update success..!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateExpense(expense,exiExpense.getExpenseId()));
			return new ResponseEntity<ResponseStructure<Expense>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<List<Expense>>> findAllExpenses()
	{
		List<Expense> expenses = dao.findAllExpenses();
		ResponseStructure<List<Expense>> structure = new ResponseStructure<>(); 
		structure.setMessage("Expenses found..!");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(expenses);
		return new ResponseEntity<ResponseStructure<List<Expense>>>(structure,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
}
