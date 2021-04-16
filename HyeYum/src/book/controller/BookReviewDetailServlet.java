package book.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.model.service.BookService;
import book.model.vo.BookReview;

/**
 * Servlet implementation class BookBoardEnrollServlet
 */
@WebServlet("/bookReview/detail")
public class BookReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookReviewDetailServlet() {
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
		
		int reviewNo = 0;
		try {
			reviewNo = Integer.parseInt(request.getParameter("review-no"));
			
		} catch (Exception e) {
			if(reviewNo == 0) {
				reviewNo = (int) request.getAttribute("review-no");
			}
		}
		
		// 좋아요
		int likes = 0;
		if (request.getParameter("likes") !=  null) {
			likes = Integer.parseInt(request.getParameter("likes"));
		}else {
			likes = new BookService().getLikesReview(userId,reviewNo);
		}
		BookReview review = new BookService().printOneBookReview(reviewNo);
		if(review != null) {
			request.setAttribute("review", review);
			request.setAttribute("likes", likes);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/book/bookReviewDetail.jsp");
			view.forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/book/bookReviewError.html");
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
