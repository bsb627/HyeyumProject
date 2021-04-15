package movie.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.model.service.MovieService;

/**
 * Servlet implementation class MovieReviewDeleteServlet
 */
@WebServlet("/movieReview/delete")
public class MovieReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieReviewDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int reNo = Integer.parseInt(request.getParameter("no"));
		int result = new MovieService().deleteMovieReview(reNo);
		System.out.println("삭제진행중" + result);
		if(result > 0) {
			PrintWriter out = response.getWriter();

			out.println("<script> alert('게시글이 삭제되었습니다.');");
			out.println("location.href='/movieReview/list';");
			out.println("</script>");
		} else {
			request.getRequestDispatcher("/WEB-INF/views/movie/movieError.html").forward(request, response);
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
