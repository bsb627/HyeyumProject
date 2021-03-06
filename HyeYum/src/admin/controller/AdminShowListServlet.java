package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import file.model.service.FileService;
import file.model.vo.FileData;
import show.model.vo.ShowInfo;
import show.model.vo.ShowReview;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin/show/list")
public class AdminShowListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminShowListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ShowReview> rList = new AdminService().printAllShowReviewList();
		FileData fd = new FileData();
		fd.setFileType("show");
		ArrayList<FileData> fList = new FileService().printShowReviewFileList();
		System.out.println(rList);
		System.out.println(fList);
		if(!rList.isEmpty()) {
			request.setAttribute("rList", rList);
			request.setAttribute("fList", fList);
			request.getRequestDispatcher("/WEB-INF/views/admin/board/showList.jsp").forward(request, response);
			
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
