package chap2_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.net.jdbc.TNSAddress.Description;

public class cafeModel {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String password = "kh1234";
	
	public void insertCafe(String name, String address, String phone_number, String operating_hours) {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공!");
			String sql = "INSERT INTO CAFE (NAME, ADDRESS, PHONE_NUMBER, OPERATING_HOURS)"
					+ "VALUES(?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, phone_number);
			ps.setString(4, operating_hours);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void UpdateMenu(String DESCRIPTION, int MENU_ID, int CAFE_ID) {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "UPDATE MENU SET DESCRIPTION = ? WHERE MENU_ID = ? AND CAFE_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, DESCRIPTION);
			ps.setInt(2, MENU_ID);
			ps.setInt(3, CAFE_ID);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCafe(String operating_hours, int cafe_id) {
		// 카페 운영시간 수정하기
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "UPDATE CAFE SET OPERATING_HOURS = ? WHERE CAFE_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, operating_hours);
			ps.setInt(2, cafe_id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCafe(int cafe_id) {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "DELETE FROM CAFE WHERE CAFE_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cafe_id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMenu(int MENU_ID, int CAFE_ID) {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "DELETE FROM MENU WHERE MENU_ID = ? AND CAFE_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, MENU_ID);
			ps.setInt(2, CAFE_ID);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void selectCafe(int cafe_id) {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공!");
			String sql = "SELECT MENU_ID, MENU_NAME, DESCRIPTION FROM MENU WHERE CAFE_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cafe_id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
