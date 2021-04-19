package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminMovieService;
import movie.model.vo.MovieReview;

/**
 * Servlet implementation class AdminMovieReviewDetailServlet
 */
@WebServlet("/admin/movie/detail")
public class AdminMovieReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMovieReviewDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reNo = Integer.parseInt(request.getParameter("reNo"));

		MovieReview review = new AdminMovieService().printOneMovieReview(reNo);

		if (review != null) {
			request.setAttribute("review", review);

			request.getRequestDispatcher("/WEB-INF/views/admin/board/reviewDetail.jsp").forward(request, response);
		} else {
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
