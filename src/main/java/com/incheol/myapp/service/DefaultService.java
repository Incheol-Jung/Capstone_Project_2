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
		
		// login check 함수에 login page에서 입력받은 ID , PW 를 한번에 넣어주기 위해 map을 사용.
    	Map<String, String> map = new HashMap<String, String>();       
		map.put("userEmail", userEmail);                               
        map.put("userPassword", userPassword);
        
        if(userdao.getLoginIDResult(userEmail) == 1){      // ID 체크와 password 체크를 별도로 구분하기 위해 함수를 두 단계로 나누었음.
        	System.out.println("존재하는 ID 입니다.");
        	String username = userdao.getLoginResult(map); // 상단에 username을 넣어주기 위해 login result 가 true일 경우, username 을 불러옴.
        	                                               // false 일 경우, return 값은 null을 가지게 됨.
            if(username != null){
        		System.out.println("로그인 성공!!");

        		session.setAttribute("userEmail", userEmail);
        		session.setAttribute("userPassword", userPassword);
        		session.setAttribute("userName", username); 
        		return "redirect:/main"; //return main page;
        	}else{
        		System.out.println("비밀번호가 일치하지 않습니다."); 
        		return "login"; 
        	}
        } else {
            System.out.println("존재하지 않는 ID 입니다.");
            return "login"; 
        }
	}
	
}
