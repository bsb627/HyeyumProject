package show.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reply.model.service.ReplyService;
import reply.model.vo.Reply;
import reply.model.vo.ReplyPageData;
import show.model.service.ShowService;
import show.model.vo.ShowReview;

/**
 * Servlet implementation class ShowBoardDeleteServlet
 */
@WebServlet("/showReview/detail")
public class ShowReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowReviewDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		int showNo = 0;
		try {
			showNo = Integer.parseInt(request.getParameter("no"));
			
		} catch (Exception e) {
			
			if(showNo == 0) {
				showNo = (int) request.getAttribute("no");
			}
		}
		String replyType = "show";
		int currentPage = 0;
		if (request.getParameter("currentPage") == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int likes = 0;
		if (request.getParameter("likes") !=  null) {
			likes = Integer.parseInt(request.getParameter("likes"));
		}else {
			likes = new ShowService().getLikes(userId,showNo);
		}
		ShowReview review = new ShowService().printOneShowReview(showNo);
		ReplyPageData pageData = new ReplyService().printAllReply(currentPage, replyType,showNo);
		ArrayList<Reply> replyList = pageData.getReplyList();
		String pageNavi = pageData.getPageNavi();
		int totalCount = new ReplyService().totalCount(showNo);
		if(review != null) {
			request.setAttribute("review", review);
			request.setAttribute("replyList", replyList);
			request.setAttribute("pageNavi", pageNavi);
			request.setAttribute("totalCount", totalCount);
			request.setAttribute("likes", likes);
			request.getRequestDispatcher("/WEB-INF/views/show/showReviewDetail.jsp").forward(request, response);
			
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
