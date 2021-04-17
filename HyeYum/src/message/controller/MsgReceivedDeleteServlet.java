package message.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import message.model.service.MessageService;
import qna.model.service.QnaService;

/**
 * Servlet implementation class MsgDeleteServlet
 */
@WebServlet("/message/delete/received")
public class MsgReceivedDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MsgReceivedDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] checkBoxes = request.getParameterValues("checkbox");
		String msgNo = "";
		String table = request.getParameter("table");
		for( String checkBox : checkBoxes) {
			if( checkBox.equals(checkBoxes[checkBoxes.length -1 ])) {
				msgNo += checkBox;
			} else {
				msgNo += checkBox + ",";
			}
		}
		
		int result = new MessageService().deleteMessages(msgNo, table);
		if(result > 0) {
			response.sendRedirect("/message/receivedList");
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
