package chap2.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class model {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String password = "kh1234";
	
	public void insertMenu(int cafe_id, String name, String address, String phone_number, String operating_hours) {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO CAFE (CAFE_ID, NAME, ADDRESS, PHONE_NUMBER, OPERATING_HOURS)"
					+ "VALUES(?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
