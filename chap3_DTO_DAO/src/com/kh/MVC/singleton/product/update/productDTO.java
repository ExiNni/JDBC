
package com.kh.MVC.singleton.product.update;

public class productDTO {

	private int product_id;
	private String product_name;
	private double price;
	
	public productDTO() {
		
	}

	public productDTO(int product_id, double price) {
		super();
		this.product_id = product_id;
		this.price = price;
	
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	
	public void setPrice(double price) {
		this.price = price;
	}

	public int getProduct_id() {
		return product_id;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "productDTO" + product_id;
	}
	
}
