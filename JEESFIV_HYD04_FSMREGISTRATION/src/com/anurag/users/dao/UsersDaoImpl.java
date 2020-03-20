package com.anurag.users.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.anurag.users.dto.Users;
import com.anurag.users.utils.UsersDBQueries;

public class UsersDaoImpl implements UsersDao 
{
	private Connection connection = null;
	private PreparedStatement pst;
	public ResultSet result=null;

	@Override
	public void openConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url,"vinoothna","vinoothna");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public int addUser(Users user) {
		openConnection();
		int rows = 0;
		try 
		{
			pst = connection.prepareStatement(UsersDBQueries.addUsersQuery);
			pst.setString(1,user.getUser_Type());
			pst.setLong(2,user.getUser_Id());
			pst.setString(3,user.getUser_Name());
			pst.setString(4,user.getUser_Password());
			pst.setLong(5,user.getUser_Phone());
			pst.setString(6, user.getUser_Email());
			rows = pst.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		close();
		return rows;
	}
	@Override
	public boolean validateUser(String user_Type, String user_Name, String user_Password) {
		openConnection();
		try 
		{
			pst = connection.prepareStatement(UsersDBQueries.searchUserQuery);
			pst.setString(1, user_Type);
			pst.setString(2, user_Name);
			pst.setString(3, user_Password);
			result = pst.executeQuery();
			System.out.println(result.next());
			if(result.next())
			{
				return true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		close();
		return false;
	}
}
