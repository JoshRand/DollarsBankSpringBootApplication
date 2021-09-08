package com.joshrand.dollarsbank.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import com.joshrand.dollarsbank.dao.AccountDao;
import com.joshrand.dollarsbank.dao.AccountDaoImpl;
import com.joshrand.dollarsbank.dao.TransactionsDao;
import com.joshrand.dollarsbank.dao.TransactionsDaoImpl;



@Entity
public class Customer extends SavingsAccount
{
	
	
	@Id
	@GeneratedValue
	private int id;
	private String userId;
	private String custName;
	private String custAddress;
	private String contactNumber;
	private double balance;
	private String password;
	private String sessionId;
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public double getBalance()
	{
		return balance;
	}
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	LocalDateTime ldt = LocalDateTime.now();
	@Autowired
	public Customer(String custName, String custAddress, String contactNumber, String userId, String password, double amount)
	{
		super();
		this.custName = custName;
		this.custAddress = custAddress;
		this.contactNumber = contactNumber;
		this.userId = (userId);
		this.password = (password);
		this.balance=(amount);
		ldt = LocalDateTime.now();
		
		/*
		 * if(customerDao.getHistory(getUserId()).size() == 0) {
		 * addToHistory("Initial Deposit Amount in account ["+userId+"]\n" +
		 * "Balance - " + amount + " as of " +ldt.getDayOfWeek()+" " +
		 * ldt.getMonth()+" "+ldt.getDayOfMonth()+" "+
		 * ldt.getHour()+":"+ldt.getMinute()+":"+ldt.getSecond() +" "
		 * +" "+ldt.getYear()); }
		 */
			
	}
	@Autowired
	public Customer()
	{
		super(); 
	}
	
	public Customer Clone()
	{
		return new Customer(this.custName, this.custAddress, this.contactNumber, this.userId, this.password, this.getBalance());
	}
	//TODO: Fix toString
	public String toString()
	{
		
		return "Customer [custName=" + custName + ", custAddress=" + custAddress + ", contactNumber=" + contactNumber
				+ "]"+ "{Account info [[ UserId= "+getUserId()+" " +"UserPass= " +getPassword()+ "] balance = " + getBalance()+"]  }";
	}
	
	public String getUserId()
	{
		return userId;
	}
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	public String getCustName()
	{
		return custName;
	}
	public void setCustName(String custName)
	{
		this.custName = custName;
	}
	public String getCustAddress()
	{
		return custAddress;
	}
	public void setCustAddress(String custAddress)
	{
		this.custAddress = custAddress;
	}
	public String getContactNumber()
	{
		return contactNumber;
	}
	public void setContactNumber(String contactNumber)
	{
		this.contactNumber = contactNumber;
	}
	public String getSessionId()
	{
		return sessionId;
	}
	public void setSessionId(String sessionId)
	{
		this.sessionId = sessionId;
	}
	
	
	
	
}
