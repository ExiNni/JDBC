package com.kh.user.VODAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class userMain {

	public static void main(String[] args) {
		// 1. DB���� URL�� username, password
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String pw = "kh1234";
		
		try {
			Connection connect = DriverManager.getConnection(url, user, pw);
			userDAO userDao = new userDAO(connect);
			Scanner sc = new Scanner(System.in);
			System.out.println("User ID: ");
			int userId = sc.nextInt();
			System.out.println("User Name: ");
			String userName = sc.next();
			System.out.println("User Email: ");
			String userEmail = sc.next();
			
			Date regDate = new Date(); // ���� ��¥�� �ð��� ����Ѵٴ� �ǹ�
			// DB�� ��� ���� �ν��Ͻ� ���� �� �ۼ����� ���� �����ϱ�
			userVO newUser = new userVO();
			newUser.setUserId(userId);
			newUser.setUserName(userName);
			newUser.setEmail(userEmail);
			newUser.setRegDate(regDate);
			
			// �����Ͱ� ���������� ������ Ȯ�� boolean ����
			if(userDao.createUser(newUser)) {
				System.out.println("USER�� ���������� ��ϵǾ����ϴ�");
			} else {
				System.out.println("USER ��Ͽ� �����Ͽ����ϴ�");
			}
			
			// ���� �ݱ�
			connect.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

