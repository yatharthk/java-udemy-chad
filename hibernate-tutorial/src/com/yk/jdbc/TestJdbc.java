package com.yk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimeZon=IST";
		String user="hbstudent";
		String passsword="hbstudent";
		try 
		{
			System.out.println("Connecting to database"+jdbcUrl);
			Connection myCon=DriverManager.getConnection(jdbcUrl,user,passsword);
			System.out.println("Connection successfull!!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
