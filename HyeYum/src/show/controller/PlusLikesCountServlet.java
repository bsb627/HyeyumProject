package show.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import show.model.service.ShowService;

/**
 * Servlet implementation class AddHitsCountServlet
 */
@WebServlet("/showReview/plusLikes")
public class PlusLikesCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlusLikesCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		int showNo = Integer.parseInt(request.getParameter("no"));
		int likes = 0;
		int check = new ShowService().checkLikes(showNo,userId);
		if(check > 0) {
			 likes = new ShowService().updateLikesCount(showNo,userId,"1");
			 if(likes > 0) {
					request.setAttribute("likes", likes);
					request.setAttribute("no", showNo);
					request.getRequestDispatcher("/showReview/detail").forward(request, response);
				}else {
					
				}
				
		}else {
			 likes = new ShowService().plusLikesCount(showNo, userId);
			if(likes > 0) {
				request.setAttribute("likes", likes);
				request.setAttribute("no", showNo);
				request.getRequestDispatcher("/showReview/detail").forward(request, response);
			}else {
				
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
