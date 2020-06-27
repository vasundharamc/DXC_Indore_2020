package com.dxc.StudentFeeManagement;

import java.io.BufferedReader;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class Student 
{
	String url="jdbc:mysql://localhost:3306?user=root &password=dbms";
	public void addstudent(BufferedReader buff) throws Exception
	{
		
		String query="insert into studentfeemanagement.student values(?,?,?,?,?,?,?,?,?,?,?)";
		Connection connection=(Connection) DriverManager.getConnection(url);
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		System.out.println("enter the name");
		preparedStatement.setString(1,buff.readLine());
		System.out.println("enter the email");
		preparedStatement.setString(2, buff.readLine());
		System.out.println("enter the course");
		preparedStatement.setString(3, buff.readLine());
		System.out.println("enter the fee");
		preparedStatement.setString(4, buff.readLine());
		System.out.println("enter the paid");
		preparedStatement.setString(5, buff.readLine());
		System.out.println("enter the due");
		preparedStatement.setString(6, buff.readLine());
		System.out.println("enter the address");
		preparedStatement.setString(7, buff.readLine());
		System.out.println("enter the city");
		preparedStatement.setString(8, buff.readLine());
		System.out.println("enter the state");
		preparedStatement.setString(9, buff.readLine());
		System.out.println("enter the country");
		preparedStatement.setString(10, buff.readLine());
		System.out.println("enter the contactno");
		preparedStatement.setString(11, buff.readLine());

		System.out.println(preparedStatement.executeUpdate() + " No of Records Inserted");
		
		
	}
	public void viewStudentDetails (BufferedReader buff) throws Exception
	{
		Connection connection=(Connection) DriverManager.getConnection(url);
		String query="select * from studentfeemanagement.student";
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery(query);
		while(resultSet.next())
		{
			System.out.println(resultSet.getString(1)+" " +resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+
					resultSet.getString(5)+" "+" "+resultSet.getString(6)+" "+" "+resultSet.getString(7)+" "+" "+resultSet.getString(8)+" "
					+" "+resultSet.getString(9)+" "+" "+resultSet.getString(10)+" "+" "+resultSet.getString(11));
		}
		connection.close();
	}
	public void dueFee(BufferedReader buff) throws Exception
	{
		Connection connection=(Connection) DriverManager.getConnection(url);
		String query="select stu_due from studentfeemanagement.student";
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery(query);
		while(resultSet.next())
		{
			System.out.println(resultSet.getString(6));	
		}
		
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
	

}
