package com.incheol.myapp.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.incheol.myapp.vo.Board;
import com.incheol.myapp.vo.customized_board;

@Repository
public class Boarddao extends SqlSessionDaoSupport{
	
	public List<customized_board> get_newest_boardlist1(int newest_num){
		return (List<customized_board>)getSqlSession().selectList("Board.get_newest_boardlist1",newest_num);
	}
	
	public List<Board> get_newest_boardlist(int newest_num){
		return (List<Board>)getSqlSession().selectList("Board.get_newest_boardlist",newest_num);
	}
	
	public List<Board> get_best_boardlist(int best_num){
		return (List<Board>)getSqlSession().selectList("Board.get_best_boardlist",best_num);
	}
	
	public List<Board> getboardlist(Map<String, String> map){
		return (List<Board>)getSqlSession().selectList("Board.getboardlist",map);
	}
	
	public int getboardtotal(Map<String, String> map){
		return (Integer)getSqlSession().selectOne("Board.getboardtotal",map);
	}
	
	public void addboard(Board board){
		getSqlSession().selectOne("Board.addboard",board);
	}
	
	public Board getboard(int boardid){
		return (Board)getSqlSession().selectOne("Board.getboard",boardid);
	}
	public void editboard(Board board){
		getSqlSession().selectOne("Board.editboard",board);
	}
}