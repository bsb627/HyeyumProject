package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
