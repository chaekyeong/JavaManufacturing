package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static Connection con = null;

	static {
		String url = "jdbc:oracle:thin:@//localhost:1521/xepdb1";
		String user = "ace";
		String pass = "me";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return con;
	}
	
	public static void close() throws SQLException {
		if(con != null) {
			if(!con.isClosed()) {
				con.close();
			}
		}
	}
}
