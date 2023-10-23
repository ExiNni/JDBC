package com.kh.user.VODAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userDAO {
	private Connection connect;
	
	public userDAO(Connection connect) {
		this.connect = connect;
	}
	
	public boolean createUser(userVO user) {
		String sql = "INSERT INTO USERINFO (user_id, user_name, email, reg_date)"
				+ "VALUES (?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getEmail());
			ps.setDate(4, new Date(user.getRegDate().getTime()));
			
			int rows = ps.executeUpdate();
			return rows > 0; // 값이 들어오면 0 보다 커지므로 true 가 됨
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
