package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.model.service.AdminMovieService;
import file.model.service.FileService;
import file.model.service.MovieFileService;
import file.model.vo.FileData;
import movie.model.service.MovieService;
import movie.model.vo.MovieRecommend;

/**
 * Servlet implementation class MovieRecommendDetailServlet
 */
@WebServlet("/admin/recommend/detail")
public class AdminMovieRecommendDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMovieRecommendDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * request.setCharacterEncoding("utf-8"); HttpSession session =
		 * request.getSession(); String userId = (String)session.getAttribute("userId");
		 */
		
		int recommendNo = Integer.parseInt(request.getParameter("rowNo"));
		
//		int recommendNo = 0;
//		try {
//			recommendNo = Integer.parseInt(request.getParameter("recommendNo")); 
//		} catch (Exception e) {
//			if(recommendNo == 0) {
//				recommendNo = (int) request.getAttribute("no");
//			}
//		}
		System.out.println("recoNo" + recommendNo);
		
		//좋아요 할 때 
//		int likes = 0;
//		if (request.getParameter("likes") != null ) {
//			likes = Integer.parseInt(request.getParameter("likes"));
//		} else {
//			likes = new MovieService().getMovieRecommendLikes(userId, recommendNo);
//		}
//		
		MovieRecommend recommend = new AdminMovieService().printOneMovieRecommend(recommendNo);
		//recommend.setUserId(userId);
		//FileData fileData = new MovieFileService().printFileRecommend(recommendNo);
		
		if(recommend != null) {
			request.setAttribute("recommend", recommend);
			
			request.getRequestDispatcher("/WEB-INF/views/admin/board/recommendDetail.jsp").forward(request, response);
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
