package com.kh.user.VODAO.selectAll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class userMain_selectAll {

	public static void main(String[] args) {
		userMain_selectAll select = new userMain_selectAll();
		select.selectScanner();
	}

	public void selectAll() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String pw = "kh1234";

		try {
			Connection connect = DriverManager.getConnection(url, user, pw);
			userDAO_selectAll userDAO = new userDAO_selectAll(connect);
			List<userVO_selectAll> users = userDAO.getAllUsers();

			for (userVO_selectAll u : users) {
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

	public void selectScanner() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String pw = "kh1234";

		try {
			Connection connect = DriverManager.getConnection(url, user, pw);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("USER ID를 입력해주세요: ");
				System.out.println("[E]키를 입력하여 종료");
				String id = sc.next();
				
				// 만약에 E를 입력했다면
				if("e".equalsIgnoreCase(id)) {
					System.out.println("종료");
					break;
				}
				int userId = Integer.parseInt(id);
				String sql = "SELECT * FROM USERINFO WHERE user_id = ?";
				PreparedStatement ps = connect.prepareStatement(sql);
				ps.setInt(1, userId);
				ResultSet result = ps.executeQuery();
				
				// selectOne if
				if(result.next()) {
					System.out.println("USER ID: " + result.getInt("user_id"));
					System.out.println("USER NAME: " + result.getString("user_name"));
					System.out.println("USER EMAIL:" + result.getString("email"));
					System.out.println("REGISTER DATE: " + result.getDate("reg_date"));
					System.out.println();
					
					
				}else {
					System.out.println("USER를 찾을 수 없습니다.");
					System.out.println();
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
