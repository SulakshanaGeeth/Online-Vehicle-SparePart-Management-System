package com.oop.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private static String  url = "jdbc:mysql://localhost:3306/vspm";
	private static String username = "root";
	private static String password = "geeth123";
	private static Connection con; //connection type object
	
	//connection is the return type of the getConncetion method
	public static Connection getConnection() {
		try {
			//create driver
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			System.out.println("Database Connection Failed!");
		}
		
		return con;
	}
}
