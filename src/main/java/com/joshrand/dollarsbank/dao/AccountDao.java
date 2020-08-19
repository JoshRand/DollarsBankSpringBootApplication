package com.joshrand.dollarsbank.dao;

import java.util.List;

import com.joshrand.dollarsbank.model.Account;
import com.joshrand.dollarsbank.model.Customer;

public interface AccountDao
{
	public String update(Customer cust) ;
	public int delete(int id);
	public void save(Customer e);
	public void saveHistory(String userId, String historyMessage);
	public Customer getCustomerByUserId(String userId);
	public List<String> getHistory(String userId);
	public List<Customer> getAllAccounts();
}
