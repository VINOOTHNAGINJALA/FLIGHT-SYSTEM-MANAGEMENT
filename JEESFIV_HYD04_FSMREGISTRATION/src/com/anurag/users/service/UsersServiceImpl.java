package com.anurag.users.service;

import com.anurag.users.dao.UsersDao;
import com.anurag.users.dao.UsersDaoImpl;
import com.anurag.users.dto.Users;
import com.anurag.users.exceptions.EmailInvalidException;
import com.anurag.users.exceptions.PhoneNumberInvalidException;
import com.anurag.users.exceptions.UserIdInvalidException;

public class UsersServiceImpl implements UsersService 
{
	UsersDao dao = new UsersDaoImpl();
	@Override
	public int addUser(Users user) {
		return dao.addUser(user);
	}
	@Override
	public boolean validatePhoneNo(Long user_Number) 
	{
		String num = ""+user_Number;
		try {
			if(num.length()!=10 || num.charAt(0)=='0')
				throw new PhoneNumberInvalidException();
		} catch(PhoneNumberInvalidException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	@Override
	public boolean validateEmail(String user_Email) {
		String emailValidate = user_Email;
		char[] dummy = new char[emailValidate.length()];
		for(int i=0;i<emailValidate.length();i++)
		{
			if(emailValidate.charAt(i)!='@')
				dummy[i] = emailValidate.charAt(i);
			else
			{
				dummy[i] = '\0';
				break;
			}
		}
		try {
			for(int i=0;dummy[i]!='\0';i++)
			{
				if(!((dummy[i] >='a' && dummy[i]<='z') || (dummy[i]>='0' && dummy[i]<='9') || (dummy[i]>='A' && dummy[i]<='Z')))
					throw new EmailInvalidException();
			}
		}catch(EmailInvalidException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	@Override
	public boolean validateUserId(Long user_Id) {
		String userIdValidate = Long.toString(user_Id);
		try {
			if(userIdValidate.length()!=12)
				throw new UserIdInvalidException();
		} catch(UserIdInvalidException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	@Override
	public boolean validateUser(String user_Type, String user_Name, String user_Password) {
		return dao.validateUser(user_Type,user_Name,user_Password);
	}
}
