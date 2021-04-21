package message.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import message.model.service.MessageService;
import message.model.vo.Message;
import message.model.vo.MsgPageData;
import qna.model.service.QnaService;
import qna.model.vo.Qna;
import qna.model.vo.QnaPageData;

/**
 * Servlet implementation class MessageSerachServlet
 */
@WebServlet("/message/search/received")
public class MsgSearchReceivedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MsgSearchReceivedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int currentPage = 0;
		if(request.getParameter("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			
		}
		HttpSession session  = request.getSession();
		String userId = (String) session.getAttribute("userId");
		String search = request.getParameter("search-keyword"); //noticelist.jsp 에 name
		String searchCategory = request.getParameter("search-category");
		MsgPageData pageData = new MessageService().printSearchList(searchCategory,search, currentPage, userId);
		ArrayList<Message> searchList = pageData.getMsgList();
		
		String pageNavi = pageData.getPageNavi();
		
		if(!searchList.isEmpty()) {
			System.out.println(searchList);
			request.setAttribute("searchList", searchList);
			request.setAttribute("pageNavi", pageNavi);
			request.getRequestDispatcher("/WEB-INF/views/message/receivedSearchListForm.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/views/message/noneReceivedSearch.jsp").forward(request, response);
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
