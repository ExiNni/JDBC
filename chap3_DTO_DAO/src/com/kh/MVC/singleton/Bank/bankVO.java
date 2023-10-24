package com.kh.MVC.singleton.Bank;

import java.util.Date;

public class bankVO {

	private int account_id;
	private String account_number;
	private String account_name;
	private double balance;
	private Date last_transaction_date;

	public bankVO() {
		
	}
	
	public bankVO(int account_id, String account_number, String account_name, double balance, Date last_transaction_date) {
		super();
		this.account_id = account_id;
		this.account_number = account_number;
		this.account_name = account_name;
		this.balance = balance;
		this.last_transaction_date = last_transaction_date;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setLast_transaction_date(Date last_transaction_date) {
		this.last_transaction_date = last_transaction_date;
	}

	public int getAccount_id() {
		return account_id;
	}

	public String getAccount_number() {
		return account_number;
	}

	public String getAccount_name() {
		return account_name;
	}

	public double getBalance() {
		return balance;
	}

	public Date getLast_transaction_date() {
		return last_transaction_date;
	}

}
