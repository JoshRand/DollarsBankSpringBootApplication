package com.joshrand.dollarsbank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshrand.dollarsbank.dao.AccountDao;
import com.joshrand.dollarsbank.dao.TransactionsDao;
import com.joshrand.dollarsbank.model.Customer;
import com.joshrand.dollarsbank.model.Transactions;

@Service
public class TransactionService
{
	Customer cust = new Customer();
	@Autowired
	AccountDao aDao;
	@Autowired
	TransactionsDao tDao;
	
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
		createTransaction(name,"Deposit",amount, cust.getBalance());
		return aDao.update(cust);
	}

	private String withdrawHandler(String name, double amount)
	{
		cust = aDao.getCustomerByUserId(name);
		System.out.println(cust.toString());
		if(cust.getBalance() < amount)
		{
			return "You can't withdraw that much, your balance is : $" + String.format("%.2f", cust.getBalance());
		}
		cust.setBalance(cust.getBalance()-amount);
		System.out.println(amount);
		System.out.println(cust.toString());
		createTransaction(name,"Withdraw",amount, cust.getBalance());
		return aDao.update(cust);
	}

	private String transferHandler(String name, String transferTo, double amount)
	{
		cust = aDao.getCustomerByUserId(name);
		System.out.println(cust.toString());
		Customer cust2 = aDao.getCustomerByUserId(transferTo);
		if(cust2 != null)
		{
			System.out.println(cust2.toString());
			cust.setBalance(cust.getBalance()-amount);
			System.out.println(amount);
			cust2.setBalance(cust2.getBalance()+amount);
			System.out.println(cust.toString());
			aDao.update(cust2);
			createTransaction(name,transferTo,"Transfer",amount, cust.getBalance(),cust2.getBalance());
			return aDao.update(cust);
		}
		return "Account Doesn't Exist";
		
	}

	
	private void createTransaction(String userId, String type, double amount, double balance)
	{
		Transactions trans;
		String descDepo = "Deposited $" + String.format("%.2f",amount) + " into account "+userId+" " + "Balance - $" + String.format("%.2f",balance);
		String descWith = "Withdrawn $" + String.format("%.2f",amount) + " out of account "+userId+" " + "Balance - $" + String.format("%.2f",balance) ;
		List<Transactions> list = tDao.getTransactionHistory(userId);
		System.out.println(list.toString());
		if(type.equals("Deposit"))
		{
			trans = new Transactions(userId,descDepo,"Deposit");
			tDao.save(trans);
		} 
		else if(type.equals("Withdraw"))
		{
			trans = new Transactions(userId,descWith,"Withdraw");
			tDao.save(trans);
		}
		list = tDao.getTransactionHistory(userId);
		if(list.size() > 5)
		{
			tDao.delete(list.get(0));
		}
		
	}
	private void createTransaction(String userId, String transferTo, String type, double amount, double balanceTran,double balanceRec)
	{
		Transactions trans;
		Transactions trans2;
		String descTrans = "Transfered $" + String.format("%.2f",amount) + " from account "+userId+" to account "+ transferTo + " Balance - $" + String.format("%.2f",balanceTran) ;
		String descRec = "Recieved $" + String.format("%.2f",amount) + " from account "+userId+" Balance - " + String.format("%.2f",balanceRec) ;
		List<Transactions> list = tDao.getTransactionHistory(userId);
		List<Transactions> list2 = tDao.getTransactionHistory(transferTo);
		if(type.equals("Transfer"))
		{
			trans = new Transactions(userId,descTrans,"Transfer");
			trans2 = new Transactions(transferTo,descRec,"Transfer");
			tDao.save(trans);
			tDao.save(trans2);
		}
		list = tDao.getTransactionHistory(userId);
		list2 = tDao.getTransactionHistory(transferTo);
		if(list.size() > 5)
		{
			tDao.delete(list.get(0));
		}
		if(list2.size() > 5)
		{
			tDao.delete(list2.get(0));
		}
		
	}
	

}
