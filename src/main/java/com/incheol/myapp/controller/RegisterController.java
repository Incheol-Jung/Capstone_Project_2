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
    
	//���� ����� UserDao�� �������� RegisterService�� �����ϴ�. �׸��� RegisterService���� UserDao�� �����ϰ���
	//�ϴ� ���ָ� ������ ���� ���ܳ����.
    @Resource(name="UserDao")                 //���� xml���� <bean id="userDaoImpl" class="com.fureun.mybatis.UserDaoImpl"> �� ���� ������                         //DB �����ϴ� ���� ���� �Ʒ��� ���� �����Ѵ�.
    private Userdao userDao;              // ���� ID �̷��� ���ҽ��� �ָ� �ڵ����� ��ü�� ������ �ȴ�.
    @Resource					                //���� xml���� <bean id="userDaoImpl" class="com.fureun.mybatis.UserDaoImpl"> �� ���� ������                         //DB �����ϴ� ���� ���� �Ʒ��� ���� �����Ѵ�.
    private RegisterService rService;              // ���� ID �̷��� ���ҽ��� �ָ� �ڵ����� ��ü�� ������ �ȴ�.
    
    
    
    
    //�̷������� ��Ĩ�ϴ�. ������ �̰͸� �����Ҿ��. 
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String main(registerinfo registerinfo,HttpSession sessionObj,Model model) {
    //public String main(@RequestParam("username") String username,
    //		@RequestParam("password") String password
    //		,Model model) {
    	
    	if(rService.RegisterService(registerinfo,sessionObj) == 1){
    		//���������� �ϴ��� ( �ظ��ϸ� ���񽺿��� �����°� ���ƿ�.
    	}else{
    		//���н� �ϴ���
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