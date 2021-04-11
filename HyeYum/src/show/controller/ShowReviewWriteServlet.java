package show.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import show.model.service.ShowService;
import show.model.vo.ShowReview;

/**
 * Servlet implementation class ShowBoardEnrollServlet
 */
@WebServlet("/showReview/write")
public class ShowReviewWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowReviewWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/show/showReviewWrite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		ShowReview review = new ShowReview();
		review.setInfoNo(Integer.parseInt(request.getParameter("info-no")));
		review.setTitle(request.getParameter("show-title"));
		review.setContents(request.getParameter("show-content"));
		review.setSnsLink(request.getParameter("sns-link"));
		review.setTicketNumber(request.getParameter("ticket-number"));
		review.setNick((String)session.getAttribute("userId"));
		
		int result = new ShowService().registerShowReview(review);
		
		if(result > 0) {
			request.getRequestDispatcher("/WEB-INF/views/show/showReviewList.jsp").forward(request, response);
		}else {
			
		}
		
	}

}
