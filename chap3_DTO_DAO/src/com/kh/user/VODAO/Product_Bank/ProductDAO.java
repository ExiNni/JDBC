package com.kh.user.VODAO.Product_Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDAO {
	private Connection connect;
	private List<ProductDTO> shoppingCart;
	private Scanner scanner;

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "khcafe";
	String pw = "kh1234";

	public ProductDAO() {
		try {
			connect = DriverManager.getConnection(url, user, pw);
			shoppingCart = new ArrayList<>();
			scanner = new Scanner(System.in);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ProductDTO getProductByID() {
		System.out.print("��ٱ��Ͽ� ���� ��ǰ ID ����: ");
		int pID = scanner.nextInt();
		scanner.nextLine();

		ProductDTO product = null;
		try {
			PreparedStatement ps = connect.prepareStatement("SELECT * FROM PRODUCTS WHERE PRODUCT_ID = ?");
			ps.setInt(1, pID);
			ResultSet result = ps.executeQuery();

			if (result.next()) {
				int product_id = result.getInt("product_id");
				String product_name = result.getString("product_name");
				String category = result.getString("category");
				double price = result.getDouble("price");
				int stock_quantity = result.getInt("stock_quantity");

				product = new ProductDTO(product_id, product_name, category, price, stock_quantity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	public void addToCart() {
		ProductDTO product = getProductByID();

		if (product != null) {

			shoppingCart.add(product);
			System.out.println("��ǰ�� ��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
		} else {
			System.out.println("��ǰ�� ã�� �� �����ϴ�.");
		}
	}

	public void displayCart() {
		System.out.println("��ٱ��� ���:");
		for (ProductDTO product : shoppingCart) {
			System.out.println(product.getProduct_id() + ", " + product.getProduct_name() + ", " + product.getPrice());
		}
	}

	public void deleteCart() {
		System.out.println("��ٱ��� ���:");
		for (int i = 0; i < shoppingCart.size() ; i++) {
			ProductDTO product = shoppingCart.get(i);
			System.out.println(i + ". " + product.getProduct_name());
		}
		System.out.print("������ ��� ���� (��ȣ �Է�): ");
		int choice = scanner.nextInt();
		scanner.nextLine();

		if (choice >= 0 && choice < shoppingCart.size()) {
			ProductDTO removedProduct = shoppingCart.remove(choice);
			System.out.println("��ǰ�� ��ٱ��Ͽ��� ���ŵǾ����ϴ�: " + removedProduct);
		} else {
			System.out.println("��ȿ���� ���� �����Դϴ�.");
		}
	}
	
	public double calculateTotalPrice() {
	    double totalPrice = 0;
	    for (ProductDTO product : shoppingCart) {
	        totalPrice += product.getPrice();
	    }
	    return totalPrice;
	}
	
	

}
