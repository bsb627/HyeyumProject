package movie.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movie.model.service.MovieService;
import movie.model.vo.MovieRecommend;

/**
 * Servlet implementation class MovieRecommendEnrollServlet
 */
@WebServlet("/movieRecommend/write")
public class MovieRecommendWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieRecommendWriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/movie/movieRecommendWrite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String title = request.getParameter("movie-title");
		String content = request.getParameter("content");
		String genre = request.getParameter("genre");

		HttpSession session = request.getSession();
		if (session != null && (session.getAttribute("userId")) != null) {
			String userId = (String) session.getAttribute("userId");
			MovieRecommend recommend = new MovieRecommend();
			recommend.setTitle(title);
			recommend.setContents(content);
			recommend.setGenre(genre);
			recommend.setNick(userId);
			int result = new MovieService().registerMovieRecommend(recommend);
			if (result > 0) {
				PrintWriter out = response.getWriter();

				out.println("<script> alert('게시글이 등록되었습니다.');");
				out.println("location.href='/movieRecommend/list';");
				out.println("</script>");
			} else {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/WEB-INF/views/movie/movieError.html").forward(request, response);
		}
	}

}
