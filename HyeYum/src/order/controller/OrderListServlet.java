package order.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import order.model.service.OrderService;
import order.model.vo.Order;
import order.model.vo.OrderPageData;

/**
 * Servlet implementation class OrderEnrollServlet
 */
@WebServlet("/order/list")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		int currentPage = 0;
		if (request.getParameter("currentPage") == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		OrderPageData pd = new OrderService().printAllOrderList(currentPage, userId);
		ArrayList<Order> oList = pd.getOrderList();
		String pageNavi = pd.getPageNavi();
		int orderCount = new OrderService().getOrderCount(userId);
		if(! oList.isEmpty()) {
			request.setAttribute("oList", oList);
			request.setAttribute("pageNavi", pageNavi);
			request.setAttribute("orderCount", orderCount);
			request.getRequestDispatcher("/WEB-INF/views/order/orderList.jsp").forward(request, response);
			
		}else {
			request.getRequestDispatcher("/WEB-INF/views/order/orderEmptyList.jsp").forward(request, response);
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
