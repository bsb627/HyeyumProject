package movie.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.model.service.MovieService;
import movie.model.vo.MovieData;
import movie.model.vo.MoviePageData;
import movie.model.vo.MovieRecommend;

/**
 * Servlet implementation class MovieRecommendInfoServlet
 */
@WebServlet("/movieRecommend/list")
public class MovieRecommendListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieRecommendListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("리스트서블릿");
		int currentPage = 0;
		if(request.getParameter("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		MoviePageData mPageData = new MovieService().printAllMovieRecommend(currentPage);
		ArrayList<MovieRecommend> recommend = mPageData.getRecommendList();
		String pageNavi = mPageData.getPageNavi();
		ArrayList<MovieData>likesCount = new MovieService().printAllRecommendLikesCount(); 
		
		if(!recommend.isEmpty()) {
			request.setAttribute("recommend", recommend);
			request.setAttribute("pageNavi", pageNavi);
			request.setAttribute("likesCount", likesCount);
			request.getRequestDispatcher("/WEB-INF/views/movie/movieRecommendList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
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
