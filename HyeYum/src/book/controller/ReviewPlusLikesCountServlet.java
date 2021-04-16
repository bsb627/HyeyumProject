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
@WebServlet("/bookReview/plusLikes")
public class ReviewPlusLikesCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewPlusLikesCountServlet() {
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
		int likes = 0;
		int check = new BookService().checkLikesReview(reviewNo,userId);
		System.out.println("review-no review 서블릿:" + reviewNo);
		System.out.println("userId Review plus 서블릿:" + userId);
		System.out.println("check review plus 서블릿 : " + check);
		if(check > 0) {
			 likes = new BookService().updateLikesCountReview(reviewNo,userId,"1");
			 if(likes > 0) {
					request.setAttribute("likes", likes);
					request.setAttribute("review-no", reviewNo);
					request.getRequestDispatcher("/bookReview/detail").forward(request, response);
				}else {
					
				}
			
		}else {
			 likes = new BookService().plusLikesReview(userId, reviewNo);
			if(likes > 0) {
				request.setAttribute("likes", likes);
				System.out.println("likes in reviewplus 서블릿 : " + likes);
				request.setAttribute("review-no", reviewNo);
				request.getRequestDispatcher("/bookReview/detail").forward(request, response);
			}else {
				
			}
			
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
