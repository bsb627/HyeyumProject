package movie.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movie.model.service.MovieService;
import movie.model.vo.MovieInfo;

/**
 * Servlet implementation class MovieInfoListServlet
 */
@WebServlet("/movieInfo/list")
public class MovieInfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieInfoListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("인포리스트서블릿 ㅇㅇ");
		// ArrayList<MovieInfo> mList = new MovieService().printAllMovieInfo();
		ArrayList<MovieInfo> mList = new MovieService().getMovieInfoList();
		/*
		 * HttpSession session = request.getSession(); 
		 * String userId = (String)session.getAttribute("userId");
		 */
		if(!mList.isEmpty()) {
			request.setAttribute("mList", mList);
			System.out.println("mList :" + mList);
			request.getRequestDispatcher("/WEB-INF/views/movie/movieInfoList.jsp").forward(request, response);
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
