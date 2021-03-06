package qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna.model.service.QnaService;
import qna.model.vo.Qna;
import qna.model.vo.QnaPageData;

/**
 * Servlet implementation class QnaSearchServlet
 */
@WebServlet("/qna/search")
public class QnaSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int currentPage = 0;
		if(request.getParameter("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			
		}
		String search = request.getParameter("search-keyword"); //noticelist.jsp 에 name
		String searchCategory = request.getParameter("search-category");
		QnaPageData pageData = new QnaService().printSearchList(search, searchCategory, currentPage );
		ArrayList<Qna> searchList = pageData.getQnaList();
		String pageNavi = pageData.getPageNavi();
		
		if(!searchList.isEmpty()) {
			request.setAttribute("searchList", searchList);
			request.setAttribute("pageNavi", pageNavi);
			request.getRequestDispatcher("/WEB-INF/views/qna/qnaSearchList.jsp").forward(request, response);
		} else {
			System.out.println("qna 검색 결과가 없습니다");
			request.getRequestDispatcher("/WEB-INF/views/qna/qnaSearchListNone.jsp").forward(request, response);
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
