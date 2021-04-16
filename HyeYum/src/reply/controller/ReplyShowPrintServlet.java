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

/**
 * Servlet implementation class ReplyServlet
 */
@WebServlet("/reply/show/print")

public class ReplyShowPrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyShowPrintServlet() {
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
	     String result = "";
	     int showNo = Integer.parseInt(request.getParameter("no"));
	     ArrayList<Reply> rList = new ReplyService().printReplyList(showNo);
	     int totalCount = new ReplyService().totalCount(showNo);
			if(!rList.isEmpty()) {
				for(int i=0; i<rList.size(); i++) {
						result += "{\"no\":\"" + i+"";
						result += "\",\"totalCount\":\"" + totalCount;
				        result += "\",\"nick\":\"" + rList.get(i).getNick();
				        result += "\",\"contents\":\"" + rList.get(i).getContents();
				        result += "\",\"enrollDate\":\"" + rList.get(i).getEnrollDate() + "\"},";
				        
				}
				 result = result.substring(0,result.length()-1);
				    result = "[" + result + "]";
				PrintWriter out = response.getWriter();
	            out.print(result);
			}else {
				PrintWriter out = response.getWriter();
	            out.print("null");
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


