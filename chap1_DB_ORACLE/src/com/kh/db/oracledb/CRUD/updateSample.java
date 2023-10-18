package com.kh.db.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateSample {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, user, password);
			String updateSql = "UPDATE BANK SET balance = ? where account_number = ?";
			PreparedStatement ps = con.prepareStatement(updateSql);
			ps.setDouble(1, 23023987);
			ps.setDouble(2, 1234567890);
			
			int rows = ps.executeUpdate();
			System.out.println(rows + "업데이트 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
