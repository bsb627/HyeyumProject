package reply.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reply.model.service.ReplyService;
import reply.model.vo.Reply;
import show.model.service.ShowService;

/**
 * Servlet implementation class ReplyServlet
 */
@WebServlet("/likes/show/update")

public class LikesShowUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikesShowUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("UTF-8");
	     response.setContentType("text/html; charset=utf-8");
	     PrintWriter out = response.getWriter();
	     HttpSession session = request.getSession();
		 String userId = (String)session.getAttribute("userId");
	     int showNo = Integer.parseInt(request.getParameter("no"));
	    
	     int check = new ShowService().checkLikes(showNo, userId);
	     if(check > 0) {
	    	 int isCheck = new ShowService().getLikes(userId, showNo);
	    	 if(isCheck > 0) {
	    		 int result = new ShowService().updateLikesCount(showNo, userId,"0");
	    		 System.out.println("좋아요있음상태 좋아요 취소 누른상태");
	    		 out = response.getWriter();
	    		 out.print(isCheck);
	    		 
	    	 }else {
	    		 int result = new ShowService().updateLikesCount(showNo, userId,"1");
	    		 System.out.println("좋아요취소상태 다시 좋아요 누른상태");
	    		 out = response.getWriter();
	    		 out.print(isCheck);
	    	 }
	    	 
	    	 
	     }else {
	    	 int result = new ShowService().plusLikesCount(showNo, userId);
        	 out = response.getWriter();
	    	 out.print(check);
	    	 
	     }
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


