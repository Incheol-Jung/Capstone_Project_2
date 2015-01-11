package com.incheol.myapp.dao;

import java.util.List;
import java.util.Map;





import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.incheol.myapp.vo.customized_user;

public class Userdao extends SqlSessionDaoSupport{

	public List<customized_user> get_Best_userlist(int best_num){
    	return (List<customized_user>)getSqlSession().selectList("userDao.get_Best_userlist",best_num);
    }
	
	public String getLoginResult(Map<String, String> map) {
        // TODO Auto-generated method stub
        return (String)getSqlSession().selectOne("userDao.getLoginResult",map);   // userDao�� xml���������� ���ӽ����̽�, getLoginResult
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