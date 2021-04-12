package show.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.ParseConversionEvent;

import show.model.service.ShowService;
import show.model.vo.ShowReview;

/**
 * Servlet implementation class ShowBoardDeleteServlet
 */
@WebServlet("/showReview/update")
public class ShowReviewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowReviewUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int showNo = Integer.parseInt(request.getParameter("no"));
		
		ShowReview review = new ShowService().printOneShowReview(showNo);
		
		if(review != null) {
			request.setAttribute("review", review);
			request.getRequestDispatcher("/WEB-INF/views/show/showReviewUpdate.jsp").forward(request, response);
		}else {
			
		}
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
				
				HttpSession session = request.getSession();
				
				ShowReview review = new ShowReview();
				review.setNo(Integer.parseInt(request.getParameter("no")));
				review.setInfoNo(Integer.parseInt(request.getParameter("info-no")));
				review.setTitle(request.getParameter("show-title"));
				review.setContents(request.getParameter("show-content"));
				review.setSnsLink(request.getParameter("sns-link"));
				review.setTicketNumber(request.getParameter("ticket-number"));
				review.setNick((String)session.getAttribute("userId"));
				
				
				int result = new ShowService().modifyShowReview(review);
				if(result > 0) {
					request.setAttribute("no", review.getInfoNo());
					request.getRequestDispatcher("/showReview/detail").forward(request, response);
				}else {
					
				}
				
			
			}

}
