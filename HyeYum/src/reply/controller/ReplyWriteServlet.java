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
 * Servlet implementation class ShowBoardEnrollServlet
 */
@WebServlet("/reply/write")
public class ReplyWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Reply reply = new Reply();
		
		reply.setNo(Integer.parseInt(request.getParameter("review-no")));
		reply.setReplyType(request.getParameter("type"));
		reply.setContents(request.getParameter("comment"));
		reply.setUserId((String)session.getAttribute("userId"));
		int result = new ReplyService().registerReply(reply);
		if(result > 0) {
			switch (reply.getReplyType()) {
			case "book":
				
				break;
			case "share":
				
				break;
			case "movie":
				
				break;
			case "show":
				request.setAttribute("no", reply.getNo());
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
