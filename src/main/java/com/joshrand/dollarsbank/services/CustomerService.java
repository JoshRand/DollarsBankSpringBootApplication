package com.joshrand.dollarsbank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshrand.dollarsbank.dao.AccountDao;
import com.joshrand.dollarsbank.model.Customer;

@Service
public class CustomerService
{

	@Autowired
	AccountDao aDao;
	
	public void saveCustomer(Customer cust)
	{
		aDao.save(cust);
	}
	public List<Customer> getAllCustomers()
	{
		return aDao.getAllAccounts();
	}
	
	
}
