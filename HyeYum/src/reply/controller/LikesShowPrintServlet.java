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
@WebServlet("/likes/show/print")

public class LikesShowPrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikesShowPrintServlet() {
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
	     HttpSession session = request.getSession();
		 String userId = (String)session.getAttribute("userId");
	     int showNo = Integer.parseInt(request.getParameter("no"));
	    
	     int likes = new ShowService().getLikesCount(showNo);
			
				PrintWriter out = response.getWriter();
	            out.print(likes);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


