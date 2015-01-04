package com.incheol.myapp.vo;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserInfo extends SqlSessionDaoSupport{
	private int userinfoID;
	private int userID;
	private String level;
	private String c_count;
	
	public int getUserinfoID() {
		return userinfoID;
	}
	public void setUserinfoID(int userinfoID) {
		this.userinfoID = userinfoID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getC_count() {
		return c_count;
	}
	public void setC_count(String c_count) {
		this.c_count = c_count;
	}

}