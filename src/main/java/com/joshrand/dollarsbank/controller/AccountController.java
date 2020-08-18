package com.joshrand.dollarsbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController
{

	@GetMapping("/transactions-page")
	public String getTransactionsPage()
	{
		return "transactions";
	}
	
	
}
