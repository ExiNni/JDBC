package com.kh.db.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertBook {
	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertSQL = "INSERT INTO CAFES (CAFE_ID, NAME, ADDRESS, PHONE_NUMBER, OPERATING_HOURS)"
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			insertCafe(ps, 1, "스타벅스", "서울시 강서구 마곡동", "010-1234-3513", "매일 07:00 ~ 20:00");
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	static void insertCafe(PreparedStatement ps, int cafe_id, String name, String address, String phone_number, String operating_hours) throws SQLException {
		ps.setInt(1, cafe_id);
		ps.setString(2, name);
		ps.setString(3, address);
		ps.setString(4, phone_number);
		ps.setString(5, operating_hours);
		
		ps.executeUpdate();
	}
}
