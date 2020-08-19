package com.joshrand.dollarsbank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joshrand.dollarsbank.model.Customer;
import com.joshrand.dollarsbank.repo.AccountRepo;
@Component
public class AccountDaoImpl implements AccountDao
{
	@Autowired
	AccountRepo aRepo;

	@Override
	public String update(Customer cust) 
	{
		aRepo.save(cust);
		return "Updated Balance";
		
	}

	@Override
	public int delete(int id) {
		int status = 0;
		
		return status;
	}

	@Override
	public void save(Customer cust) {
		
		aRepo.save(cust);
	}

	@Override
	public List<Customer> getAllAccounts() {
		return (List<Customer>) aRepo.findAll();
	}

	@Override
	public void saveHistory(String userId, String historyMessage)
	{
		
	}
	@Override
	public List<String> getHistory(String userId)
	{
		return null;
	}

	@Override
	public Customer getCustomerByUserId(String userId)
	{
		return aRepo.findByUserId(userId);
	}

	
}
