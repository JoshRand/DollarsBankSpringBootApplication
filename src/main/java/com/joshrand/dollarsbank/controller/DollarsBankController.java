package com.joshrand.dollarsbank.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.naming.directory.InitialDirContext;

import com.joshrand.dollarsbank.dao.AccountDao;
import com.joshrand.dollarsbank.dao.AccountDaoImpl;
import com.joshrand.dollarsbank.model.Customer;
import com.joshrand.dollarsbank.utility.ConsolePrinterUtility;
import com.joshrand.dollarsbank.utility.DataGeneratorStubUtility;
import com.joshrand.dollarsbank.utility.EncryptionUtility;

public class DollarsBankController
{
	public EncryptionUtility en = new EncryptionUtility();
	//Without a database using Static list/block to instantiate some users and init deposits
	//public static List<Customer> list = new ArrayList<Customer>();
	AccountDaoImpl cDaoImp = new AccountDaoImpl();
	static {
		try {
			EncryptionUtility en = new EncryptionUtility();
			AccountDaoImpl cDaoImp = new AccountDaoImpl();
			cDaoImp.save(new Customer("Josh", "4003 Poppy Green flort"
					, "832-409-9637", "a", en.encrypt("a") , 30.2));
			cDaoImp.save(new Customer("mark", "Somewhere in AZ"
					, "832-222-5555", "b", en.encrypt("b"), 302222.2));
//			list.add(new Customer("Josh", "4003 Valley Green ct"
//					, "832-409-9637", "a", en.encrypt("a") , 30.2));
//			list.add(new Customer("mark", "Somewhere in AZ"
//					, "832-222-5555", "b", en.encrypt("b"), 302222.2));
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	int option = 0;
	//Helps display Sysout console prompts
	public static ConsolePrinterUtility cpu = new ConsolePrinterUtility();
	public static DataGeneratorStubUtility dgsu = new DataGeneratorStubUtility();
	Scanner scan = new Scanner(System.in);

	
	public Boolean run()
	{

		cpu.welcome();
		option = 0;
		try 
		{
			//Use scan.nextLine after int to eat up leftover data
			option = scan.nextInt();
			scan.nextLine();
			
		}catch(InputMismatchException mis)
		{
			scan.nextLine();
			cpu.invalidOption();
		}
		
		switch (option)
		{
			case 1:
				System.out.println();
				createAccount();
				System.out.println();
				scan.reset();
				break;
			case 2:
				System.out.println();
				login();
				System.out.println();
				scan.reset();
				break;
			case 3:
				exit();
				
				break;
			default:
	
				break;
		}
		
		System.out.flush();

		return true;
	}

	public void createAccount()
	{

		String name = "";
		String address = "";
		String contactNumber = "";
		String userId = "";
		String password = "";
		double initalDeposit = 0;

		
		try
		{
			//TODO: prevent creating multiple customers with same user id
			
			System.out.println("Customer Name: ");

			scan.hasNextLine();
			name = scan.nextLine();
			System.out.println("Customer Addresss: ");

			address = scan.nextLine();
			System.out.println("Customer Contact Number: ");
			contactNumber = scan.nextLine();
			System.out.println("User Id: ");
			userId = scan.nextLine();
			System.out.println("Password: 8 Characters with Lower, Upper & special");
			password = scan.nextLine();
			if(passCheck(password))
			{
				
				System.out.println("Password looks good!");
				System.out.println("Initial Deposit Amount: ");
				try
				{
					//TODO: fix encryption Throwing Exception
					password = en.encrypt(password);
					//System.out.println(password);
					
					//Testing Decryption
					//System.out.println("Decrypting pass...");
					//System.out.println("pass = " + en.decrypt(password));
				} catch (Exception e)
				{
					System.out.println("Error with encryption");
					e.printStackTrace();
					// TODO: handle exception
				}
					
				
				initalDeposit = scan.nextDouble();
				scan.nextLine();
				// Database
				cDaoImp.save(new Customer(name, address, contactNumber, userId, password, initalDeposit));
				// Customer(name,address,contactNumber,userId,password,initalDeposit));
				// ArrayList Collection
				// list.add(new Customer(name, address, contactNumber, userId, password, initalDeposit));
				
			}
			else 
			{
				System.out.println("Password needs to be 8 Characters with Lower, Upper & special");
			}
			
			
		} catch (InputMismatchException ime)
		{

		}
		

	}

	public void login()
	{
		List<Customer> list = cDaoImp.getAllAccounts();
		String userId = "";
		String password = "";
		boolean logout=false;
		int iterator = 0;
		cpu.login();
		System.out.println("User Id: ");
		userId = scan.nextLine();
		System.out.println("Password: ");
		password = scan.nextLine();

		for (Customer customer : list)
		{
			try
			{
				if (customer.getUserId().equalsIgnoreCase(userId) && en.decrypt(customer.getPassword()).equalsIgnoreCase(password))
				{
					System.out.println();
					loginSuccess(customer.getUserId(),iterator);
					logout = true;
					break;
				}
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			iterator++;
		}
		if(logout)
		{
			
		}
		else
		{
			cpu.invalidCreds();
			System.out.println();
			login();
		}
		
	}

	public void loginSuccess(String userId, int iterator) //with collections
	{
		List<Customer> list = cDaoImp.getAllAccounts();
		boolean signOut = false;
		double amount = 0;
		int loginOption = 0;
		list.get(iterator).toString(); 
		while(!signOut)
		{
			
			cpu.welcomeCust();
			try {
				loginOption = scan.nextInt();
				scan.nextLine();
				//System.out.println(loginOption);
		
				switch (loginOption)
				{
					case 1:
						//Deposit
						System.out.println("How much would you like to deposit? :");
						
							amount = scan.nextDouble();
							scan.nextLine();
							if(amount >= 0)
							{
								//With collections
								list.get(iterator).deposit(amount);
								//database
								cDaoImp.updateBalance(userId, list.get(iterator).getBalance());
								System.out.println("Deposit successful, your current balance is: " + list.get(iterator).getBalance());
								
							}
							else
							{
								System.out.println("Invalid input, please insert 0-> (Big Number)");
							}
						
					
						break;
					case 2:
						//withdraw
						System.out.println("How much would you like to withdraw? :");
						
							amount = scan.nextDouble();
							scan.nextLine();
							if(amount >= 0 && amount <= list.get(iterator).getBalance())
							{
								list.get(iterator).withdraw(amount);
								cDaoImp.updateBalance(userId, list.get(iterator).getBalance());
								System.out.println("Withdraw successful, your current balance is: " + list.get(iterator).getBalance());
								
							}
							else
							{
								System.out.println("Invalid input, please insert 0-> (Funds you have)\n"
										+ "your total funds =["+list.get(iterator).getBalance());
							}
						
						break;
					case 3:
						int transferCount = 0;
						int listPos = 0;
						boolean transferable = false;
						String userId2 = "";
						//funds transfer  EX: from a to b, or b to a
						System.out.println("Who are you wanting to transfer with? User Id: ");
						
							userId2 = scan.nextLine().toLowerCase();
							for (Customer customer : list)
							{
								if(customer.getUserId().equalsIgnoreCase(userId2))
								{
									transferable = true;
									listPos = transferCount ;
								}
								transferCount++;
							}
							if(!transferable)
							{
		
								System.out.println("User doesn't exist! ");
								break;
								
							}
							System.out.println("How much are you transfering to " + userId2);
							amount = scan.nextDouble();
							scan.nextLine();
							if(amount >= 0 && amount <= list.get(iterator).getBalance())
							{
								list.get(listPos).deposit(list.get(iterator).transfer(amount,list.get(listPos).getUserId()));
								cDaoImp.updateBalance(list.get(iterator).getUserId(), list.get(iterator).getBalance());
								cDaoImp.updateBalance(list.get(listPos).getUserId(), list.get(listPos).getBalance());
								System.out.println("Transfer successful, your current balance is: " + list.get(iterator).getBalance());
								
							}
							else
							{
								System.out.println("Invalid input, please insert 0-> (Funds you have)\n"
										+ "your total funds =["+list.get(iterator).getBalance());
							}
						
						
						break;
					case 4:
						System.out.println();
						list.get(iterator).printHistory();
						
						System.out.println();
						break;
					case 5:
						cpu.displayCustomerInfo(list.get(iterator));
						break;
					case 6:
						dgsu.generateStub(list.get(iterator));
						break;
					case 7:
						signOut=true;
						break;
					default:
						
						break;
				}
				
			}catch (InputMismatchException e) {
				scan.nextLine();
				loginOption = 0;
				cpu.invalidOption();
				
			}
			
		}
	}
	private boolean passCheck(String password)
	{
		int grade = 0;
		//length >= 8
		if(password.length() >= 8)
			grade++;
		// contains at least 1 digit
		if(password.matches("(?=.*[0-9]).*"))
			grade++;
		// contains at least 1 lower case
		if(password.matches("(?=.*[a-z]).*"))
			grade++;
		// contains at least 1 upper case
		if(password.matches("(?=.*[A-Z]).*"))
			grade++;
		// contains at least 1 special char
		if(password.matches("(?=.*[~!@#$%^&*()_-]).*"))
			grade++;
		if(grade == 5)
			return true;
		else
			return false;
	}
	public void exit()
	{
		System.exit(0);
	}

}
