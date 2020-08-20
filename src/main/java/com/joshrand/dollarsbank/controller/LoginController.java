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

import com.joshrand.dollarsbank.services.LoginService;
import com.joshrand.dollarsbank.utility.EncryptionUtility;


@Controller
@SessionAttributes("name")
public class LoginController
{
	EncryptionUtility enc = new EncryptionUtility();
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	//@GetMapping("/login")
	public String showLoginPage(ModelMap model){
		return "login";
	}
	
	//@PostMapping("/login")
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showWelcomePage(Locale locale, ModelMap model, @RequestParam String name, @RequestParam String password){
	
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
		model.put("name", name);
		return "welcome";
	}
	
	
	@GetMapping("/logout")
	public String logout(ModelMap model)
	{
		
		//Cancel session
		
		
		return "redirect:login";
		
	}
	
	
}
