package com.incheol.myapp.vo;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class User extends SqlSessionDaoSupport{
	private int userID;
	private String username;
	private String userEmail;
	private String userPWD;
	
    public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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