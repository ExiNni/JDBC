package com.kh.db.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteSample {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, user, password);
			String deleteSql = "DELETE FROM BANK WHERE account_id = ?";
			PreparedStatement ps = con.prepareStatement(deleteSql);
			ps.setDouble(1, 21);
			
			int rows = ps.executeUpdate();
			System.out.println(rows + " ���� �Ϸ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
