package com.incheol.myapp.vo;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class User extends SqlSessionDaoSupport{
	private int userID;
	private String userName;
	private String userEmail;
	private String userPWD;
	
    public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPWD() {
		return userPWD;
	}
	public void setUserPWD(String userPWD) {
		this.userPWD = userPWD;
	}
    
}