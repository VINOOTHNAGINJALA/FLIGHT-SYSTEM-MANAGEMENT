package com.anurag.users.exceptions;

@SuppressWarnings("serial")
public class PhoneNumberInvalidException extends Exception{
	public PhoneNumberInvalidException() {
		super("Phone number is invalid");
	}
}
