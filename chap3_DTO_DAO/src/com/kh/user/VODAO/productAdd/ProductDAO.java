package com.kh.user.VODAO.productAdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	private Connection connect;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String pw = "kh1234";
	
	public ProductDAO() {
		try {
			connect = DriverManager.getConnection(url, user, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<ProductDTO> getAllproducts(){
		List<ProductDTO> products = new ArrayList<>();
		try {
			PreparedStatement ps = connect.prepareStatement("SELECT * FROM PRODUCTS");
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				int product_id = result.getInt("product_id");
				String product_name = result.getString("product_name");
				String 	category = result.getString("category");
				double price = result.getDouble("price");
				int stock_quantity = result.getInt("stock_quantity");
				
				ProductDTO product = new ProductDTO(product_id, product_name, category, price, stock_quantity);
				products.add(product);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}
	
}
