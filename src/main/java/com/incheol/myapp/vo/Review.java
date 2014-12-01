package com.incheol.myapp.vo;

import java.util.List;
import java.util.Map;



import org.mybatis.spring.support.SqlSessionDaoSupport;

public class Review extends SqlSessionDaoSupport{
	private int reviewID;
	private int r_boardID;
	private int r_userID;
	private String content;
	
	public int getReviewID() {
		return reviewID;
	}
	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}
	public int getR_boardID() {
		return r_boardID;
	}
	public void setR_boardID(int r_boardID) {
		this.r_boardID = r_boardID;
	}
	public int getR_userID() {
		return r_userID;
	}
	public void setR_userID(int r_userID) {
		this.r_userID = r_userID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}