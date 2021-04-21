package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.BookAdminService;
import book.model.vo.BookReview;
import file.model.service.BookFileService;
import file.model.service.FileService;
import file.model.vo.FileData;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin/book/list")
public class BookAdminListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAdminListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<BookReview> rList = new BookAdminService().printAllBookReviewList();
		FileData fd = new FileData();
		fd.setFileType("book");
		System.out.println(rList);
		if(!rList.isEmpty()) {
			request.setAttribute("rList", rList);
			request.getRequestDispatcher("/WEB-INF/views/admin/board/bookList.jsp").forward(request, response);
			
		}else {
			
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
