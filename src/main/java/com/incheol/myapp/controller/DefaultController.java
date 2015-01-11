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

	@Resource(name="UserDao")                 //위의 xml에서 <bean id="userDaoImpl" class="com.fureun.mybatis.UserDaoImpl"> 와 같이 설정한                         //DB 연결하는 빈을 설정 아래와 같이 봐야한다.
    private Userdao userDao;              	  // 곳의 ID 이렇게 리소스를 주면 자동으로 객체가 주입이 된다.
    
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