package com.incheol.myapp.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.incheol.myapp.dao.Userdao;

@Service
public class DefaultService {
	
	@Resource(name="UserDao")  
	private Userdao userdao;
	
	public String login_check(String userEmail,String userPassword,HttpSession session){
		
		// login check �Լ��� login page���� �Է¹��� ID , PW �� �ѹ��� �־��ֱ� ���� map�� ���.
    	Map<String, String> map = new HashMap<String, String>();       
		map.put("userEmail", userEmail);                               
        map.put("userPassword", userPassword);
        
        if(userdao.getLoginIDResult(userEmail) == 1){      // ID üũ�� password üũ�� ������ �����ϱ� ���� �Լ��� �� �ܰ�� ��������.
        	System.out.println("�����ϴ� ID �Դϴ�.");
        	String username = userdao.getLoginResult(map); // ��ܿ� username�� �־��ֱ� ���� login result �� true�� ���, username �� �ҷ���.
        	                                               // false �� ���, return ���� null�� ������ ��.
            if(username != null){
        		System.out.println("�α��� ����!!");

        		session.setAttribute("userEmail", userEmail);
        		session.setAttribute("userPassword", userPassword);
        		session.setAttribute("userName", username); 
        		return "redirect:/main"; //return main page;
        	}else{
        		System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�."); 
        		return "login"; 
        	}
        } else {
            System.out.println("�������� �ʴ� ID �Դϴ�.");
            return "login"; 
        }
	}
	
}
