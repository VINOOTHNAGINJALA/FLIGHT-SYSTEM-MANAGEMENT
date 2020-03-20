package com.anurag.users.utils;

public class UsersDBQueries {
	public static String addUsersQuery = "insert into users values(?,?,?,?,?,?)";
	public static String searchUserQuery = "select * from users where user_Type=? and user_Name =? and user_Password=?";
}
