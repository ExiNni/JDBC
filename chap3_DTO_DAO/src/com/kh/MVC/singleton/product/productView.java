package com.kh.MVC.singleton.product;

import java.sql.SQLException;
import java.util.Scanner;

public class productView {
/*
	public void displayProducts(List<productDTO> products) {
		for(productDTO p : products) {
			System.out.println("PRODUCT_ID: " + p.getProduct_id());
			System.out.println("PRODUCT_NAME: " + p.getProduct_name());
			System.out.println("CATEGORY: " + p.getCategory());
			System.out.println("PRICE: " + p.getPrice());
			System.out.println("STOCK_QUANTITY: " + p.getStock_quantity());
			System.out.println();
		}
	}
	*/
	
	public void addProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("새 제품 정보를 입력하세요");
		System.out.println("제품 ID: ");
		int productId = sc.nextInt();
		
		System.out.println("제품 이름: ");
		String productName = sc.next();
		
		System.out.println("카테고리: ");
		String category = sc.nextLine();
		
		System.out.println("가격: ");
		double price = sc.nextDouble();
		
		System.out.println("수량: ");
		int sQ = sc.nextInt();
		
		// Scanner로 받은 제품내용을 새로 추가하기
		productDTO newProduct = new productDTO(productId, productName, category, price, sQ);
		productModel ProductModel;
		boolean success = false;
		
		try {
			ProductModel = productModel.getInstance();
			success = ProductModel.insertProduct(newProduct);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(success) {
			System.out.println("제품이 성공적으로 추가되었습니다.");
		} else {
			System.out.println("제품 추가 중 오류가 발생했습니다.");
		}
		
	}
}
