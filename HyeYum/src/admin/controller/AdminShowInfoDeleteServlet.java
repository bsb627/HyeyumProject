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
@WebServlet("/admin/showInfo/delete")
public class AdminShowInfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminShowInfoDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] noArr = request.getParameterValues("info-no");
		String infoNo = "";
		for (String no : noArr) {
			if (no.equals(noArr[noArr.length - 1])) {
				infoNo += no;
				System.out.println(no);
			} else {
				infoNo += no+",";
				System.out.print(no + ",");
			}
		}
		System.out.println("보내는 번호"+infoNo);
		  int result = new AdminService().deleteShowInfo(infoNo);
		  System.out.println("성공"+result);
		  if(result > 0) {
			  request.getRequestDispatcher("/admin/showInfo/list").forward(request, response);
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
