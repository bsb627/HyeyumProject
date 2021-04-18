package order.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import order.model.service.OrderService;

/**
 * Servlet implementation class OrderEnrollServlet
 */
@WebServlet("/order/delete")
public class OrderDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] noArr = request.getParameterValues("order-no");
		String orderNo = "";
		for (String no : noArr) {
			if (no.equals(noArr[noArr.length - 1])) {
				orderNo += no;
				System.out.println(no);
			} else {
				orderNo += no+",";
				System.out.print(no + ",");
			}
		}
		System.out.println("보내는 번호"+orderNo);
		  int result = new OrderService().deleteOrder(orderNo);
				  System.out.println("성공"+result);
		  if(result > 0) {
			  request.getRequestDispatcher("/admin/order/list").forward(request, response);
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
