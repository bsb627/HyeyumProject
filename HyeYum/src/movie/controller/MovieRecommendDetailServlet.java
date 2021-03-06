package movie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import file.model.service.FileService;
import file.model.service.MovieFileService;
import file.model.vo.FileData;
import movie.model.service.MovieService;
import movie.model.vo.MovieRecommend;

/**
 * Servlet implementation class MovieRecommendDetailServlet
 */
@WebServlet("/movieRecommend/detail")
public class MovieRecommendDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieRecommendDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		int recommendNo = 0;
		try {
			recommendNo = Integer.parseInt(request.getParameter("recommendNo")); 
		} catch (Exception e) {
			if(recommendNo == 0) {
				recommendNo = (int) request.getAttribute("no");
			}
		}
		System.out.println("recoNo" + recommendNo);
		
		//좋아요 할 때 
		int likes = 0;
		if (request.getParameter("likes") != null ) {
			likes = Integer.parseInt(request.getParameter("likes"));
		} else {
			likes = new MovieService().getMovieRecommendLikes(userId, recommendNo);
		}
		
		MovieRecommend recommend = new MovieService().printOneMovieRecommend(recommendNo);
		//recommend.setUserId(userId);
		//FileData fileData = new MovieFileService().printFileRecommend(recommendNo);
		
		
		if(recommend != null) {
		new MovieService().RecommendHitsCount(recommendNo); // 게시글 조회수
			request.setAttribute("recommend", recommend);
			request.setAttribute("likes", likes);
			//request.setAttribute("fileData", fileData);
			
			request.getRequestDispatcher("/WEB-INF/views/movie/movieRecommendDetail.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
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
