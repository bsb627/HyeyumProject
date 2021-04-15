package message.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/message/send")
public class MsgSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MsgSendServlet() {
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
		System.out.println("msgSend 서블릿에 message : " + message);
		int result = new MessageService().sendMessage(message);
		
		if( result > 0 ) {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('전송되었습니다.'); window.close();</script>");
		}
	}

}
