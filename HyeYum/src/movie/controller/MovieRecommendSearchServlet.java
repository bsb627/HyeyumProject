package movie.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.model.service.MovieService;
import movie.model.vo.MoviePageData;
import movie.model.vo.MovieRecommend;

/**
 * Servlet implementation class MovieRecommendSearchServlet
 */
@WebServlet("/movieRecommend/search")
public class MovieRecommendSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieRecommendSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("서블릿들어감");
		
		int currentPage = 0;
		if(request.getParameter("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currnetPage"));
		}
		
		String search = request.getParameter("search-keyword");
		String searchCategory = request.getParameter("search-category");
		MoviePageData pageData = new MovieService().printSearchAllMovieRecommendList(currentPage, search, searchCategory);
		ArrayList<MovieRecommend> recommend = pageData.getRecommendList();
		String pageNavi = pageData.getPageNavi();
		System.out.println("recommend list :" + recommend);
		if(!recommend.isEmpty()) {
			request.setAttribute("recommend", recommend);
			request.setAttribute("pageNavi", pageNavi);
			request.getRequestDispatcher("/WEB-INF/views/movie/moiveRecommendSearch.jsp").forward(request, response);
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
