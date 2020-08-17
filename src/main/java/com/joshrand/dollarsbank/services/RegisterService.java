package com.joshrand.dollarsbank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshrand.dollarsbank.dao.AccountDao;
import com.joshrand.dollarsbank.model.Customer;

@Service
public class RegisterService
{

	@Autowired
	AccountDao aDao;
	
	public boolean custExists(String uname) {
		List<Customer> custList =  aDao.getAllAccounts();
		if(custList == null)
		{
			System.out.println("cust list null");
		}
		else {
			
			for (Customer customer : custList)
			{
				if(customer.getUserId().equalsIgnoreCase(uname))
					return true;
			}
			
		}
		return false;
	}
	
	public void saveCustomer(Customer cust)
	{
		aDao.save(cust);
	}
	
}
