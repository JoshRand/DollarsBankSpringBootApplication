package com.joshrand.dollarsbank.repo;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joshrand.dollarsbank.model.Customer;
import com.joshrand.dollarsbank.model.Transactions;


@Repository("TransactionsRepo")
public interface TransactionsRepo extends CrudRepository<Transactions,Integer>
{
	// To add other methods
	public List<Transactions> findAllByUserId(String userId);
	
}
