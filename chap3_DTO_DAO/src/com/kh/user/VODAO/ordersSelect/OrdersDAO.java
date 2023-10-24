package com.kh.user.VODAO.ordersSelect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersDAO {

	private Connection connect;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String pw = "kh1234";
	public OrdersDAO() {
		try {
			connect = DriverManager.getConnection(url, user, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<OrdersDTO> getAllOrders(int cafeId){
		List<OrdersDTO>	orders = new ArrayList<>();
		PreparedStatement ps;
		
		
		try {
			
			ps = connect.prepareStatement("SELECT* FROM ORDERS WHERE CAFE_ID = ?");
			ps.setInt(1, cafeId);
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				int order_id = result.getInt("order_id");
				int cafe_id = result.getInt("cafe_id");
				int menu_id = result.getInt("menu_id");
				Date order_date = result.getDate("order_date");
				int quantity = result.getInt("quantity");
				double total_price = result.getDouble("total_price");
				String menu_name = result.getString("menu_name");
				
				OrdersDTO order = new OrdersDTO(order_id, cafe_id, menu_id, order_date, quantity, total_price, menu_name);
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return orders;
	}
}
