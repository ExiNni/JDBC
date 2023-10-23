package com.kh.user.VODAO.selectAnd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userDAO_selectAnd {

	Connection connect;
	
	public userDAO_selectAnd(Connection connect) {
		this.connect = connect;
	}
	
	public List<userVO_selectAnd> getAllUsers() {
		List<userVO_selectAnd> users = new ArrayList<>();
		String sql = "SELECT * FROM USERINFO";
		// try - with - resources
		// DB 리소스를 안전하게 사용하고 자동으로 닫아주기 위해서 사용되는 방법
		
		try {
			PreparedStatement ps = connect.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			// selectOne - If selectAll - while
			while(result.next()) {
				userVO_selectAnd user = new userVO_selectAnd();
				user.setUserID(result.getInt("user_id"));
				user.setUserName(result.getString("user_name"));
				user.setEmail(result.getString("email"));
				user.setRegDate(result.getDate("reg_date"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;

	}
	
}