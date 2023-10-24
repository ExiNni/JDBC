package com.kh.user.VODAO.ordersAdd;

import java.util.List;

public class OrdersMain {

	public static void main(String[] args) {
		OrdersDAO dao = new OrdersDAO();
		OrdersController controller = new OrdersController(dao);
		OrdersView view = new OrdersView();
		
		List<OrdersDTO> orders = controller.getAllOrders();
		view.showOrders(orders);
		
		double totalPrice = controller.calculateTotalPrice(orders);
		view.showTotalPrice(totalPrice);
	}
}
