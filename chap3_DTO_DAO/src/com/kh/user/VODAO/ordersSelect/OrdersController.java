package com.kh.user.VODAO.ordersSelect;

import java.util.List;

	public class OrdersController {
	
		private OrdersDAO dao;
		
		public OrdersController(OrdersDAO dao) {
			this.dao = dao;
		}
		
		public double calculateTotalPrice(List<OrdersDTO> orders) {
			double totalPrice = 0;
			
			for(OrdersDTO o : orders) {
				totalPrice += o.getTotal_price();
			}
			return totalPrice;
		}
		
		public List<OrdersDTO> getAllOrders(int cafeId) {
	        return dao.getAllOrders(cafeId);
	    }
	}
