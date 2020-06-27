package com.dxc.StudentFeeManagement;

import java.io.BufferedReader;
import java.sql.DriverManager;
import java.sql.*;
import com.mysql.jdbc.Connection;

public class AdminLogin 
{
	String url="jdbc:mysql://localhost:3306?user=root &password=dbms";
	public void login(BufferedReader buff)throws Exception 
	{
		System.out.println("enter yiur username");
		String username=buff.readLine();
		System.out.println("enter password");
		String pswd=buff.readLine();
		System.out.println("admin login Successfull\n");
	}
	public void addAccount(BufferedReader buff)throws Exception
	{
		//String url="jdbc:mysql://localhost:3306?user=root &password=dbms";
		String query="insert into studentfeemanagement.accountant values(?,?,?,?)";
		Connection connection=(Connection) DriverManager.getConnection(url);
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		System.out.println("enter your name");
		preparedStatement.setString(1,buff.readLine());
		System.out.println("enter your password");
		preparedStatement.setString(2,buff.readLine());
		System.out.println("enter your email");
		preparedStatement.setString(3,buff.readLine());
		System.out.println("enter your phone");
		preparedStatement.setString(4,buff.readLine());
		
		System.out.println(preparedStatement.executeUpdate()+"No of records inserted");
		
		
	}
	public void viewAccount(BufferedReader buff) throws Exception
	{
		String query="select * from studentfeemanagement.accountant";
		Connection connection=(Connection) DriverManager.getConnection(url);
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery(query);
		while(resultSet.next())
			System.out.println(resultSet.getString(1)+" " +resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));
		connection.close();
	}
	public void logout(BufferedReader buff) throws Exception
	{
		String ContinueurChoice;
		boolean transaction=true;
		System.out.println("Do you want to logout\n YES\n NO\n");
		ContinueurChoice=buff.readLine();
		if(ContinueurChoice.equalsIgnoreCase("logout"));
		transaction=false;
	
	}
	public void addstudent(BufferedReader buff) {
		// TODO Auto-generated method stub
		
	}
	public void viewstudent(BufferedReader buff) {
		// TODO Auto-generated method stub
		
	}
	public void editstudent(BufferedReader buff) {
		// TODO Auto-generated method stub
		
	}
	public void duefees(BufferedReader buff) {
		// TODO Auto-generated method stub
		
	}
	
}

