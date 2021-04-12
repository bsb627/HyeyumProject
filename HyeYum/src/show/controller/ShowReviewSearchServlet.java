package show.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import file.model.service.FileService;
import file.model.vo.FileData;
import show.model.service.ShowService;
import show.model.vo.ShowData;
import show.model.vo.ShowPageData;
import show.model.vo.ShowReview;

/**
 * Servlet implementation class ShowBoardDeleteServlet
 */
@WebServlet("/showReview/search")
public class ShowReviewSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowReviewSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int currentPage = 0;
		if (request.getParameter("currentPage") == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		String search = request.getParameter("search");
		ShowPageData pageData = new ShowService().searchPrintAllShowReview(currentPage, search);
		ArrayList<ShowReview> showList = pageData.getReviewList();
		String pageNavi = pageData.getPageNavi();
		ArrayList<ShowData> replyCount = new ShowService().printReplyCount();
		ArrayList<ShowData> likesCount = new ShowService().printLikesCount();
		FileData fd = new FileData();
		fd.setFileType("show");
		ArrayList<FileData> fList = new FileService().printFileList("show");
		if(!showList.isEmpty()) {
			request.setAttribute("showList", showList);
			request.setAttribute("pageNavi", pageNavi);
			request.setAttribute("replyCount", replyCount);
			request.setAttribute("likesCount", likesCount);
			request.setAttribute("fList", fList);
			request.getRequestDispatcher("/WEB-INF/views/show/showReviewList.jsp").forward(request, response);
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
