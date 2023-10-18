package com.kh.db.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertExam {

	public static void main(String[] args) {
		// cafes insert �ۼ��ؼ� ���� ī�� �߰��ϱ�
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";

		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertSQL = "INSERT INTO CAFES (cafe_id, name, address, phone_number, operating_hours)"
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			insertCafe(ps, 1, "��Ÿ����", "����� ������ ���", "02-1234-5521", "��-��: 07:00-21:00, �ָ�: 08:00-20:00");
			insertCafe(ps, 3, "�ٳ�������", "����� ������ �߻굿", "02-1255-4565", "����: 07:30-19:30");
			insertCafe(ps, 5, "��ٹ�", "����� ���� �ұ���", "02-1255-4366", "��-��: 07:00-21:00, �ָ�: 08:00-20:00");
			insertCafe(ps, 7, "�̵��", "����� ���α� ��û��", "02-4566-7421", "����: 07:30-19:30");
			insertCafe(ps, 9, "������", "����� ������ ��õ��", "02-5641-4661", "��-��: 07:00-21:00, �ָ�: 08:00-20:00");

			int rowInsert = ps.executeUpdate();
			System.out.println(rowInsert + "row �߰���");
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	static void insertCafe(PreparedStatement ps, int cafe_id, String name, String address, String phone_number,
			String operating_hours) throws SQLException {
		ps.setInt(1, cafe_id);
		ps.setString(2, name);
		ps.setString(3, address);
		ps.setString(4, phone_number);
		ps.setString(5, operating_hours);
		ps.executeUpdate();

	}
}
