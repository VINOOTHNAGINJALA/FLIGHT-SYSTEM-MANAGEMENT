package com.anurag.users.dto.applications;

import java.util.Scanner;
import com.anurag.users.dto.Users;
import com.anurag.users.exceptions.UserCreationException;
import com.anurag.users.service.UsersService;
import com.anurag.users.service.UsersServiceImpl;

public class UserRegistration 
{
	public static void main(String args[])
	{
		UsersService service = new UsersServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user type");
		System.out.println("Enter A for Admin and P for Passenger");
		String user_Type = sc.nextLine();
		System.out.println("Enter your UIN(Unique Identification Number : Aadhar Card Number)");
		long user_Id = sc.nextLong();
		while(!service.validateUserId(user_Id))
		{
			System.out.println("Invalid Id.");
			System.out.println("Enter the Id : ");
			user_Id = sc.nextLong();
		}
		System.out.println("Enter your name");
		sc.nextLine();
		String user_Name = sc.nextLine();
		System.out.println("Enter your password");
		String user_Password = sc.nextLine();
		System.out.println("Enter your email id");
		String user_Email = sc.nextLine();
		while(!service.validateEmail(user_Email))
		{
			System.out.println("Invalid email, enter a valid one!");
			user_Email = sc.nextLine();
		}
		System.out.println("Enter your phone number");
		long user_Phone = sc.nextLong();
		while(!service.validatePhoneNo(user_Phone))
		{
			System.out.println("Invalid phone number.");
			System.out.println("Enter the valid phone number : ");
			user_Phone = sc.nextLong();
		}
		sc.close();
		Users user = new Users(user_Type,user_Id,user_Name,user_Password,user_Phone,user_Email);
		int row = service.addUser(user);
		try {
			if(row>0)
				System.out.println("User created.");
			else{
				throw new UserCreationException();
			}
		}catch(UserCreationException e) {
			System.out.println(e.getMessage());
		}
	}
}

