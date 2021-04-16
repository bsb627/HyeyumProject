package movie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movie.model.service.MovieService;

/**
 * Servlet implementation class AddHitsCountServlet
 */
@WebServlet("/movieRecommend/plusLikes")
public class RecommendPlusLikesCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendPlusLikesCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		int recommendNo = Integer.parseInt(request.getParameter("no"));
		int likes = 0;
		int check = new MovieService().checkRecommendLikes(userId, recommendNo);
		if( check > 0) {
			
			likes = new MovieService().updateRecommendLikesCount(recommendNo, userId, "1");
				if( likes > 0) {
					request.setAttribute("likes", likes);
					request.setAttribute("no", recommendNo);
					request.getRequestDispatcher("/movieRecommend/detail").forward(request, response);
				} else {
					
				}
		
		} else {
			likes = new MovieService().RecommendPlusLikesCount(recommendNo, userId);
			if(likes > 0) {
				request.setAttribute("likes", likes);
				request.setAttribute("no", recommendNo);
				request.getRequestDispatcher("/movieRecommend/detail").forward(request, response);
			}
			
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
