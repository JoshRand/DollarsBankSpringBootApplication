package com.joshrand.dollarsbank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshrand.dollarsbank.dao.AccountDao;
import com.joshrand.dollarsbank.model.Customer;

@Service
public class TransactionService
{
	Customer cust = new Customer();
	@Autowired
	AccountDao aDao;
	public String transactionHandler(String name, String transferTo, String option, double amount)
	{
		String result = "Default Option";
		switch(option)
		{
		case "deposit":
			return depositHandler(name,amount);
		case "withdraw":
			return withdrawHandler(name,amount);
		case "transfer":
			return transferHandler(name,transferTo,amount);
		default:
			return result;
		}
		
		
	}

	private String depositHandler(String name, double amount)
	{	
		cust = aDao.getCustomerByUserId(name);
		System.out.println(cust.toString());
		cust.deposit(amount);
		cust.setBalance(cust.getBalance()+amount);
		System.out.println(amount);
		System.out.println(cust.toString());
		return aDao.update(cust);
	}

	private String withdrawHandler(String name, double amount)
	{
		cust = aDao.getCustomerByUserId(name);
		System.out.println(cust.toString());
		
		cust.setBalance(cust.getBalance()-amount);
		System.out.println(amount);
		System.out.println(cust.toString());
		return aDao.update(cust);
	}

	private String transferHandler(String name, String transferTo, double amount)
	{
		cust = aDao.getCustomerByUserId(name);
		System.out.println(cust.toString());
		Customer cust2 = aDao.getCustomerByUserId(transferTo);
		
		System.out.println(cust2.toString());
		cust.setBalance(cust.getBalance()-amount);
		System.out.println(amount);
		cust2.setBalance(cust2.getBalance()+amount);
		System.out.println(cust.toString());
		aDao.update(cust2);
		return aDao.update(cust);
	}


}
