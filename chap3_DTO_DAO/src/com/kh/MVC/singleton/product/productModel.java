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
	// Ŭ������ �ν��Ͻ��� �����ϴ� �̱��� ��ü
	private static productModel ProductsModel = null;
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String ID = "khcafe";
	private static String PW = "kh1234";
	
	// �⺻ �����ڷκ��� �ܺο��� �ν��Ͻ��� ���� �����ϴ� ���� �����ϱ� ���� private ���� ����
	private productModel() {
		
	}
	// productModel Ŭ������ �ν��Ͻ��� ��ȯ�ϴ� �޼���
	// ó�� ȣ��� �� DB�� ������ �����ϰ� ���� ȣ�⿡���� �̹� ������ �ν��Ͻ��� ��ȯ
	// �̱��� ������ �����ϴ� ���
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