package com.kh.user.VODAO.selectAll;

import java.util.Date;

public class userVO_selectAll {

	private int userID;
	private String userName;
	private String email;
	private Date regDate;

	public userVO_selectAll() {
		
	}
	
	public userVO_selectAll(int userID, String userName, String email, Date regDate) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.email = email;
		this.regDate = regDate;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getUserID() {
		return userID;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public Date getRegDate() {
		return regDate;
	}

}
