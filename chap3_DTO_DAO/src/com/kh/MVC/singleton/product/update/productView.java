package com.kh.MVC.singleton.product.update;

import java.sql.SQLException;
import java.util.Scanner;

public class productView {

	public void updateProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("업데이트할 상품의 ID 입력: ");
		int productID = sc.nextInt();
		System.out.println("수정할 가격: " );
		double price = sc.nextDouble();
		
		productDTO newProduct = new productDTO(productID, price);
		productModel ProductModel;
		boolean success = false;
		
		try {
			ProductModel = productModel.getInstance();
			success = ProductModel.updateProduct(newProduct);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(success) {
			System.out.println("제품이 성공적으로 업데이트 되었습니다.");
		} else {
			System.out.println("제품 업데이트 중 오류가 발생했습니다.");
		}
		
	}
}