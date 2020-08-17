package com.joshrand.dollarsbank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.joshrand.dollarsbank.dao.AccountDao;
import com.joshrand.dollarsbank.model.Customer;


@Service
public class LoginService {
	
	@Autowired
	AccountDao accountDao;
	
	public boolean validateUser(String userid, String password) {
 		List<Customer> list = accountDao.getAllAccounts();
		
 		for (Customer cust : list)
		{
			if(userid.equals(cust.getUserId()) && password.equals(cust.getPassword()))
			{
				return true;
			}
		}
		
		return false;
	}

}
