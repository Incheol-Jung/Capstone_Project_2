package com.incheol.myapp.vo;

import java.util.List;
import java.util.Map;





import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.incheol.myapp.dao.Userdao;

public class Board extends SqlSessionDaoSupport{
	private int boardID;
	private int cateID;
	private int b_userID;
	private String title;
	private String content;
	private int count;
	private int r_count;
	
	public int getBoardID() {
		return boardID;
	}
	public void setBoardID(int boardID) {
		this.boardID = boardID;
	}
	public int getcateID() {
		return cateID;
	}
	public void setcateID(int cateID) {
		this.cateID = cateID;
	}
	public int getB_userID() {
		return b_userID;
	}
	public void setB_userID(int b_userID) {
		this.b_userID = b_userID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getR_count() {
		return r_count;
	}
	public void setR_count(int r_count) {
		this.r_count = r_count;
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