package com.joshrand.dollarsbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.joshrand.dollarsbank.dao.TransactionsDao;
import com.joshrand.dollarsbank.dao.TransactionsDaoImpl;
import com.joshrand.dollarsbank.model.Customer;
import com.joshrand.dollarsbank.model.Transactions;
import com.joshrand.dollarsbank.services.CustomerService;
import com.joshrand.dollarsbank.services.RegisterService;
import com.joshrand.dollarsbank.utility.EncryptionUtility;

@Controller
public class RegistrationController
{
	EncryptionUtility enc = new EncryptionUtility();
	
	
	@Autowired
	TransactionsDao tDao;
	
	@Autowired
	RegisterService regService;
	
	@GetMapping("/registration-page")
	public String showRegistrationPage(ModelMap model, Customer cust, String message)
	{
		//message = "dsaasdsadsas";
		cust = new Customer();
		model.addAttribute("cust",cust);
		model.addAttribute("errorMessage",message);
		return "registration";
	}
	
	
	
	@PostMapping("/registration-page")
	public String registerCustomer(ModelMap model, Customer cust, BindingResult result)
	{
		if(result.hasErrors())
		{
			System.out.println(" ERROR  ~~~~~~~~~~~~~~ REGISTRATION PAGE");
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
			
			try
			{
				cust.setPassword(enc.encrypt(cust.getPassword()));
			} catch (Exception e)
			{
				
			}
			
			model.put("cust", cust);
			String descDepo = "Initial Deposit of $" + String.format("%.2f",cust.getBalance()) + " into account "+cust.getUserId()+" " + "Balance - $" + String.format("%.2f",cust.getBalance());
			Transactions trans = new Transactions(cust.getUserId(),descDepo,"Initial Deposit");
			
			
			tDao.save(trans);
			regService.saveCustomer(cust);
			return "redirect:login";
		}
		
	}
	
	
}
