package com.dxc.StudentFeeManagement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.security.auth.login.AccountException;

class userClass<T> 
{ 
	T obj;

	void create(T obj) 
	{ 
		this.obj = obj;
	}

	AdminLogin getInstance() { 
		return obj;
	}

	
	
}
public class FeeManagement
{
	InputStreamReader ins = null;
	BufferedReader buff = null;
	AdminLogin al = null;
	AccountException ae=null;
	
	String userchoice;
	String clientchoice;
	
	public static void main(String[] args)
	{
		FeeManagement fm=new FeeManagement();
		fm.ins=new InputStreamReader(System.in);
		fm.buff=new BufferedReader(fm.ins);
		String continueUrChoice;
		boolean transaction=true;
		boolean repeat=true;
		
		do {
			
			System.out.println("Welcome to Student  FEES MANAGEMENT SYSTEM\n");
			System.out.println("SELECT your USER choice\n 1.Admin \n 2.Accountant Section\n");
			String userchoice = fm.buff.readLine();
			switch (Integer.parseInt(userchoice))
			{
			case 1:
				userClass<AdminLogin> obj = new userClass<AdminLogin>();
				obj.create(new AdminLogin());
				fm.al=obj.getInstance();
				
				System.out.println(" Admin login PAGE\n");
				do
				{
					fm.al.login(fm.buff);
					System.out.println("ADMIN SECTION\n");
					System.out.println("select your section\n 1.ADD ACCOUNTANT \n 2.VIEW ACCOUNTANT \n 3.LOGOUT");
					String clientchoice=fm.buff.readLine();
					switch(Integer.parseInt(clientchoice)) 
					{
					case 1: fm.al.addAccount(fm.buff);
					break;
					case 2: fm.al.viewAccount(fm.buff);
					break;
					case 3: fm.al.logout(fm.buff);
					break;
					default:
						System.out.println("task is not performed");
					
					}
					System.out.println("Do you Want to Continue\nYes\nNo");
					continueUrChoice = fm.buff.readLine();
					if (continueUrChoice.equalsIgnoreCase("No"))
						transaction = false;
				}while(transaction);
					break;
				}
		case 2:
			userClass<AccountException> obj1=new userClass<AccountException>();
			obj1.create(new AccountException());
			fm.al=obj1.getInstance();
			do {
			System.out.println("select your choice\n 1.ADD STUDENT \n 2.VIEW STUDENT \n 3.EDIT STUDENT \n 4.DUE FESS \n 5.LOGOUT");
			String clientchoice1=fm.buff.readLine();
			
			switch(Integer.parseInt(clientchoice1))
			{
				
				case 1: fm.al.addstudent(fm.buff);
				break;
				case 2: fm.al.viewstudent(fm.buff);
				break;
				case 3: fm.al.editstudent(fm.buff);
				break;
				case 4: fm.al.duefees(fm.buff);
				break;
				case 5: fm.al.logout(fm.buff);
				break;
				default: System.out.println("task not completed");
			}
			System.out.println("Do you Want to Continue\nYes\nNo");
			continueUrChoice = fm.buff.readLine();
			if (continueUrChoice.equalsIgnoreCase("No"))
				transaction = false;
			}
			while(transaction);
			break;
			default: System.out.println("select atleast one task\n");
		}
		System.out.println("Do you Want to End feemanagement\nYes\nNo");
		 fm.userchoice = fm.buff.readLine();
		if (fm.userchoice.equalsIgnoreCase("no"))
			repeat = false;
		}
	while(repeat);
		
		System.out.println("*************THANK YOU FOR YOUR INFORMATION*************");
		}while;s
