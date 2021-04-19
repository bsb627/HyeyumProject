package movie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.model.service.MovieService;
import movie.model.vo.MovieInfo;

/**
 * Servlet implementation class MovieInfoDetailServlet
 */
@WebServlet("/movieInfo/detail")
public class MovieInfoDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieInfoDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int infoNo = Integer.parseInt(request.getParameter("no"));
		
		System.out.println("infoNo :" + infoNo);
		
		MovieInfo mInfo = new MovieService().getMovieInfo(infoNo);
		if (mInfo != null) {
			request.setAttribute("mInfo", mInfo);
			request.getRequestDispatcher("/WEB-INF/views/movie/movieInfoDetail.jsp").forward(request, response);
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
