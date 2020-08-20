package com.joshrand.dollarsbank.dao;

import java.util.List;

import com.joshrand.dollarsbank.model.Transactions;

public interface TransactionsDao
{
	public void save(Transactions transaction);
	public void delete(Transactions transaction);
	public List<Transactions> getTransactionHistory(String userId);
}
