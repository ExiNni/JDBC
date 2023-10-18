package com.kh.db.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertExam {

	public static void main(String[] args) {
		// cafes insert 작성해서 여러 카페 추가하기
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "kh1234";

		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertSQL = "INSERT INTO CAFES (cafe_id, name, address, phone_number, operating_hours)"
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			insertCafe(ps, 1, "스타벅스", "서울시 강남구 도곡동", "02-1234-5521", "월-금: 07:00-21:00, 주말: 08:00-20:00");
			insertCafe(ps, 3, "바나프레소", "서울시 강서구 발산동", "02-1255-4565", "매일: 07:30-19:30");
			insertCafe(ps, 5, "백다방", "서울시 은평구 불광동", "02-1255-4366", "월-금: 07:00-21:00, 주말: 08:00-20:00");
			insertCafe(ps, 7, "이디야", "서울시 종로구 삼청동", "02-4566-7421", "매일: 07:30-19:30");
			insertCafe(ps, 9, "컴포즈", "서울시 강동구 마천동", "02-5641-4661", "월-금: 07:00-21:00, 주말: 08:00-20:00");

			int rowInsert = ps.executeUpdate();
			System.out.println(rowInsert + "row 추가됨");
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
