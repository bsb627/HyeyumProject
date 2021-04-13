package qna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna.model.service.QnaService;
import qna.model.vo.Qna;

/**
 * Servlet implementation class QuestioniModifyServlet
 */
@WebServlet("/qna/modify")
public class QnaUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qnaNo = Integer.parseInt(request.getParameter("qna-no"));
		String qnaPass = request.getParameter("qna-pwd");
		
		Qna qna = new QnaService().printOne(qnaNo, qnaPass);
		request.setAttribute("qna", qna);
		if( qna != null) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/qna/questionModifyForm.jsp");
			view.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		
		
		System.out.println("업데이트 서블릿드렁오");
		int qnaNo = Integer.parseInt(request.getParameter("qna-no"));
		String title = request.getParameter("title");
		String qnaPass = request.getParameter("qna-pwd");
		String category = request.getParameter("category");
		String contents = request.getParameter("contents");
		
		Qna qna = new Qna();
		qna.setQnaNo(qnaNo);
		qna.setTitle(title);
		qna.setCategory(category);
		qna.setContents(contents);
		qna.setQuestionPwd(qnaPass);
		int result = new QnaService().modifyQna(qna);
		System.out.println("여기는 업데이트 서블랫  result : " + result);
		
		if(result > 0 ) {
			RequestDispatcher view = request.getRequestDispatcher("/qna/list");
			view.forward(request, response);
			
		}
	}

}
