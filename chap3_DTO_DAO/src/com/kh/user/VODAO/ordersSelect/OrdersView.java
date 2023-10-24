package com.kh.user.VODAO.ordersSelect;

import java.util.List;

public class OrdersView {

	public void showOrders(List<OrdersDTO> orders) {
		for (OrdersDTO o : orders) {
			System.out.println("Cafe ID: " + o.getCafe_id());
			System.out.println("Menu ID: " + o.getMenu_id());
			System.out.println("Order Date: " + o.getOrder_date());
			System.out.println("Total Price: " + o.getTotal_price());
			System.out.println("==========================");
		}

	}
	
	public void showTotalPrice(int cafeId, double totalPrice) {
		System.out.println(cafeId + "번 카페의 총 매출: " + totalPrice);
		
	}
}
