package com.kh.db.oracledb.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insertSample {

	public static void main(String[] args) {
	}

	static void insertOne() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO BANK (account_id, account_number, account_name, balance, branch_name, last_transaction_date)"
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement iS = con.prepareStatement(insertQuery);
			iS.setInt(1, 21);
			iS.setString(2, "12532685");
			iS.setString(3, "È£¶ûÀÌ");
			iS.setDouble(4, 99999.99);
			iS.setString(5, "KH");
			iS.setDate(6, Date.valueOf("2023-10-16"));

			int rowsInsert = iS.executeUpdate();
			System.out.println(rowsInsert + " row Ãß°¡µÊ");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	static void insertKhCafe() {
				String driver = "oracle.jdbc.driver.OracleDriver";
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "khcafe";
				String password = "kh1234";
				Connection con = null;
				
				try {
					con = DriverManager.getConnection(url, user, password);
					String insertQuery = "INSERT INTO MENU (menu_id, cafe_id, menu_name, price, description)" + "VALUES (?, ?, ?, ?, ?)";
					PreparedStatement ps = con.prepareStatement(insertQuery);
					ps.setInt(1, 27);
					ps.setInt(2, 14);
					ps.setString(3, "¹Ù´Ò¶ó¶ó¶¼");
					ps.setDouble(4, 2.5);
					ps.setString(5, "´Þ´ÞÇÑ ¹Ù´Ò¶ó¶ó¶¼");
					
					int rowsInsert = ps.executeUpdate();
					System.out.println(rowsInsert + " row Ãß°¡µÊ");
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}

}