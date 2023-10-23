package com.kh.user.VODAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class userMain {

	public static void main(String[] args) {
		// 1. DB연결 URL과 username, password
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
			
			Date regDate = new Date(); // 현재 날짜와 시간을 사용한다는 의미
			// DB에 담기 위해 인스턴스 생성 후 작성받은 정보 저장하기
			userVO newUser = new userVO();
			newUser.setUserId(userId);
			newUser.setUserName(userName);
			newUser.setEmail(userEmail);
			newUser.setRegDate(regDate);
			
			// 데이터가 정상적으로 들어갔는지 확인 boolean 으로
			if(userDao.createUser(newUser)) {
				System.out.println("USER가 성공적으로 등록되었습니다");
			} else {
				System.out.println("USER 등록에 실패하였습니다");
			}
			
			// 연결 닫기
			connect.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

