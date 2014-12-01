package com.incheol.myapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.incheol.myapp.HomeController;
import com.incheol.myapp.dao.Categorydao;
import com.incheol.myapp.dao.Userdao;
import com.incheol.myapp.vo.*;

@Controller
@SessionAttributes({"userEmail", "userPassword"})
public class JoinController {
    
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    @Resource(name="UserDao")                 //���� xml���� <bean id="userDaoImpl" class="com.fureun.mybatis.UserDaoImpl"> �� ���� ������                         //DB �����ϴ� ���� ���� �Ʒ��� ���� �����Ѵ�.
    private Userdao userDao;              // ���� ID �̷��� ���ҽ��� �ָ� �ڵ����� ��ü�� ������ �ȴ�.
    
    @Resource(name="Board")                 //���� xml���� <bean id="userDaoImpl" class="com.fureun.mybatis.UserDaoImpl"> �� ���� ������                         //DB �����ϴ� ���� ���� �Ʒ��� ���� �����Ѵ�.
    private Board Board;              // ���� ID �̷��� ���ҽ��� �ָ� �ڵ����� ��ü�� ������ �ȴ�.
    
    @Resource(name="Categorydao")                 //���� xml���� <bean id="userDaoImpl" class="com.fureun.mybatis.UserDaoImpl"> �� ���� ������                         //DB �����ϴ� ���� ���� �Ʒ��� ���� �����Ѵ�.
    private Categorydao Category;              // ���� ID �̷��� ���ҽ��� �ָ� �ڵ����� ��ü�� ������ �ȴ�.
    
    
    
    @RequestMapping(value = "/login"  ,method=RequestMethod.GET)
    public String main(
    		@RequestParam("userEmail") String userEmail,
    		@RequestParam("userPassword") String userPassword,
    		Model model,HttpSession sessionObj) {
        
    	System.out.println("userEmail: " + userEmail);
    	System.out.println("password: " + userPassword);
    	
    	sessionObj.setAttribute("userEmail", userEmail);
    	sessionObj.setAttribute("password1", userPassword);
    	
    	Map<String, String> map = new HashMap<String, String>();   //���Ƿ� ���� ����
        map.put("userEmail", userEmail);                                     //������ ${id}�� id�� ���� �̸��� �ְ� ���� �־���.
        map.put("userPassword", userPassword);
        
        
        
        if(userDao.getLoginIDResult(userEmail) == 1){                  //�̷��� ������ �Ѵ��� �Ķ���ͷ� map�� �Ѱܼ� ����� �޾ƿ´�.
            System.out.println("�����ϴ� ID �Դϴ�.");                      // ���̵�� �н����尡 ��ġ�ϸ� ī��Ʈ�� 1�� ���ð��̹Ƿ� 
            String username = userDao.getLoginResult(map);	
            if(username != null){
            		System.out.println("�α��� ����!!"); 

                	sessionObj.setAttribute("username", username);

            		//return "board";
            		return "redirect:/board";
            	}else{
            		System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�."); 
            		return "login"; 
            	}
        } else {
            System.out.println("�������� �ʴ� ID �Դϴ�.");
            return "login"; 
        }
    	
        
    }
    
