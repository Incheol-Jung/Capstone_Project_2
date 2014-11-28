package com.incheol.myapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.incheol.myapp.HomeController;
import com.incheol.myapp.dao.Userdao;
import com.incheol.myapp.vo.*;

import com.incheol.myapp.service.MainService;

@Controller
@SessionAttributes({"userEmail", "userPassword"})
public class MainController {
    
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="MainService")
	private MainService Mainservice; 

	@RequestMapping(value = "/main")
	public String default_main(HttpServletRequest request, Model model) {
		
		//left side category
		List<Category> list = Mainservice.Load_Category(); // to get user list.
		
		
	    return "main";
	
	}
}