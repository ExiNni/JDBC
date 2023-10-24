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
	 * System.out.println("송금할 ID: "); int transferId = sc.nextInt();
	 * System.out.println("송금 받을 ID: "); int getterId = sc.nextInt();
	 * System.out.println("송금할 금액: "); double amount = sc.nextDouble();
	 * 
	 * 
	 * bankVO transferVO = new bankVO(); transferVO.setAccount_id(transferId);
	 * transferVO.setBalance(-amount); boolean isTransferred =
	 * bankdao.transact(transferVO);
	 * 
	 * if (isTransferred) { System.out.println("송금이 완료되었습니다."); } else {
	 * System.out.println("송금에 실패했습니다."); }
	 * 
	 * bankVO getVO = new bankVO(); getVO.setAccount_id(getterId);
	 * getVO.setAccount_id(transferId); boolean isTrue = bankdao.getter(getVO);
	 * boolean isTrue2 = bankdao.transact(transferVO);
	 * 
	 * if (isTrue && isTrue2) { System.out.println("송금 받는 계좌의 잔액: " +
	 * getVO.getBalance()); System.out.println("송금 보내는 계좌의 잔액: " +
	 * transferVO.getBalance()); } else { System.out.println("계좌 정보를 찾을 수 없습니다."); }
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
			System.out.println("송금할 ID: ");
			int transferId = sc.nextInt();
			System.out.println("송금 받을 ID: ");
			int getterId = sc.nextInt();

			bankVO transferVO = new bankVO();
			transferVO.setAccount_id(transferId);
			transferVO.setAccount_id(getterId);
			
			boolean isTransferred = bankdao.transact2(transferVO);

			if (isTransferred) {
				System.out.println("송금이 완료되었습니다.");
			} else {
				System.out.println("송금에 실패했습니다.");
			}

			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
