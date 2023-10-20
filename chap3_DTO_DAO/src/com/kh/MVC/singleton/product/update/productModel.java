package com.kh.MVC.singleton.product.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class productModel {
	private static Connection connect;
	private static productModel pM = null;
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "khcafe";
	private static String pw = "kh1234";

	private productModel() {

	}
	
	public static productModel getInstance() throws SQLException {
		if(pM == null) {
			pM = new productModel();
			connect = DriverManager.getConnection(url, user, pw);
			
		}
		return pM;
	}
	public boolean updateProduct(productDTO product) {
		String sql = "UPDATE PRODUCT SET PRICE = ? WHERE PRODUCT_ID = ?";
		PreparedStatement ps;
		try {
			ps = connect.prepareStatement(sql);
			ps.setDouble(1, product.getPrice());
			ps.setInt(2, product.getProduct_id());
			
			int rowsAffected = ps.executeUpdate();
			
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
