package com.incheol.myapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.incheol.myapp.HomeController;
import com.incheol.myapp.dao.Userdao;
import com.incheol.myapp.vo.registerinfo;


@Controller
public class RegisterController {
    
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    @Resource(name="UserDao")                 //���� xml���� <bean id="userDaoImpl" class="com.fureun.mybatis.UserDaoImpl"> �� ���� ������                         //DB �����ϴ� ���� ���� �Ʒ��� ���� �����Ѵ�.
    private Userdao userDao;              // ���� ID �̷��� ���ҽ��� �ָ� �ڵ����� ��ü�� ������ �ȴ�.
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String main(registerinfo registerinfo,HttpSession sessionObj,Model model) {
    //public String main(@RequestParam("username") String username,
    //		@RequestParam("password") String password
    //		,Model model) {  
    	System.out.println("username: " + registerinfo.getUserName());
    	System.out.println("useremail: " + registerinfo.getUserEmail());
    	System.out.println("password: " + registerinfo.getUserPassword());
    	
    	String userName = registerinfo.getUserName();
    	String userEmail = registerinfo.getUserEmail();
    	String userPassword = registerinfo.getUserPassword();
    	
    	Map<String, String> map = new HashMap<String, String>();   //���Ƿ� ���� ����
        map.put("userName", userName);
        map.put("userEmail", userEmail); //������ ${id}�� id�� ���� �̸��� �ְ� ���� �־���.
        map.put("userPassword", userPassword);
        
        //model.addAttribute("username", username );
    	//model.addAttribute("password", password );
        
    	if(!userDao.registerResult(map)){
    		System.out.println("ȸ������ ����!!");
    		sessionObj.setAttribute("userEmail1", userEmail);
        	sessionObj.setAttribute("password1", userPassword);
        	sessionObj.setAttribute("username", userName);
        	
        	
        	return "redirect:/board";
    	}else{
    		System.out.println("ȸ������ ����!!");
    	}
    	
        return "login";
    }
    
    @RequestMapping(value="/userlist")
    public String getuserlist(HttpServletRequest request,HttpSession sessionObj, Model model) {
    	
    	List<Userdao> templist = userDao.getuserlist();
		model.addAttribute("list",templist);
    	
		int itemsperpage = 3;
		int totalitems = 10;
		int totalpage = totalitems/itemsperpage;
		if( totalitems%itemsperpage != 0 ) totalpage++;
		int currentpage = 1;
		
		if(request.getAttribute("page_num") != null){ currentpage = Integer.parseInt( request.getAttribute("page_num").toString()); }
		//else currentpage = Integer.parseInt( request.getAttribute("page_num").toString() );
		
		int page_begin = itemsperpage *( currentpage - 1 );
		int page_end = page_begin + (itemsperpage - 1 );
		
		model.addAttribute("page_begin",page_begin);
		model.addAttribute("page_end",page_end);
		request.setAttribute("totalpage", totalpage);
		
        return "userlist";
    }
    
    @RequestMapping(value = "/temp")
    public String temp(Model model) {
    	model.addAttribute("result","ajax_test");
        return "login";
    }
    
    @RequestMapping(value = "/ajax_temp")
    public Model ajax_temp(Model model) {
    	model.addAttribute("result","ajax_test");
    	return model;
    }
    
}