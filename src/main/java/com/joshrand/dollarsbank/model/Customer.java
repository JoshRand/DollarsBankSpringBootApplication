package com.joshrand.dollarsbank.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import com.joshrand.dollarsbank.dao.AccountDao;
import com.joshrand.dollarsbank.dao.AccountDaoImpl;
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
		setUserId(userId);
		setPassword(password);
		setBalance(amount);
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
	
	//TODO: Fix toString
	public String toString()
	{
		
		return "Customer [custName=" + custName + ", custAddress=" + custAddress + ", contactNumber=" + contactNumber
				+ "]"+ "{Account info [[ UserId= "+getUserId()+" " +"UserPass= " +getPassword()+ "]]  }";
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
	
	
	
	
}