package com.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcTestDriver {

	public static void main(String[] args) {
		Connection con = DatabaseConnection.getConnection();
		System.out.println("오라클 서버에 연결되었습니다!");
		
		DatabaseConnection.close();
		System.out.println("오라클 서버가 닫혔습니다!");
	
	}
}
