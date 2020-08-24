package com.joshrand.dollarsbank.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.joshrand.dollarsbank.model.Customer;
import com.joshrand.dollarsbank.services.CustomerService;
import com.joshrand.dollarsbank.services.LoginService;
import com.joshrand.dollarsbank.utility.EncryptionUtility;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

@Controller

public class LoginController
{
	EncryptionUtility enc = new EncryptionUtility();
	
	@Autowired
	LoginService service;
	
	@Autowired
	CustomerService custService;
	
	
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	//@GetMapping("/login")
	public String showLoginPage(ModelMap model){
		return "login";
	}
	
	//@PostMapping("/login")
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showWelcomePage(Locale locale, ModelMap model, HttpSession session, @RequestParam String name, @RequestParam String password){
	
		try
		{
			if (!service.validateUser(name, enc.encrypt(password))) {
				//System.out.println(name + " " + password);
				model.put("errorMessage", "Invalid Credentials");
				
				return "login";
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Customer cust = custService.getCustomer(name);
		cust.setSessionId(session.getId());
		custService.saveCustomer(cust);
		session.setAttribute("name", name);
		//model.put("name", name);
		return "welcome";
	}
	
	
	@GetMapping("/logout")
	public String logout(ModelMap model, HttpServletRequest request)
	{
		//delete session from account
		if(request.getAttribute("name") == null)
		{
			request.getSession().invalidate();
			return "redirect:/login";
		}
		System.out.println(custService.getCustomer(request.getSession().getAttribute("name").toString()));
		Customer cust = custService.getCustomer(request.getSession().getAttribute("name").toString());
		if(cust!=null)
		{
			cust.setSessionId("0");
			custService.saveCustomer(cust);
		}
		//Cancel session
		request.getSession().invalidate();
		
		
		return "redirect:/login";
		
	}
	
	
	
}
