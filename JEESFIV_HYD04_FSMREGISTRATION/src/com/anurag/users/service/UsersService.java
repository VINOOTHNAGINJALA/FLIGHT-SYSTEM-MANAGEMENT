package com.anurag.users.service;

import com.anurag.users.dto.Users;

public interface UsersService 
{
	public int addUser(Users user);
	public boolean validatePhoneNo(Long user_Number);
	public boolean validateEmail(String user_Email);
	public boolean validateUserId(Long user_Id);
	public boolean validateUser(String user_Type,String user_Name,String user_Password);
}
