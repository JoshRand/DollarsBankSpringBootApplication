package com.joshrand.dollarsbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.joshrand.dollarsbank.model.Customer;
import com.joshrand.dollarsbank.services.CustomerService;
import com.joshrand.dollarsbank.services.RegisterService;

@Controller
public class RegistrationController
{
	@Autowired
	RegisterService regService;
	
	@GetMapping("/registration-page")
	public String showRegistrationPage(ModelMap model, Customer cust, String message)
	{
		message = "dsaasdsadsas";
		 cust = new Customer();
		model.addAttribute("cust",cust);
		model.addAttribute("message",message);
		return "registration";
	}
	
	
	
	@PostMapping("/registration-page")
	public String registerCustomer(ModelMap model, Customer cust, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "registration-page";
		}
		if(regService.custExists(cust.getUserId()))
		{
			//message = "User already Exists";
			//model.put("message",message);
			//message = "";
			// add error message
			return "registration-page";
			
		}
		else
		{
		
			model.put("cust", cust);
		
			regService.saveCustomer(cust);
			return "login";
		}
		
	}
	
	
}
