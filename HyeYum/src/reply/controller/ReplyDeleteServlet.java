package reply.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reply.model.service.ReplyService;
import reply.model.vo.Reply;


/**
 * Servlet implementation class ShowBoardDeleteServlet
 */
@WebServlet("/reply/delete")
public class ReplyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		String type = request.getParameter("type");
		int result = new ReplyService().deleteReply(replyNo);
		if(result > 0) {
			switch (type) {
			case "book":
				
				break;
			case "share":
				
				break;
			case "movie":
				
				break;
			case "show":
				request.setAttribute("no", reviewNo);
				request.getRequestDispatcher("/showReview/detail").forward(request, response);
				break;

			default:
				break;
			}
		}else {
			
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
