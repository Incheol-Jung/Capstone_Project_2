package com.incheol.myapp.vo;

import java.util.List;
import java.util.Map;



import org.mybatis.spring.support.SqlSessionDaoSupport;

public class User extends SqlSessionDaoSupport{
	public int userID;
	public String userEmail;
    public String userPassword;
    
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
    
}