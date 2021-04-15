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
 * Servlet implementation class MovieRecommendDeleteServlet
 */
@WebServlet("/movieRecommend/delete")
public class MovieRecommendDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieRecommendDeleteServlet() {
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
		
		int recommendNo = Integer.parseInt(request.getParameter("no"));
		int result = new MovieService().deleteMovieRecommend(recommendNo);
		
		if (result > 0) {
			PrintWriter out = response.getWriter();
			
			out.println("<script> alert('게시글이 삭제되었습니다.');");
			out.println("location.href='/movieRecommend/list';");
			out.println("</script>");
			//request.getRequestDispatcher("/movieRecommend/list").forward(request, response);
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
