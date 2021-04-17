package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.model.service.AdminMovieService;
import movie.model.vo.MovieInfo;

/**
 * Servlet implementation class AdminMovieWriteServlet
 */
@WebServlet("/admin/movieInfo/write")
public class AdminMovieWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMovieWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			request.getRequestDispatcher("/WEB-INF/views/admin/contents/movieInfoWrite.jsp").forward(request, response);
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String ageGroup = request.getParameter("ageGroup");
		String cast = request.getParameter("cast");
		String director = request.getParameter("director");
		String genre = request.getParameter("genre");
		String movieName = request.getParameter("movieName");
		String runTime = request.getParameter("runTime");
		String synopsis = request.getParameter("synopsis");
		
	/*	HttpSession session = request.getSession();
		if(session != null && (session.getAttribute("userId")) != null) {
			String userId = (String)session.getAttribute("userId");*/
			MovieInfo mInfo = new MovieInfo();
			
			mInfo.setAgeGroup(ageGroup);
			mInfo.setCast(cast);
			mInfo.setDirector(director);
			mInfo.setGenre(genre);
			mInfo.setMovieName(movieName);
			mInfo.setRunTime(runTime);
			mInfo.setSynopsis(synopsis);
			int result = new AdminMovieService().registerMovieInfo(mInfo);
			
			System.out.println("등록result" + result);
			if(result > 0) {
				PrintWriter out = response.getWriter();

				out.println("<script> alert('게시글이 등록되었습니다.');");
				out.println("location.href='/admin/movieInfo/list';");
				out.println("</script>");
			} else {
				System.out.println("등록실패");
			}
			
		}
		
	
	}
