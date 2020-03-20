package com.anurag.users.exceptions;

@SuppressWarnings("serial")
public class EmailInvalidException extends Exception{
	public EmailInvalidException() {
		super("Make sure that the local part of email should contain alphanumeric characters only ");
	}
}
