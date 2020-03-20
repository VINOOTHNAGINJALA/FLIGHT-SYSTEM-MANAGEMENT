package com.anurag.users.exceptions;

@SuppressWarnings("serial")
public class UserCreationException extends Exception{
	public UserCreationException() {
		super("User already exist, proceed with login");
	}
}
