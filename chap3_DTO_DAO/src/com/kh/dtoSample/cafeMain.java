package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class cafeMain {

	public static void main(String[] args) {
		// connection�� ������ ���� �ۼ�
		// url, username, password
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			// �ν��Ͻ� �����Ͽ� �� �ʱ�ȭ
			cafeView view = new cafeView();
			
			// �ν��Ͻ� �����Ͽ� ��Ʈ�ѷ� �ʱ�ȭ
			cafeController controller = new cafeController(con, view);
			
			// ī�� ���� ǥ���ϴ� �޼��� ��������
			controller.displayAllCafe();
			
			// connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
