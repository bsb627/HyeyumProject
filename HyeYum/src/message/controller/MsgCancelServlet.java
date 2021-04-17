package message.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import message.model.service.MessageService;
import qna.model.service.QnaService;

/**
 * Servlet implementation class MessageDeleteServlet
 */
@WebServlet("/message/cancel")
public class MsgCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MsgCancelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		int messageNo = Integer.parseInt(request.getParameter("msgNo"));
		
		int result = new MessageService().cancelMessage(messageNo);
		int result2 = new MessageService().cancelMessage2(messageNo);
 		if( result > 0 && result2 > 0) {
 			PrintWriter out = response.getWriter();
 			out.println("<script>alert('전송 취소 되었습니다.')</script>");
 			RequestDispatcher view = request.getRequestDispatcher("/message/sentList");
			view.forward(request, response);
		}
		
//		String [] checkBoxes = request.getParameterValues("checkbox");
//		String msgNo = "";
//		
//		for( String checkBox : checkBoxes) {
//			if( checkBox.equals(checkBoxes[checkBoxes.length -1 ])) {
//				msgNo += checkBox;
//			} else {
//				msgNo += checkBox + ",";
//			}
//		}
		
//		int result = new MessageService().deleteMessages(msgNo);
//		if(result > 0) {
//			response.sendRedirect("/message/sentList");
//		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
