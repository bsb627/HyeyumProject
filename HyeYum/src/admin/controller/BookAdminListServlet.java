package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import admin.model.service.BookAdminService;
import book.model.vo.BookInfo;
import file.model.service.FileService;
import file.model.vo.FileData;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin/bookInfo/listlist")
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
		ArrayList<BookInfo> rList = new BookAdminService().printAllBookInfoList();
		FileData fd = new FileData();
		fd.setFileType("book");
		ArrayList<FileData> fList = new FileService().printShowReviewFileList();
		System.out.println(rList);
		System.out.println(fList);
		if(!rList.isEmpty()) {
			request.setAttribute("rList", rList);
			request.setAttribute("fList", fList);
			request.getRequestDispatcher("/WEB-INF/views/admin/contents/bookInfo.jsp").forward(request, response);
			
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
