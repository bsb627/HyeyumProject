package book.controller;

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
import book.model.vo.BookShare;
import file.model.service.BookFileService;
import file.model.vo.FileData;
import show.model.service.ShowService;
import show.model.vo.ShowInfo;

/**
 * Servlet implementation class BookBoardEnrollServlet
 */
@WebServlet("/bookShare/list")
public class BookShareListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookShareListServlet() {
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
		BookPageData pageData = new BookService().printAllBookShare(currentPage);
		ArrayList<BookShare> sList = pageData.getShareList(); 
		String pageNavi = pageData.getPageNavi();
		
		FileData fd = new FileData();
		fd.setFileType("share");
		ArrayList<FileData> fList = new BookFileService().printFileShareList("share"); // Detail에서 화면에 가져온 이미지를 뿌려주기 위해 보내줌 

		if(!sList.isEmpty()) { 
			request.setAttribute("sList",sList);
			request.setAttribute("pageNavi", pageNavi); 
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/book/bookShareList.jsp");
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
