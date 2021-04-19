package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.DonateService;

/**
 * Servlet implementation class DonateListServlet
 */
@WebServlet("/donate/list")
public class DonateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonateListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		int bookCount = new DonateService().countBook(userId);
		int movieCount = new DonateService().countMovie(userId);
		int showCount = new DonateService().countShow(userId);
		
		
		
		request.setAttribute("bookCount", bookCount);
		request.setAttribute("movieCount", movieCount);
		request.setAttribute("showCount", showCount);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/donateList.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
