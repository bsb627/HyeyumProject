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
import order.model.service.OrderService;
import order.model.vo.Order;
import show.model.vo.ShowReview;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin/order/list")
public class AdminOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminOrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Order> oList = new OrderService().adminPrintAllOrderList();
		System.out.println(oList);
		if(!oList.isEmpty()) {
			request.setAttribute("oList", oList);
			request.getRequestDispatcher("/WEB-INF/views/admin/orderList.jsp").forward(request, response);
			
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
