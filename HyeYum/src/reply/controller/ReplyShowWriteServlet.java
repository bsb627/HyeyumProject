package reply.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class ReplyServlet
 */
@WebServlet("/reply/show/write")

public class ReplyShowWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyShowWriteServlet() {
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
			Reply reply = new Reply();
			System.out.println(request.getParameter("comment"));
			System.out.println(request.getParameter("type"));
			System.out.println(request.getParameter("no"));
			reply.setNo(Integer.parseInt(request.getParameter("no")));
			reply.setReplyType(request.getParameter("type"));
			reply.setContents(request.getParameter("comment"));
			reply.setUserId((String)session.getAttribute("userId"));
			int result = new ReplyService().registerReply(reply);
			if(result > 0) {
				PrintWriter out = response.getWriter();
	            out.print("1");
			}else {
				PrintWriter out = response.getWriter();
	            out.print("0");
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


