package com.kh.user.VODAO.Product_Bank;

import java.util.Date;

/*
 * ACCOUNT_ID, ACCOUNT_NUMBER, ACCOUNT_NAME, BALANCE, BRANCH_NAME, LAST_TRANSACTION_DATE
 */
public class bankDTO {

	private int ACCOUNT_ID;
	private String ACCOUNT_NUMBER;
	private String ACCOUNT_NAME;
	private double BALANCE;
	private String BRANCH_NAME;
	private Date LAST_TRANSACTION_DATE;

	public bankDTO() {
	}

	public bankDTO(int ACCOUNT_ID, String ACCOUNT_NUMBER, String ACCOUNT_NAME, double BALANCE, String BRANCH_NAME,
			Date LAST_TRANSACTION_DATE) {
		super();
		this.ACCOUNT_ID = ACCOUNT_ID;
		this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
		this.ACCOUNT_NAME = ACCOUNT_NAME;
		this.BALANCE = BALANCE;
		this.BRANCH_NAME = BRANCH_NAME;
		this.LAST_TRANSACTION_DATE = LAST_TRANSACTION_DATE;
	}

	public void setACCOUNT_ID(int ACCOUNT_ID) {
		this.ACCOUNT_ID = ACCOUNT_ID;
	}

	public void setACCOUNT_NUMBER(String ACCOUNT_NUMBER) {
		this.ACCOUNT_NUMBER = ACCOUNT_NUMBER;
	}

	public void setACCOUNT_NAME(String ACCOUNT_NAME) {
		this.ACCOUNT_NAME = ACCOUNT_NAME;
	}

	public void setBALANCE(double BALANCE) {
		this.BALANCE = BALANCE;
	}

	public void setBRANCH_NAME(String BRANCH_NAME) {
		this.BRANCH_NAME = BRANCH_NAME;
	}

	public void setLAST_TRANSACTION_DATE(Date LAST_TRANSACTION_DATE) {
		this.LAST_TRANSACTION_DATE = LAST_TRANSACTION_DATE;
	}

	public int getACCOUNT_ID() {
		return ACCOUNT_ID;
	}

	public String getACCOUNT_NUMBER() {
		return ACCOUNT_NUMBER;
	}

	public String getACCOUNT_NAME() {
		return ACCOUNT_NAME;
	}

	public double getBALANCE() {
		return BALANCE;
	}

	public String getBRANCH_NAME() {
		return BRANCH_NAME;
	}

	public Date getLAST_TRANSACTION_DATE() {
		return LAST_TRANSACTION_DATE;
	}

}
