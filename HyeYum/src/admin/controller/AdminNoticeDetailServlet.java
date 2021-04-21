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
 * Servlet implementation class AdminNoticeDetailServlet
 */
@WebServlet("/admin/notice/detail")
public class AdminNoticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		Notice notice = new AdminNoticeService().printOneAdmin(noticeNo);
		
		if(notice != null) {
			System.out.println("notice" + notice);
			request.setAttribute("notice", notice);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/board/adminNoticeDetail.jsp");
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
