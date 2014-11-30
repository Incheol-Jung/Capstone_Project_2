package com.incheol.myapp.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.incheol.myapp.vo.Category;

public class Categorydao extends SqlSessionDaoSupport{
	
	public List<Category> getcategorylist(){
		return (List<Category>)getSqlSession().selectList("Category.getcategorylist");
	}
}