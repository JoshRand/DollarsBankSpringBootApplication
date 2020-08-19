package com.joshrand.dollarsbank.repo;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joshrand.dollarsbank.model.Customer;


@Repository("HistoryRepo")
public interface HistoryRepo extends CrudRepository<Customer,Integer>
{
	// To add other methods
	//public Customer findByUserId(String userId);
	
}
