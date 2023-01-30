package edu.wccnet.emeyer.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection myCom = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection Succesful!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
