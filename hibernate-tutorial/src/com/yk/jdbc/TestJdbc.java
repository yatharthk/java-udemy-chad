package com.yk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimeZone=IST";
		String user="hbstudent";
		String password="hbstudent";
		try 
		{
			System.out.println("Connecting to database"+jdbcUrl);
			Connection myCon=DriverManager.getConnection(jdbcUrl,user,password);
			System.out.println("Connection successful!!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
