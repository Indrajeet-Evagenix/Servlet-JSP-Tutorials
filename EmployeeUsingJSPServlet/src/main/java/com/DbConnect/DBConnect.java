package com.DbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	static String driver = "com.mysql.cj.jdbc.Driver";

	static String url = "jdbc:mysql://localhost:3306/netxsolution";
	static String username = "root";
	static String password = "root";

	public static Connection getConnection() {

		Connection conn = null;
		try {
			Class.forName(driver);
//			System.out.println("Driver Loaded");

			conn = DriverManager.getConnection(url, username, password);
//			System.out.println("Connection Established");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return conn;
	}

}
