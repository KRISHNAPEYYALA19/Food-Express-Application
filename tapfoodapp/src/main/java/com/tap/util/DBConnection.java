package com.tap.util;
//1.this class is giving connection to launch class so provide a method and pass the  content to method

//2,method should return Connection type

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
//make the variables final which are not changing
	private static final String URL = "jdbc:mysql://localhost:3306/tapfoodapp";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	private static Connection connection;
// method returns Connection type
	public static Connection getConnection() {// we need use static because we don't use instance variables inside the
											  // method
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME , PASSWORD);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
