package qna.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qna.model.service.QnaService;
import qna.model.vo.Qna;

/**
 * Servlet implementation class QnAServlet
 */
@WebServlet("/question/write")
public class QuestionWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/qna/questionWriteForm.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
	
		String title = request.getParameter("title"); 
		String pass = request.getParameter("qna-pwd");
		String category = request.getParameter("category");
		String contents = request.getParameter("contents");
		//파일 어뜨케 ... 
		
		HttpSession session = request.getSession();
		
		if(session != null && (session.getAttribute("userId")) != null) {

			
			String userId = (String)session.getAttribute("userId");
			Qna qna = new Qna();
			qna.setTitle(title);
			qna.setQuestionPwd(pass);
			qna.setCategory(category);
			qna.setContents(contents);
			
			qna.setUserId(userId);
			int result = new QnaService().registerQuestion(qna);
			
			if(result > 0 ) {
				System.out.println("작성성공.. ");
				response.sendRedirect("/qna/list");
			} else {
				RequestDispatcher view2 = request.getRequestDispatcher("/WEB-INF/views/qna/qnaError.html");
				view2.forward(request, response);
			} 
		}
	}

}
