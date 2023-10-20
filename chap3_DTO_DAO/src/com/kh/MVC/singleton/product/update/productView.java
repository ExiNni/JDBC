package com.kh.MVC.singleton.product.update;

import java.sql.SQLException;
import java.util.Scanner;

public class productView {

	public void updateProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ʈ�� ��ǰ�� ID �Է�: ");
		int productID = sc.nextInt();
		System.out.println("������ ����: " );
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
			System.out.println("��ǰ�� ���������� ������Ʈ �Ǿ����ϴ�.");
		} else {
			System.out.println("��ǰ ������Ʈ �� ������ �߻��߽��ϴ�.");
		}
		
	}
}