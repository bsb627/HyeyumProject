package book.controller;

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
import book.model.vo.BookShare;
import file.model.service.BookFileService;
import file.model.vo.FileData;
import reply.model.service.ReplyService;
import reply.model.vo.Reply;
import show.model.service.ShowService;

/**
 * Servlet implementation class BookBoardEnrollServlet
 */
@WebServlet("/bookShare/detail")
public class BookShareDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookShareDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		request.setCharacterEncoding("utf-8");
		
		int currentPage = 0;
		if (request.getParameter("currentPage") == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int shareNo = 0;
		try { // 디테일 화면에서 주는값과/ 수정완료 후 전달값이 형식이 달라서 
			shareNo = Integer.parseInt(request.getParameter("share-no"));
			
		} catch (Exception e) {
			if(shareNo == 0) {
				shareNo = (int) request.getAttribute("share-no");
			}
		}
		// 좋아요
		int likes = 0;
		if (request.getParameter("likes") !=  null) {
			likes = Integer.parseInt(request.getParameter("likes"));
		}else {
			likes = new BookService().getLikesShare(userId,shareNo);
		}
		
		BookShare bookShare = new BookShare();
		bookShare.setUserId(userId);
		FileData fileData = new BookFileService().printFileShare(shareNo);

		// 댓글
		int totalCount = new ReplyService().totalCountBookReview(shareNo);
		ArrayList<Reply> rList = new ReplyService().printReplyListBookShare(shareNo);
		System.out.println("쉐어 디테일 서블릿 rList" + rList);
		BookShare share = new BookService().printOneBookShare(shareNo);
		System.out.println("detail 서블릿 share : " + share);
		if(share != null) {
			request.setAttribute("share", share);
			request.setAttribute("likes", likes);
			request.setAttribute("fileData", fileData);
			request.setAttribute("totalCount", totalCount);
			request.setAttribute("rList", rList);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/book/bookShareDetail.jsp");
			view.forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/book/bookSharewError.html");
			view.forward(request, response);
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
