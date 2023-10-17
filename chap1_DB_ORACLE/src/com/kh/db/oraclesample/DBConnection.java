package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
		// 1. ����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸�
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 2. ����Ŭ �� ��ǻ�� ���� : ������ ���̽� ���� ����
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";
		Connection con = null;

		try {
			// ������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ����
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB ���� ����");

			// SELECT ����
			String selectQuery = "SELECT * FROM BANK";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery(selectQuery);
			// result.next() : result ��ü���� ���� ��(row)���� �̵�
			// �������� ������ true ��ȯ, �׷��� ������ false
			// khbank�� �ִ� bank table ��� ���տ��� account_ID�� ������
			
			
			while (result.next()) {
				int accountID = result.getInt("account_id");
				String accountName = result.getString("account_name");
				double balance = result.getDouble("balance");
				String accountNumber = result.getString("account_number");
				String branchName = result.getString("branch_name");
				Date last = result.getDate("last_transaction_date");
				
				System.out.println("ACCOUNT_ID: " + accountID + ", ACCOUNT_NUMBER: " + accountNumber 
						+ ", ACCOUNT_NAME: " + accountName
						+ ", BALANCE: " + balance + ", BRANCH_NAME: " + branchName
						+ ", LAST_TRANCSACTION: " + last);
			}
			selectState.close();
			
		} catch (SQLException e) {
			System.out.println("DB ���� ����");
			System.exit(0);
		}

	}
}