package member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.model.service.BookService;
import book.model.vo.BookPageData;
import book.model.vo.BookReview;
import book.model.vo.BookShare;
import member.model.service.MyPostService;
import member.model.vo.MyPost;
import member.model.vo.MyPostPageData;
import movie.model.service.MovieService;
import movie.model.vo.MoviePageData;
import movie.model.vo.MovieRecommend;
import movie.model.vo.MovieReview;
import reply.model.service.ReplyService;
import reply.model.vo.Reply;
import reply.model.vo.ReplyPageData;
import show.model.service.ShowService;
import show.model.vo.ShowPageData;
import show.model.vo.ShowReview;

/**
 * Servlet implementation class MessagePrintServlet
 */
@WebServlet("/myReply")
public class MyReplyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyReplyListServlet() {
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
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		ReplyPageData pd = new ReplyService().printAllReplyList(currentPage,userId);
		ArrayList<Reply> rList = pd.getReplyList(); 
		String pageNavi = pd.getPageNavi();
		if(!rList.isEmpty()) {
			request.setAttribute("rList", rList);
			request.setAttribute("pageNavi", pageNavi);
				request.getRequestDispatcher("/WEB-INF/views/member/myReplyList.jsp").forward(request, response);
		}else {
				request.getRequestDispatcher("/WEB-INF/views/member/myReplyEmptyList.jsp").forward(request, response);
			
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
