package com.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {
	
	private static Connection connection;
	//Creating Single Ton Java Class
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
	
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("Driver Loaded");
		
		String url = "jdbc:oracle:thin:@localHost:1521:xe";
		String username = "T2dstudio";
		String password = "kehinde";
		
		return connection=DriverManager.getConnection(url, username,password);
	}
		

}
