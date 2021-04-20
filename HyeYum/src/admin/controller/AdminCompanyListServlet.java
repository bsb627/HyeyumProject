package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company.model.service.CompanyService;
import company.model.vo.Company;
import order.model.service.OrderService;
import order.model.vo.Order;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin/company/list")
public class AdminCompanyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCompanyListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Company> cList = new CompanyService().printAllList();
		System.out.println(cList);
		if(!cList.isEmpty()) {
			request.setAttribute("cList", cList);
			request.getRequestDispatcher("/WEB-INF/views/admin/companyList.jsp").forward(request, response);
			
		}else {
			request.getRequestDispatcher("/WEB-INF/views/admin/companyEmptyList.jsp").forward(request, response);
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
