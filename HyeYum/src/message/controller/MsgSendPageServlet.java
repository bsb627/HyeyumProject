package message.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import message.model.dao.MessageDAO;
import message.model.service.MessageService;
import message.model.vo.Message;

/**
 * Servlet implementation class MsgSendServlet
 */
@WebServlet("/message/send/page")
public class MsgSendPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MsgSendPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		
		
		HttpSession session = request.getSession();
		String sendId = (String) session.getAttribute("userId");
		String receiveId = request.getParameter("receiveId");
		String contents = request.getParameter("contents");
		Message message = new Message();
		
		message.setSender(sendId);
		message.setReceiver(receiveId);
		message.setContents(contents);
		message.setReadState("읽지않음");
		
		//보낸메시지 테이블
		int result = new MessageService().sendMessage(message);
		//받은메시지 테이블
		int result2 = new MessageService().sendMessage2(message);
		
		
		if( result > 0 && result2 >0) {
//			PrintWriter out = response.getWriter();
//			out.println("<script>alert('전송되었습니다.')</script>");

			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/message/successSend.jsp");
			view.forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('존재하지 않은 아이디 입니다 다시 확인해주세요.'); history.back();</script>");
		
		}
	}

}
