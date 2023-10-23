package com.kh.user.VODAO;

import java.util.Date;

public class userVO {
	private int userId; // 사용자 id
	private String userName; // 사용자 이름
	private String email; // 유저 이메일
	private Date regDate; // 등록 날짜

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
