package notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;
import notice.model.vo.NoticePageData;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/notice/list")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 0;
		if(request.getParameter("currentPage") == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
			NoticePageData noticepageData = new NoticeService().printAllList(currentPage);
			ArrayList<Notice> nList = noticepageData.getNoticeList();
			String pageNavi = noticepageData.getPageNavi();
			if(!nList.isEmpty()) {
				request.setAttribute("nList", nList);
				request.setAttribute("pageNavi", pageNavi);
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/noticeList.jsp");
				view.forward(request, response);
		
			} else {
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/noticeError.html");
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
