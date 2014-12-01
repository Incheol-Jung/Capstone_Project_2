package com.incheol.myapp.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.incheol.myapp.dao.Userdao;
import com.incheol.myapp.vo.registerinfo;

@Service
public class RegisterService {
	
	//�����Ǹ� 1 �ƴϸ� 0 ����
	public int RegisterService(registerinfo registerinfo,HttpSession sessionObj){
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
        
        //�ӽ÷�.
        Userdao userDao = new Userdao();
    	
        if(!userDao.registerResult(map)){
    		System.out.println("ȸ������ ����!!");
    		sessionObj.setAttribute("userEmail1", userEmail);
        	sessionObj.setAttribute("password1", userPassword);
        	sessionObj.setAttribute("username", userName);
        	
        	return 0;
    	}else{
    		System.out.println("ȸ������ ����!!");
    	}
    	return 1;
	}
}
