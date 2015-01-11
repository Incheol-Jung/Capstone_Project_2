package com.incheol.myapp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.incheol.myapp.HomeController;
import com.incheol.myapp.dao.Userdao;
import com.incheol.myapp.service.RegisterService;
import com.incheol.myapp.vo.registerinfo;


@Controller
public class RegisterController {
    
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
	//이제 여기는 UserDao가 없어지고 RegisterService만 남습니다. 그리고 RegisterService에서 UserDao를 연결하겟죠
	//일단 없애면 오류가 나서 남겨놨어요.
    @Resource(name="UserDao")                 //위의 xml에서 <bean id="userDaoImpl" class="com.fureun.mybatis.UserDaoImpl"> 와 같이 설정한                         //DB 연결하는 빈을 설정 아래와 같이 봐야한다.
    private Userdao userDao;              // 곳의 ID 이렇게 리소스를 주면 자동으로 객체가 주입이 된다.
    @Resource					                //위의 xml에서 <bean id="userDaoImpl" class="com.fureun.mybatis.UserDaoImpl"> 와 같이 설정한                         //DB 연결하는 빈을 설정 아래와 같이 봐야한다.
    private RegisterService rService;              // 곳의 ID 이렇게 리소스를 주면 자동으로 객체가 주입이 된다.
    
    
    
    
    //이런식으로 고칩니다. 예제로 이것만 만들어보았어요. 
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String main(registerinfo registerinfo,HttpSession sessionObj,Model model) {
    //public String main(@RequestParam("username") String username,
    //		@RequestParam("password") String password
    //		,Model model) {
    	
    	if(rService.RegisterService(registerinfo,sessionObj) == 1){
    		//성공했을때 하는일 ( 왠만하면 서비스에서 끝내는게 좋아요.
    	}else{
    		//실패시 하는일
    	};
    	
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
    
    @RequestMapping(value = "/ajax_temp")
    public Model ajax_temp(Model model) {
    	model.addAttribute("result","ajax_test");
    	return model;
    }
    
}