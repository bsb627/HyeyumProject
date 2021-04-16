package book.controller;

import java.awt.print.Book;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.service.BookService;
import book.model.vo.BookPageData;
import book.model.vo.BookReview;

/**
 * Servlet implementation class BookBoardEnrollServlet
 */
@WebServlet("/bookReview/list")
public class BookReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int currentPage = 0; 
		if(request.getParameter("currentPage") == null) {
			currentPage = 1; 
		}else { 
			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		} 
		BookPageData pageData = new BookService().printAllBookReview(currentPage);
		ArrayList<BookReview> bList = pageData.getReviewList(); 
		String pageNavi = pageData.getPageNavi();
		
		System.out.println("blist : " + bList);
		
		if(!bList.isEmpty()) { 
			request.setAttribute("bList",bList);
			request.setAttribute("pageNavi", pageNavi); 
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/book/bookReviewList.jsp");
			view.forward(request, response); 
		}else { 
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/book/bookError.html");
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
