package company.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.model.service.CompanyService;
import order.model.service.OrderService;

/**
 * Servlet implementation class CompanyDeleteServlet
 */
@WebServlet("/company/delete")
public class CompanyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] noArr = request.getParameterValues("company-no");
		String companyNo = "";
		for (String no : noArr) {
			if (no.equals(noArr[noArr.length - 1])) {
				companyNo += no;
				System.out.println(no);
			} else {
				companyNo += no+",";
				System.out.print(no + ",");
			}
		}
		System.out.println("보내는 번호"+companyNo);
		  int result = new CompanyService().deleteCompany(companyNo);
				  System.out.println("성공"+result);
		  if(result > 0) {
			  request.getRequestDispatcher("/admin/company/list").forward(request, response);
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
