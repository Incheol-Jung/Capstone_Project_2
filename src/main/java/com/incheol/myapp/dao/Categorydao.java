package com.incheol.myapp.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.incheol.myapp.vo.Category;

@Repository
public class Categorydao extends SqlSessionDaoSupport{
	
	public List<Category> getcategorylist(){
		System.out.println("dao");
		return (List<Category>)getSqlSession().selectList("Category.getcategorylist");
	}
}