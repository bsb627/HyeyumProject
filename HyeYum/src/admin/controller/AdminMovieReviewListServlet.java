package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminMovieService;
import movie.model.vo.MovieRecommend;
import movie.model.vo.MovieReview;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin/movie/list")
public class AdminMovieReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMovieReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MovieReview> mList = new AdminMovieService().printAllMovieReviewList();
		System.out.println("리뷰리스트 : " + mList);
		if(!mList.isEmpty()) {
			request.setAttribute("mList", mList);
			request.getRequestDispatcher("/WEB-INF/views/admin/board/reviewList.jsp").forward(request, response);
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
