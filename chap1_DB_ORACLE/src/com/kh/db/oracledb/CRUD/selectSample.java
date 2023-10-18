package com.kh.db.oracledb.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class selectSample {

	public static void main(String[] args) {
	}

	static void SelectAll() {
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
						+ ", ACCOUNT_NAME: " + accountName + ", BALANCE: " + balance + ", BRANCH_NAME: " + branchName
						+ ", LAST_TRANCSACTION: " + last);
			}
			selectState.close();

		} catch (SQLException e) {
			System.out.println("DB ���� ����");
			System.exit(0);
		}

	}

	static void selectOne() {
		// 1. ����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸�
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 2. ����Ŭ �� ��ǻ�� ���� : ������ ���̽� ���� ����
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "1234";
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			// where �� �߰��Ͽ� ���� �߰�
			String selectQuery = "SELECT* FROM BANK WHERE account_number in (?, ?, ?, ?, ?, ?) order by account_id asc";
			PreparedStatement ps = con.prepareStatement(selectQuery);

			String[] targetAN = { "1234567890", "1234567899", "02349589048", "1111222233", "5555666777", "2340956812" };
			ps.setString(1, targetAN[0]);
			ps.setString(2, targetAN[1]);
			ps.setString(3, targetAN[2]);
			ps.setString(4, targetAN[3]);
			ps.setString(5, targetAN[4]);
			ps.setString(6, targetAN[5]);

			// ���⿡ ���ϴ� ������ account_id ����
			// int targetAID = 1;

			// ���� ����
			// ps.setInt(3, targetAID);

			ResultSet result = ps.executeQuery();
			boolean istrue = false;

			while (result.next()) {
				int a = result.getInt("account_id");
				String b = result.getString("account_number");
				String c = result.getString("account_name");
				int d = result.getInt("balance");
				String e = result.getString("branch_name");
				Date f = result.getDate("last_transaction_date");
				System.out.println("ACCOUNT ID: " + a + ", ACCOUNT NUMBER: " + b + ", ACCOUNT_NAME: " + c
						+ ", BALANCE: " + d + ", BRANCH NAME: " + e + ", DATE: " + f);
				istrue = true;
			}

			if (!istrue) {
				System.out.println("���ǿ� �ش��ϴ� �����Ͱ� �����ϴ�");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}