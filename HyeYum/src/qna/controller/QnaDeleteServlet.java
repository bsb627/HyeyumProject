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
 * Servlet implementation class QnADeleteServlet
 */
@WebServlet("/qna/delete")
public class QnaDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaDeleteServlet() {
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
		// TODO Auto-generated method stub

		System.out.println("딜리트로 드러옴 ");
		int qnaNo = Integer.parseInt(request.getParameter("qna-no"));
		System.out.println("딜리트 qnaNO : " + qnaNo);
		int result = new QnaService().deleteQna(qnaNo);
		System.out.println("result : " + result);
		if (result > 0) {
			RequestDispatcher view  = request.getRequestDispatcher("/qna/list");
			view.forward(request, response);
		} else {
			RequestDispatcher view  = request.getRequestDispatcher("/WEB-INF/views/qna/qnaError.html");
			view.forward(request, response);
		}
	}

}
