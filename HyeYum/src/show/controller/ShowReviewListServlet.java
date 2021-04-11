package show.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qna.model.service.QnaService;
import qna.model.vo.Qna;
import qna.model.vo.QnaPageData;
import show.model.service.ShowService;
import show.model.vo.ShowData;
import show.model.vo.ShowPageData;
import show.model.vo.ShowReview;

/**
 * Servlet implementation class ShowBoardDeleteServlet
 */
@WebServlet("/showReview/list")
public class ShowReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 0;
		if (request.getParameter("currentPage") == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		ShowPageData pageData = new ShowService().printAllShowReview(currentPage);
		ArrayList<ShowReview> showList = pageData.getReviewList();
		String pageNavi = pageData.getPageNavi();
		ArrayList<ShowData> replyCount = new ShowService().printReplyCount();
		if(!showList.isEmpty()) {
			request.setAttribute("showList", showList);
			request.setAttribute("pageNavi", pageNavi);
			request.setAttribute("replyCount", replyCount);
			request.getRequestDispatcher("/WEB-INF/views/show/showReviewList.jsp").forward(request, response);
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
