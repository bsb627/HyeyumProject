package book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.model.service.BookService;
import book.model.vo.BookReview;
import show.model.vo.ShowReview;

/**
 * Servlet implementation class ShowBoardEnrollServlet
 */
@WebServlet("/bookReview/enroll")
public class BookReviewEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookReviewEnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/book/bookReviewWrite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		BookReview review = new BookReview();
		review.setNo(Integer.parseInt(request.getParameter("info-no")));
		review.setDivision(request.getParameter("division"));
		review.setTitle(request.getParameter("review-title"));
		review.setContents(request.getParameter("review-content"));
		review.setNick((String)session.getAttribute("userId"));
		
		int result = new BookService().registerBookReview(review);
		if(result > 0) {
			request.getRequestDispatcher("/bookReview/list").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/book/bookReviewError.html");
		}
	}
}
