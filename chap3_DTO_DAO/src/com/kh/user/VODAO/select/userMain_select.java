package com.kh.user.VODAO.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class userMain_select {

	public static void main(String[] args) {
		userMain_select select = new userMain_select();
		select.selectAll();
	}
	
	public void selectAll() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String pw = "kh1234";
		
		try {
			Connection connect = DriverManager.getConnection(url, user, pw);
			userDAO_select userDAO = new userDAO_select(connect);
			List<userVO_select> users = userDAO.getAllUsers();
			
			for(userVO_select u : users) {
				System.out.println("USER ID: " + u.getUserID());
				System.out.println("USER NAME: " + u.getUserName());
				System.out.println("USER EMAIL: " + u.getEmail());
				System.out.println("REGISTER DATE: " + u.getRegDate());
				System.out.println();
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
