package movie.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.model.service.MovieService;
import movie.model.vo.MovieRecommend;

/**
 * Servlet implementation class MovieRecommendModifyServlet
 */
@WebServlet("/movieRecommend/modify")
public class MovieRecommendModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieRecommendModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("인포모디파이서블릿 ㅇㅇ");
		int recommendNo = Integer.parseInt(request.getParameter("no"));
		MovieRecommend recommend = new MovieService().printOneMovieRecommend(recommendNo);
		if(recommend != null) {
			request.setAttribute("recommend", recommend);
			request.getRequestDispatcher("/WEB-INF/views/movie/movieRecommendModify.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String title = request.getParameter("movie-title");
		String genre = request.getParameter("genre");
		String content = request.getParameter("content");
		int no = Integer.parseInt(request.getParameter("no"));
		
		MovieRecommend recommend = new MovieRecommend();
		recommend.setTitle(title);
		recommend.setContents(content);
		recommend.setNo(no);
		recommend.setGenre(genre);
		int result = new MovieService().modifyMovieRecommend(recommend);
			
		if (result > 0) {
			// response.sendRedirect("/movieRecommend/list");
			PrintWriter out = response.getWriter();

			out.println("<script> alert('게시글이 수정되었습니다.');");
			out.println("location.href='/movieRecommend/list';");
			out.println("</script>");
		} else {
			request.getRequestDispatcher("/WEB-INF/views/movie/movieError.html").forward(request, response);
		}
	}

}
