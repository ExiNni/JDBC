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
		System.out.println("�� ��ǰ ������ �Է��ϼ���");
		System.out.println("��ǰ ID: ");
		int productId = sc.nextInt();
		
		System.out.println("��ǰ �̸�: ");
		String productName = sc.next();
		
		System.out.println("ī�װ�: ");
		String category = sc.nextLine();
		
		System.out.println("����: ");
		double price = sc.nextDouble();
		
		System.out.println("����: ");
		int sQ = sc.nextInt();
		
		// Scanner�� ���� ��ǰ������ ���� �߰��ϱ�
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
			System.out.println("��ǰ�� ���������� �߰��Ǿ����ϴ�.");
		} else {
			System.out.println("��ǰ �߰� �� ������ �߻��߽��ϴ�.");
		}
		
	}
}
