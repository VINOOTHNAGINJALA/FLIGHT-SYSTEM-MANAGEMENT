package com.anurag.users.exceptions;

@SuppressWarnings("serial")
public class UserIdInvalidException extends Exception{
	public UserIdInvalidException() {
		super("User Id should be of 12 digits");
	}
}
