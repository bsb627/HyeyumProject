package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminNoticeService;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class AdminNoticeDeleteServlet
 */
@WebServlet("/admin/notice/delete")
public class AdminNoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] noArr = request.getParameterValues("noticeNo");
		String noticeNo = "";
		for (String no : noArr) {
			if (no.equals(noArr[noArr.length - 1])) {
				noticeNo += no;
				System.out.println(no);
			} else {
				noticeNo += no+",";
				System.out.print(no + ",");
			}
		}
		System.out.println("보내는 번호"+noticeNo);
		
		
		int result = new AdminNoticeService().deleteNotice(noticeNo);

		if(result > 0) {
			
			RequestDispatcher view = request.getRequestDispatcher("/admin/notice/list");
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
