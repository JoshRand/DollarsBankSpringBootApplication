package com.joshrand.dollarsbank.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joshrand.dollarsbank.model.Transactions;
import com.joshrand.dollarsbank.repo.TransactionsRepo;
@Component
public class TransactionsDaoImpl implements TransactionsDao
{

	@Autowired
	TransactionsRepo tRepo;
	
	@Override
	public void save(Transactions transaction)
	{
		tRepo.save(transaction);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Transactions> getTransactionHistory(String userId)
	{
		List<Transactions> list = (List<Transactions>)tRepo.findAllByUserId(userId);
		
		return list;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Transactions transaction)
	{
		tRepo.delete(transaction);
		// TODO Auto-generated method stub
		
	}

}
