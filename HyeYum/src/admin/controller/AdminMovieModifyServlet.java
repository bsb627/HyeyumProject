package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.model.service.AdminMovieService;
import movie.model.vo.MovieInfo;

/**
 * Servlet implementation class AdminMovieModifyServlet
 */
@WebServlet("/admin/movieInfo/modify")
public class AdminMovieModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMovieModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int infoNo = Integer.parseInt(request.getParameter("infoNo"));
		MovieInfo mInfo = new AdminMovieService().printOneMovieInfo(infoNo);
		if(mInfo != null) {
			request.setAttribute("mInfo",mInfo);
			request.getRequestDispatcher("/WEB-INF/views/admin/contents/movieInfoUpdate.jsp").forward(request, response);
		} else {
			
		}
		
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
		int infoNo = Integer.parseInt(request.getParameter("infoNo"));
		String movieName = request.getParameter("movieName");
		String runTime = request.getParameter("runTime");
		String synopsis = request.getParameter("synopsis");
		
		
		MovieInfo mInfo = new MovieInfo();
		mInfo.setAgeGroup(ageGroup);
		mInfo.setCast(cast);
		mInfo.setDirector(director);
		mInfo.setGenre(genre);
		mInfo.setInfoNo(infoNo);
		mInfo.setMovieName(movieName);
		mInfo.setRunTime(runTime);
		mInfo.setSynopsis(synopsis);
		int result = new AdminMovieService().updateMovieInfo(mInfo);
		
		System.out.println("result " + result);
		
		if (result > 0) {
			
			PrintWriter out = response.getWriter();

			out.println("<script> alert('게시글이 수정되었습니다.');");
			out.println("location.href='/admin/movieInfo/list';");
			out.println("</script>");
		} else {
			
		}
		
		
	}
}