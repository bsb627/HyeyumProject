package admin.controller;

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
 * Servlet implementation class AdminQnaWriteServlet
 */
@WebServlet("/admin/qna/write")
public class AdminQnaWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQnaWriteServlet() {
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
		
		int parentNo = Integer.parseInt(request.getParameter("parent-no"));
		String contents = request.getParameter("contents");
		String pass = request.getParameter("qna-pwd");
		String category = request.getParameter("category");
		String title = request.getParameter("title");
		
		Qna qna = new Qna();
		qna.setCategory(category);
		qna.setContents(contents);
		qna.setFamily(parentNo);
		qna.setQuestionPwd(pass);
		qna.setTitle(title);
		
		int result = new QnaService().registerAnswer(qna);
		if( result > 0) {
			RequestDispatcher view = request.getRequestDispatcher("/admin/qna/list");
			view.forward(request, response);
		}
	}

}
