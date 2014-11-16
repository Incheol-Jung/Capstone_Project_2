package com.incheol.myapp.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.incheol.myapp.dao.Userdao;
import com.incheol.myapp.vo.registerinfo;

@Service
public class RegisterService {
	
	//생성되면 1 아니면 0 리턴
	public int RegisterService(registerinfo registerinfo,HttpSession sessionObj){
		System.out.println("username: " + registerinfo.getUserName());
    	System.out.println("useremail: " + registerinfo.getUserEmail());
    	System.out.println("password: " + registerinfo.getUserPassword());
    	
    	String userName = registerinfo.getUserName();
    	String userEmail = registerinfo.getUserEmail();
    	String userPassword = registerinfo.getUserPassword();
    	
    	Map<String, String> map = new HashMap<String, String>();   //임의로 맵을 만들어서
        map.put("userName", userName);
        map.put("userEmail", userEmail); //쿼리의 ${id}의 id와 같이 이름을 주고 값을 넣었다.
        map.put("userPassword", userPassword);
        
        //model.addAttribute("username", username );
    	//model.addAttribute("password", password );
        
        //임시로.
        Userdao userDao = new Userdao();
    	
        if(!userDao.registerResult(map)){
    		System.out.println("회원가입 성공!!");
    		sessionObj.setAttribute("userEmail1", userEmail);
        	sessionObj.setAttribute("password1", userPassword);
        	sessionObj.setAttribute("username", userName);
        	
        	return 0;
    	}else{
    		System.out.println("회원가입 실패!!");
    	}
    	return 1;
	}
}
