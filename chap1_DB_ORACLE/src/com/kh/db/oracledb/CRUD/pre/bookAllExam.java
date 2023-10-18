package com.kh.db.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class bookAllExam {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO BOOK (BOOK_ID, TITLE, AUTHOR)"
					+ "VALUES (?, ?, ?)";
			
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setInt(1, 31);
			ps.setString(2, "위대한KH");
			ps.setString(3, "홍길동");
			
			ps.executeUpdate();
			System.out.println("책 insert 저장");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
