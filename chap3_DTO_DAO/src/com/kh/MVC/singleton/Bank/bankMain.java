package com.kh.MVC.singleton.Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class bankMain {

	/*
	 * public static void main(String[] args) { String url =
	 * "jdbc:oracle:thin:@localhost:1521:xe"; String user = "khbank"; String pw =
	 * "1234";
	 * 
	 * try { Connection connect = DriverManager.getConnection(url, user, pw);
	 * bankDAO bankdao = new bankDAO(connect); Scanner sc = new Scanner(System.in);
	 * System.out.println("�۱��� ID: "); int transferId = sc.nextInt();
	 * System.out.println("�۱� ���� ID: "); int getterId = sc.nextInt();
	 * System.out.println("�۱��� �ݾ�: "); double amount = sc.nextDouble();
	 * 
	 * 
	 * bankVO transferVO = new bankVO(); transferVO.setAccount_id(transferId);
	 * transferVO.setBalance(-amount); boolean isTransferred =
	 * bankdao.transact(transferVO);
	 * 
	 * if (isTransferred) { System.out.println("�۱��� �Ϸ�Ǿ����ϴ�."); } else {
	 * System.out.println("�۱ݿ� �����߽��ϴ�."); }
	 * 
	 * bankVO getVO = new bankVO(); getVO.setAccount_id(getterId);
	 * getVO.setAccount_id(transferId); boolean isTrue = bankdao.getter(getVO);
	 * boolean isTrue2 = bankdao.transact(transferVO);
	 * 
	 * if (isTrue && isTrue2) { System.out.println("�۱� �޴� ������ �ܾ�: " +
	 * getVO.getBalance()); System.out.println("�۱� ������ ������ �ܾ�: " +
	 * transferVO.getBalance()); } else { System.out.println("���� ������ ã�� �� �����ϴ�."); }
	 * 
	 * connect.close(); } catch (SQLException e) { e.printStackTrace(); } }
	 */

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String pw = "1234";

		try {
			Connection connect = DriverManager.getConnection(url, user, pw);
			bankDAO bankdao = new bankDAO(connect);
			Scanner sc = new Scanner(System.in);
			System.out.println("�۱��� ID: ");
			int transferId = sc.nextInt();
			System.out.println("�۱� ���� ID: ");
			int getterId = sc.nextInt();

			bankVO transferVO = new bankVO();
			transferVO.setAccount_id(transferId);
			transferVO.setAccount_id(getterId);
			
			boolean isTransferred = bankdao.transact2(transferVO);

			if (isTransferred) {
				System.out.println("�۱��� �Ϸ�Ǿ����ϴ�.");
			} else {
				System.out.println("�۱ݿ� �����߽��ϴ�.");
			}

			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
