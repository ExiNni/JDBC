package com.kh.user.VODAO;

import java.util.Date;

public class userVO {
	private int userId; // ����� id
	private String userName; // ����� �̸�
	private String email; // ���� �̸���
	private Date regDate; // ��� ��¥

	public userVO() {
		
	}
	
	public userVO(int userId, String userName, String email, Date regDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.regDate = regDate;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public int getUserId() {
		return userId;
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
