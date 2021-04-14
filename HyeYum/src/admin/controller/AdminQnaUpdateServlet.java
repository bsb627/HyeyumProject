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
 * Servlet implementation class AdminQnaUpdateServlet
 */
@WebServlet("/admin/qna/modify")
public class AdminQnaUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQnaUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		int family = Integer.parseInt(request.getParameter("family"));
		Qna qna = new QnaService().printOneAdmin(qnaNo);
		Qna parent = new QnaService().printParentAdmin(family);
		request.setAttribute("qna", qna);
		request.setAttribute("parentQna", parent);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/qna/qnaModifyAdmin.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		String contents = request.getParameter("contents");
		Qna qna = new Qna();
		qna.setQnaNo(qnaNo);
		qna.setContents(contents);
		int result = new QnaService().modifyQnaAdmin(qna);
		if (result > 0 ) {
			RequestDispatcher view = request.getRequestDispatcher("/admin/qna/list");
			view.forward(request, response);
		}
	}

}
