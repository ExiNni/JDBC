package com.kh.MVC.singleton.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class productMain {

	public static void main(String[] args) {
		productView view = new productView();
		view.addProduct();

	}
}
