package com.incheol.myapp.dao;

import java.util.List;
import java.util.Map;




import org.mybatis.spring.support.SqlSessionDaoSupport;

public class Userdao extends SqlSessionDaoSupport{
	public String userEmail;
    public String userPassword;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getLoginResult(Map<String, String> map) {
        // TODO Auto-generated method stub
        return (String)getSqlSession().selectOne("userDao.getLoginResult",map); // userDao�� xml���������� ���ӽ����̽�, getLoginResult
                                                                                  // ������ ������ ID�̴�. �׸��� �Ķ���͸� map���� �־���.         
    }
	
	public int getLoginIDResult(String userEmail) {
        // TODO Auto-generated method stub
        return (Integer) getSqlSession().selectOne("userDao.getLoginIDResult",userEmail); // userDao�� xml���������� ���ӽ����̽�, getLoginResult
                                                                                  // ������ ������ ID�̴�. �׸��� �Ķ���͸� map���� �־���.         
    }
	
	public boolean registerResult(Map<String, String> map) {
        // TODO Auto-generated method stub
        return getSqlSession().selectOne("userDao.registerResult",map) != null; // userDao�� xml���������� ���ӽ����̽�, getLoginResult
                                                                                  // ������ ������ ID�̴�. �׸��� �Ķ���͸� map���� �־���.         
    }
	
	public List<Userdao> getuserlist(){
		return (List<Userdao>)getSqlSession().selectList("userDao.getuserlist");
	}
	
    
}