package com.joshrand.dollarsbank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.joshrand.dollarsbank.dao.AccountDao;
import com.joshrand.dollarsbank.dao.TransactionsDao;
import com.joshrand.dollarsbank.model.Customer;
import com.joshrand.dollarsbank.model.Transactions;
import com.joshrand.dollarsbank.services.CustomerService;
import com.joshrand.dollarsbank.services.TransactionService;
import com.joshrand.dollarsbank.utility.EncryptionUtility;

@Controller
public class AccountController
{

	EncryptionUtility enc = new EncryptionUtility();
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	TransactionsDao tDao;
	
	@Autowired
	AccountDao aDao;
	
	@Autowired
	TransactionService tS;
	
	@GetMapping("/transactions-page")
	public String getTransactionsPage(HttpSession session)
	{
		
		if(session.getAttribute("name") != null  && 
				customerService.getCustomer(session.getAttribute("name").toString()).getSessionId().equals( session.getId())) 
		{
			return "transactions";
		}
		else
		{
			return "redirect:/login";
		}
	}
	
	@PostMapping("/transactions-page")
	public String transactionHandler(ModelMap model, HttpServletRequest request ,@RequestParam String transferTo,
			@RequestParam String option ,@RequestParam double amount)
	{
		
		model.put("message", tS.transactionHandler(request.getSession().getAttribute("name").toString(), transferTo, option, amount));
		Customer cust = aDao.getCustomerByUserId(request.getSession().getAttribute("name").toString());
		System.out.println(request.getSession().getAttribute("name").toString() + "Hello2" + cust.getBalance());
		model.put("balance",String.format("%.2f",cust.getBalance()));
		if(request.getSession().getAttribute("name") != null  && 
				customerService.getCustomer(request.getSession().getAttribute("name").toString()).getSessionId().equals( request.getSession().getId())) 
		{
			return "transactions";
		}
		else
		{
			return "redirect:/login";
		}
	}
	
	@GetMapping("/welcome-page")
	public String getWelcomePage(ModelMap model, HttpServletRequest request)
	{	
		
		if(request.getSession().getAttribute("name") != null  && 
				customerService.getCustomer(request.getSession().getAttribute("name").toString()).getSessionId().equals( request.getSession().getId())) {
			return "welcome";
		}
		else
		{
			return "redirect:/login";
		}
		
	}
	
	@GetMapping("/account-details")
	public String getAccountDetails(ModelMap model, HttpSession session,  Customer cust)
	{
		
		//?name=${name}
		if(session.getAttribute("name") != null  && 
				customerService.getCustomer(session.getAttribute("name").toString()).getSessionId().equals( session.getId())) {
			cust = customerService.getCustomer(session.getAttribute("name").toString());
			System.out.println(cust.toString());
			Customer custToShow = cust.Clone();
			StringBuilder stringBuilder = new StringBuilder(custToShow.getPassword());
			for(int i = 0; i < stringBuilder.length(); i++)
				stringBuilder.setCharAt(i, '*');
			custToShow.setPassword(stringBuilder.toString());
			model.put("cust",custToShow);
			return "accountdetails";
		}
		else
		{
			return "redirect:/login";
		}
		
	}
	
	@GetMapping("/transactions-history")
	public String showTransactionHistory(ModelMap model,HttpSession session )
	{
		List<Transactions> list = tDao.getTransactionHistory(session.getAttribute("name").toString());
		model.put("list",list);
		
		
		if(session.getAttribute("name") != null  && 
				customerService.getCustomer(session.getAttribute("name").toString()).getSessionId().equals( session.getId())) 
		{
			return "transactionhistory";
		}
		else
		{
			return "redirect:/login";
		}
		
	}
	
	@GetMapping("/password")
	public String changePassword(ModelMap model,HttpSession session )
	{
		
		if(session.getAttribute("name") != null  && 
				customerService.getCustomer(session.getAttribute("name").toString()).getSessionId().equals( session.getId())) 
		{
			return "changepass";
		}
		else
		{
			return "redirect:/login";
		}
		
	}
	@PostMapping("/password")
	public String changePasswordPost(ModelMap model, HttpSession session, @RequestParam String prevpassword, 
			@RequestParam String newpassword, @RequestParam String newpasswordrepeat  )
	{
		Customer cust = customerService.getCustomer(session.getAttribute("name").toString());
		System.out.println("Post password" + " " + prevpassword +" " +  newpassword+" " +  newpasswordrepeat + cust.toString());
		try
		{
			if(cust.getPassword().equals(enc.encrypt(prevpassword)) && newpassword.equals(newpasswordrepeat))
			{
				cust.setPassword(enc.encrypt(newpassword));
				System.out.println(" changing password");
				customerService.saveCustomer(cust);
				model.put("errorMessage","Password Changed!");
				
			}
			else
			{
				System.out.println(" error message should display");
				model.put("errorMessage","Wrong Password/Passwords must match!");
				return "changepass";
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		if(session.getAttribute("name") != null  && 
				customerService.getCustomer(session.getAttribute("name").toString()).getSessionId().equals( session.getId())) 
		{
			return "changepass";
		}
		else
		{
			return "redirect:/login";
		}
		
	}
	
}
