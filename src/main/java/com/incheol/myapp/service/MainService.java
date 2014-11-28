package com.incheol.myapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.incheol.myapp.dao.Userdao;
import com.incheol.myapp.vo.Category;
import com.incheol.myapp.vo.registerinfo;

@Service
public class MainService {
	
	//생성되면 1 아니면 0 리턴
	public List<Category> Load_Category(){
		return Category.getcategorylist();
	}
}
