package com.jdbc;

import java.sql.Connection;

public class JdbcTestDriver {

	public static void main(String[] args) {
		Connection con = DatabaseConnection.getConnection();
		System.out.println("오라클 서버에 연결되었습니다!");
	}

}
