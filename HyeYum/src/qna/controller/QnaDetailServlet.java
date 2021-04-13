package qna.controller;

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
 * Servlet implementation class QnADeleteServlet
 */
@WebServlet("/qna/detail")
public class QnaDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		request.setAttribute("qnaNo", qnaNo); //얘를 담아서 저 페이지 보내줌
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/qna/qnaPassForm.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		
		
		
		int qnaNo = Integer.parseInt(request.getParameter("qna-no")); 
		String qnaPass  = request.getParameter("qna-pass");
		Qna qna = new QnaService().printOne(qnaNo, qnaPass);
		
		
		HttpSession session  = request.getSession();
		String userId = (String) session.getAttribute("userId");
	
		if(userId.equals(qna.getUserId()) && qna!=null) {
			new QnaService().addHitsCount(qnaNo);
			request.setAttribute("qna", qna);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/qna/qnaDetailForm.jsp");
			view.forward(request, response);
		} else {
			
			PrintWriter out = response.getWriter();
			out.println("<script>alert('작성자와 비밀번호가 일치하지 않습니다')</script>");
		}
		
		} 

	
}