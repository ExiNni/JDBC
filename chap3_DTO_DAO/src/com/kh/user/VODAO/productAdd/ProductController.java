package com.kh.user.VODAO.productAdd;

import java.util.List;

public class ProductController {

	private ProductDAO dao;
	
	public ProductController (ProductDAO dao) {
		this.dao = dao;
	}
	
	// 총 가격 메서드
	public double calculateTotalPrice(List<ProductDTO> products) {
		double totalPrice = 0;
		// 향상된 for문을 활용하여 가격을 더해줄 것이기 때문
		for(ProductDTO totalP: products) {
			totalPrice += totalP.getPrice();
		}
		return totalPrice;
	}
	
	// 모든 제품 리스트
	public List<ProductDTO> getAllProduct() {
		
		return dao.getAllproducts();
	}
}
