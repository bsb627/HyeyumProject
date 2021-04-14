package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna.model.service.QnaService;

/**
 * Servlet implementation class AdminQnaDeleteServlet
 */
@WebServlet("/admin/qna/delete")
public class AdminQnaDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQnaDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] checkBoxes = request.getParameterValues("checkbox");
		String qnaNo = "";
		
		for( String checkBox : checkBoxes) {
			if( checkBox.equals(checkBoxes[checkBoxes.length -1 ])) {
				qnaNo += checkBox;
			} else {
				qnaNo += checkBox + ",";
			}
		}
		
		int result = new QnaService().deleteQnaAdmin(qnaNo);
		if(result > 0) {
			response.sendRedirect("/admin/qna/list");
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
