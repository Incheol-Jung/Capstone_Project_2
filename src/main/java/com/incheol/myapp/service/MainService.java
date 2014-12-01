package com.incheol.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.incheol.myapp.dao.Categorydao;
import com.incheol.myapp.dao.Userdao;
import com.incheol.myapp.vo.Category;

@Service
public class MainService {
	
	Categorydao category = new Categorydao();
	
	//�����Ǹ� 1 �ƴϸ� 0 ����
	public List<Category> Load_Category(){
		//return category.getcategorylist();
		return category.getcategorylist();
	}
}
