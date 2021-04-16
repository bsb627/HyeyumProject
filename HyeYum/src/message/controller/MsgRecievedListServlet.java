package message.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import message.model.service.MessageService;
import message.model.vo.Message;
import message.model.vo.MsgPageData;

/**
 * Servlet implementation class MessagePrintServlet
 */
@WebServlet("/message/receivedList")
public class MsgRecievedListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MsgRecievedListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		request.setAttribute("userId", userId);
		
		int currentPage = 0;
		if (request.getParameter("currentPage") == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		MsgPageData pageData = new MessageService().printAllRecievedList(currentPage,userId);
		ArrayList<Message> receivedList = pageData.getMsgList();
		String pageNavi = pageData.getPageNavi();
		if(!receivedList.isEmpty()) {
			
			request.setAttribute("receivedList", receivedList);
			request.setAttribute("pageNavi", pageNavi);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/message/receivedMsgListForm.jsp");
			view.forward(request, response);
		}else {
			
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
