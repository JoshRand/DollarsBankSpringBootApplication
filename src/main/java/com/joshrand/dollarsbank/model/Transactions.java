package com.joshrand.dollarsbank.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Transactions
{

	@Id
	@GeneratedValue
	private int id;
	private String userId;
	private String description;
	private String transactionType;
	private LocalDateTime ldt = LocalDateTime.now();
	@Autowired
	public Transactions()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	@Autowired
	public Transactions(String userId, String description, String transactionType)
	{
		super();
		this.userId = userId;
		this.description = description;
		this.transactionType = transactionType;
	}
	public String getUserId()
	{
		return userId;
	}
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getTransactionType()
	{
		return transactionType;
	}
	public void setTransactionType(String transactionType)
	{
		this.transactionType = transactionType;
	}
	
}
