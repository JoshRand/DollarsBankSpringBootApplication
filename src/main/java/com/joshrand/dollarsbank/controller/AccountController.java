package com.joshrand.dollarsbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joshrand.dollarsbank.model.Customer;
import com.joshrand.dollarsbank.services.TransactionService;

@Controller
public class AccountController
{

	@Autowired
	TransactionService tS;
	
	@GetMapping("/transactions-page")
	public String getTransactionsPage()
	{
		return "transactions";
	}
	
	@PostMapping("/transactions-page")
	public String transactionHandler(ModelMap model, @RequestParam String name,@RequestParam String transferTo,
			@RequestParam String option ,@RequestParam double amount)
	{
		model.put("message", tS.transactionHandler(name, transferTo, option, amount));
		return "transactions";
	}
	@GetMapping("/welcome-page")
	public String getTransactionsPage(ModelMap model)
	{
		return "welcome";
	}
	
}
