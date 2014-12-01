package com.incheol.myapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incheol.myapp.dao.Categorydao;
import com.incheol.myapp.vo.Category;

@Service
public class MainService {
	
	@Resource(name="Categorydao")  
	private Categorydao category; 
	
	//�����Ǹ� 1 �ƴϸ� 0 ����
	public List<Category> Load_Category(){
		//return category.getcategorylist();
		System.out.println("dd");
		List<Category> dd = category.getcategorylist();
		System.out.println(dd.size());
		 
		 return dd;
	}
}
