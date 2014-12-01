package com.incheol.myapp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.incheol.myapp.service.MainService;
import com.incheol.myapp.vo.Category;

@Controller
@SessionAttributes({"userEmail", "userPassword"})
public class MainController {
	
	@Resource
	private MainService MainService; 

	@RequestMapping(value = "/main")
	public String default_main(HttpServletRequest request, Model model) {
		
		//left side category
		System.out.println("e");
		List<Category> cate_list = MainService.Load_Category(); // to get user list.
		//int i = MainService.Load_Category();
		//model.addAttribute("page_list",cate_list);
		
	    return "main";
	
	}
}