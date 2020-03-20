package com.anurag.users.dto;
public class Users {
	private String user_Type;
	private long user_Id;
	private String user_Name;
	private String user_Password;
	private long user_Phone;
	private String user_Email;
	public Users() {}
	public Users(int user_Id) {
		this.user_Id = user_Id;
	}
	public Users(String user_Type, long user_Id, String user_Name, String user_Password, long user_Phone,
			String user_Email) {
		super();
		this.user_Type = user_Type;
		this.user_Id = user_Id;
		this.user_Name = user_Name;
		this.user_Password = user_Password;
		this.user_Phone = user_Phone;
		this.user_Email = user_Email;
	}
	public String getUser_Type() {
		return user_Type;
	}
	public void setUser_Type(String user_Type) {
		this.user_Type = user_Type;
	}
	public long getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(long user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getUser_Password() {
		return user_Password;
	}
	public void setUser_Password(String user_Password) {
		this.user_Password = user_Password;
	}
	public long getUser_Phone() {
		return user_Phone;
	}
	public void setUser_Phone(long user_Phone) {
		this.user_Phone = user_Phone;
	}
	public String getUser_Email() {
		return user_Email;
	}
	public void setUser_Email(String user_Email) {
		this.user_Email = user_Email;
	}	
}
