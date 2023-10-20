package com.kh.MVC.singleton.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class productModel {
/*
	
	private Connection connection;
	
	
	public productModel(Connection connection) {
		this.connection = connection;
	}
	
	public List<productDTO> getProducts(){
		List<productDTO> products = new ArrayList<>();
		String query = "SELECT * FROM PRODUCTS";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				productDTO product = new productDTO();
				product.setProduct_id(result.getInt("product_id"));
				product.setProduct_name(result.getString("product_name"));
				product.setCategory(result.getString("category"));
				product.setPrice(result.getDouble("price"));
				product.setStock_quantity(result.getInt("stock_quantity"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	*/
	
	private static Connection connection;
	// 클래스의 인스턴스를 저장하는 싱글톤 객체
	private static productModel ProductsModel = null;
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String ID = "khcafe";
	private static String PW = "kh1234";
	
	// 기본 생성자로부터 외부에서 인스턴스를 직접 생성하는 것을 방지하기 위해 private 으로 선언
	private productModel() {
		
	}
	// productModel 클래스의 인스턴스를 반환하는 메서드
	// 처음 호출될 때 DB에 연결을 설정하고 이후 호출에서는 이미 생성된 인스턴스를 반환
	// 싱글턴 패턴을 구현하는 방식
	public static productModel getInstance() throws SQLException {
		if(ProductsModel == null) {
			ProductsModel = new productModel();
			connection = DriverManager.getConnection(DB_URL, ID, PW);
			
			
		}
		return ProductsModel;
	}
	
	public boolean insertProduct(productDTO product) {
		String sql = "INSERT INTO PRODUCTS (PRODUCT_ID, PRODUCT_NAME, CATEGORY, PRICE, STOCK_QUANTITY)"
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, product.getProduct_id());
			ps.setString(2, product.getProduct_name());
			ps.setString(3, product.getCategory());
			ps.setDouble(4, product.getPrice());
			ps.setInt(5, product.getStock_quantity());
			
			int rowsAffected = ps.executeUpdate();
			
			return rowsAffected > 0 ;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}