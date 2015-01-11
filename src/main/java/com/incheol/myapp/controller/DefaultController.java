package com.incheol.myapp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.incheol.myapp.dao.Userdao;
import com.incheol.myapp.service.DefaultService;

@Controller
@SessionAttributes({"userEmail", "userPassword"})
public class DefaultController {

	@Resource(name="UserDao")                 //���� xml���� <bean id="userDaoImpl" class="com.fureun.mybatis.UserDaoImpl"> �� ���� ������                         //DB �����ϴ� ���� ���� �Ʒ��� ���� �����Ѵ�.
    private Userdao userDao;              	  // ���� ID �̷��� ���ҽ��� �ָ� �ڵ����� ��ü�� ������ �ȴ�.
    
	@Resource
	private DefaultService DefaultService;

	//default page
	@RequestMapping(value = "/default")
    public String temp(Model model) {
    	model.addAttribute("result","ajax_test");
        return "login";
    }
	
	//login web site
	@RequestMapping(value = "/login"  ,method=RequestMethod.GET)
    public String login(
    		@RequestParam("userEmail") String userEmail,
    		@RequestParam("userPassword") String userPassword,
    		HttpSession session) {
				
			// if account user applied is right, current page is going to be main page with accessed account session 
			// or not, current page is going to be same page.
		return  DefaultService.login_check(userEmail,userPassword,session);
    }
}