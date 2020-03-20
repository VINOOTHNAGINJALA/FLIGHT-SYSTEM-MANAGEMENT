package com.anurag.users.dao;

import com.anurag.users.dto.Users;

public interface UsersDao 
{
	public void openConnection();
	public void close();
	public int addUser(Users user);
	public boolean validateUser(String user_Type, String user_Name, String user_Password);
}
