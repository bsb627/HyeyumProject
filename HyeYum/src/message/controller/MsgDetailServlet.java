package message.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import message.model.service.MessageService;
import message.model.vo.Message;

/**
 * Servlet implementation class MessageDetailServlet
 */
@WebServlet("/message/detail")
public class MsgDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MsgDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int messageNo = Integer.parseInt(request.getParameter("msgNo"));
		
		Message message = new MessageService().printOne(messageNo);
		System.out.println("메시지 디테일 서블릿 : "+ message);
		if( message!=null) {
			System.out.println("메시지 디테일 서블릿 if 안에 : "+ message);
			request.setAttribute("message", message);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/message/msgDetailForm.jsp");
			view.forward(request, response);
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
