package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin/show/delete")
public class AdminShowDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminShowDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] noArr = request.getParameterValues("review-no");
		String reviewNo = "";
		for (String no : noArr) {
			if (no.equals(noArr[noArr.length - 1])) {
				reviewNo += no;
				System.out.println(no);
			} else {
				reviewNo += no+",";
				System.out.print(no + ",");
			}
		}
		System.out.println("보내는 번호"+reviewNo);
		  int result = new AdminService().deleteShowReview(reviewNo);
		  System.out.println("성공"+result);
		  if(result > 0) {
			  request.getRequestDispatcher("/admin/show/list").forward(request, response);
		  }else {
			  
		  }
		 
		//request.getRequestDispatcher("/WEB-INF/views/admin/board/showList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
