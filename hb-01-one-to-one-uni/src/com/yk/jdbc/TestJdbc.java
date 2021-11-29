package com.yk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String jdbcUrl="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimeZon=IST";
		String user="root";
		String passsword="";
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
