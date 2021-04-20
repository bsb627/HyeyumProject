package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminNoticeService;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class AdminNoticeUpdate
 */
@WebServlet("/admin/notice/update")
public class AdminNoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		Notice  notice = new AdminNoticeService().printOneAdmin(noticeNo);
		if(notice != null) {
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("/WEB-INF/views/notice/noticeModify.jsp").forward(request, response);
	}else {
		request.getRequestDispatcher("/WEB-INF/views/notice/noticeError.html").forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8"); // 한글 인코딩
		String title = request.getParameter("notice-title"); 
		String content = request.getParameter("notice-contents");
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		System.out.println("정해진거없죠?" + noticeNo);
		// UPDATE NOTICE SET TITLE = ?, CONTENTS = ? WHERE NOTICENO = ?;
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContents(content);
		notice.setNoticeNo(noticeNo);
		int result = new AdminNoticeService().modifyNotice(notice);
		if(result > 0) {
			request.getRequestDispatcher("/admin/notice/list").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/notice/noticeError.html").forward(request, response);
		}
	}

}
