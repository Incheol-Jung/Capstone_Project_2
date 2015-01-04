package com.incheol.myapp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.incheol.myapp.service.MainService;
import com.incheol.myapp.vo.Board;
import com.incheol.myapp.vo.Category;
import com.incheol.myapp.vo.customized_user;

@Controller
@SessionAttributes({"userEmail", "userPassword"})
public class MainController {
	
	@Resource
	private MainService MainService; 

	@RequestMapping(value = "/main")
	public String default_main(HttpServletRequest request, Model model) {
		
		//to get user list on left side category
		List<Category> cate_list = MainService.Load_Category();
		model.addAttribute("cate_list",cate_list);
		
		//to get newest category
		List<Board> newest_blist = MainService.Load_newest_board_list(5); //you can choice how many show newest board. now i just fixed 5
		model.addAttribute("newest_blist",newest_blist);
		
		//to get best category sort by count
		List<Board> best_blist = MainService.Load_newest_board_list(5); //you can choice how many show best board. now i just fixed 5
		model.addAttribute("best_blist",best_blist);
		
		List<customized_user> best_ulist = MainService.Load_best_user_list(5);
		model.addAttribute("best_ulist",best_ulist);
	    return "main";
	
	}
}