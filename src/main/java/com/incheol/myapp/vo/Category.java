package com.incheol.myapp.vo;

import java.util.List;
import java.util.Map;



import org.mybatis.spring.support.SqlSessionDaoSupport;

public class Category extends SqlSessionDaoSupport{
	private int categoryID;
	private String categoryName;
	
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public List<Category> getcategorylist(){
		return (List<Category>)getSqlSession().selectList("Category.getcategorylist");
	}
}