package com.incheol.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.incheol.myapp.dao.Userdao;
import com.incheol.myapp.vo.Category;

@Service
public class MainService {
	
	Category category = new Category();
	Userdao userDao = new Userdao();
	
	//생성되면 1 아니면 0 리턴
	public List<Category> Load_Category(){
		//return category.getcategorylist();
		return category.getcategorylist();
	}
}
