package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.model.service.AdminNoticeService;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class AdminNoticeWrite
 */
@WebServlet("/admin/notice/write")
public class AdminNoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/board/noticeWrite.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("들어왔니?");
	request.setCharacterEncoding("UTF-8");
	
	HttpSession session = request.getSession();
	String userId = (String) session.getAttribute("userId");
	String title = request.getParameter("title");
	String contents = request.getParameter("contents");
	
	
	
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContents(contents);
		notice.setUserId(userId);
		
		int result = new AdminNoticeService().registerNotice(notice);
		
		if(result > 0) {
			System.out.println("노티스 등록완료");
			response.sendRedirect("/admin/notice/list");
			
		}
	} 
}











