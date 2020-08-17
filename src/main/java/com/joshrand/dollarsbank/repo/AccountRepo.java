package com.joshrand.dollarsbank.repo;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joshrand.dollarsbank.model.Customer;


@Repository("AccountRepo")
public interface AccountRepo extends CrudRepository<Customer,Integer>
{
	// To add other methods
	//public Todo findTodoById(int id);
	
}