    @RequestMapping(value = "/board" , method = RequestMethod.GET)
    public String showuserlist(HttpServletRequest request, Model model,HttpSession sessionObj) {
        
    	System.out.println("request.getParameter('s_category') === "+request.getParameter("s_category"));
    	System.out.println("request.getParameter('s_keyword') === "+request.getParameter("s_keyword"));
    	String search_keyword ="";
    	String search_category ="title";
    	
    	if( request.getParameter("s_category") != null) search_category = request.getParameter("s_category").toString();
    	if( request.getParameter("s_keyword") != null) search_keyword = request.getParameter("s_keyword").toString();
    	
    	Map<String, String> map = new HashMap<String, String>();   //���Ƿ� ���� ����
    	map.put("search_category", search_category);
    	map.put("search_keyword", search_keyword);                 //������ ${id}�� id�� ���� �̸��� �ְ� ���� �־���.
        
    	
    	
    	int itemsperpage = 5; // to show page number begin *****
        int totalitems = Board.getboardtotal(map);
        int totalpages = totalitems/itemsperpage; // calculate total item pages
        if(totalitems%itemsperpage != 0) totalpages++; // to add total item pages
        
        int currentpage = 1; // to get current page
        if( request.getParameter("pageNum") == null) currentpage = 1;
        else currentpage = Integer.parseInt(request.getParameter("pageNum"));
        	
        int page_begin = itemsperpage*(currentpage-1); // calculate begin item number of current page
        int page_end = page_begin+itemsperpage-1; // calculate end item number of current page
        
        List<page> page_list = new ArrayList<page>(); // to define page number list.
        
        for(int i=1; i<=totalpages; i++){ // to set page number list.
        	page temp = new page();
        	temp.setNumber(i);
        	page_list.add(temp);
        }
        
        model.addAttribute("page_list",page_list); // ***** to show page number end
        
        List<Board> list = Board.getboardlist(map); // to get user list.
        
        model.addAttribute("list",list); // to use this item in front page. define attribute.
        model.addAttribute("page_begin",page_begin);
        model.addAttribute("page_end",page_end);
        model.addAttribute("s_category",search_category);
        model.addAttribute("s_keyword",search_keyword);
        
        return "board";

    }
    @RequestMapping(value = "/board_edit")
    public String editboard(HttpServletRequest request, Model model) {
    	int userid = 0;
    	int boardid = 0;
    	
    	if ( request.getParameter("userid") != null ) userid = Integer.parseInt(request.getParameter("userid"));
    	else return "home";
    	
    	model.addAttribute("userid",userid);
    	
    	
    	List<Category> list = Category.getcategorylist();// to get user list.
    	model.addAttribute("list",list);
    	
    	
    	if ( request.getParameter("boardid") != null ){
    		boardid = Integer.parseInt(request.getParameter("boardid"));
    		
    		Board temp_board = new Board();
    		temp_board = Board.getboard(boardid);
    		
    		model.addAttribute("title",temp_board.getTitle());
        	model.addAttribute("content",temp_board.getContent());
        	model.addAttribute("categoryid",temp_board.getcateID());
    	}
    	
    	model.addAttribute("boardid",boardid);
    	
    	return "board_edit";
    }
    
    @RequestMapping(value = "/addboard")
    public String addboard(HttpServletRequest request, Model model) {
    	int boardid = 0;
    	int userid = 0;
    	int categoryid = 0;
    	String title ="";
    	String content ="";
    	boolean boardidcheck = true;
    	
		if ( request.getParameter("userid") != null ) userid = Integer.parseInt(request.getParameter("userid"));
		if ( request.getParameter("categoryid") != null ) categoryid = Integer.parseInt(request.getParameter("categoryid"));
		if ( request.getParameter("title") != null ) title = request.getParameter("title");
		if ( request.getParameter("content") != null ) content = request.getParameter("content");
		
    	Board temp_board = new Board();
    	
    	if ( request.getParameter("boardid") != null ){
    		boardid = Integer.parseInt(request.getParameter("boardid"));
    		temp_board = Board.getboard(boardid);
    		boardidcheck = false;
    	}
    	
    	temp_board.setcateID(categoryid);
    	temp_board.setB_userID(userid);
    	temp_board.setTitle(title);
    	temp_board.setContent(content);
    	
    	if(boardidcheck)
    		Board.addboard(temp_board);
    	else
    		Board.editboard(temp_board);
    	
    	List<Category> list = Category.getcategorylist(); // to get user list.
    	model.addAttribute("list",list);
    	
        return "redirect:board_edit?userid=1&boardid=1";

    }
    @RequestMapping(value = "/checkboard")
    public String checkboard(HttpServletRequest request, Model model) {
    	int boardid = 0;
    	Board temp_board = new Board();
    	boardid = Integer.parseInt(request.getParameter("boardid"));
    	
    	temp_board = Board.getboard(boardid);
    	temp_board.setTitle("test");
		model.addAttribute("title",temp_board.getTitle());
    	model.addAttribute("content",temp_board.getContent());
    	
    	
    	
        return "board_edit";

    }
    
    //Tiles Test
  	@RequestMapping(value = "/tilesTest")
      public String tilesTest(HttpServletRequest request, Model model) {
      	System.out.println("test");
      	
      	//tiles/{1}/{2}/{3} �������� ������ ������ ������ ������ �� �� ����.
          return "tiles/main";

      }
}