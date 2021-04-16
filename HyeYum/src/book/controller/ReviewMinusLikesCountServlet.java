package book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.model.service.BookService;

/**
 * Servlet implementation class AddHitsCountServlet
 */
@WebServlet("/bookReview/minusLikes")
public class ReviewMinusLikesCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewMinusLikesCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		int reviewNo = Integer.parseInt(request.getParameter("review-no"));
		int result = new BookService().updateLikesCountReview(reviewNo, userId,"0");
		System.out.println("userId Review minus 서블릿:" + userId);
		if(result > 0) {
			int likes = 0;
			request.setAttribute("likes", likes);
			request.setAttribute("review-no", reviewNo);
			request.getRequestDispatcher("/bookReview/detail").forward(request, response);
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
