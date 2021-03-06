package com.incheol.myapp.vo;

import java.util.List;
import java.util.Map;





import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.incheol.myapp.dao.Userdao;

public class Board extends SqlSessionDaoSupport{
	private int boardID;
	private int categoryID;
	private int userID;
	private String title;
	private String content;
	private int count;
	private int r_count;
	private int l_count;
	
	public int getBoardID() {
		return boardID;
	}
	public void setBoardID(int boardID) {
		this.boardID = boardID;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getR_count() {
		return r_count;
	}
	public void setR_count(int r_count) {
		this.r_count = r_count;
	}
	public int getL_count() {
		return l_count;
	}
	public void setL_count(int l_count) {
		this.l_count = l_count;
	}
	
	
}