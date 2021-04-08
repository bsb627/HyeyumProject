package order.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import order.model.vo.Order;
import order.model.vo.OrderPageData;
import show.model.vo.ShowPageData;

public class OrderService {
	private JDBCTemplate factory;
	
	public OrderService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public OrderPageData printAllOrderList(int currentPage){ // 주문리스트 전체보기
		Connection conn = null;
		OrderPageData pd = new OrderPageData();
		try {
			conn = factory.createConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public Order printOneOrder(int orderNo) { // 주문 상세보기
		Order order = null;
		return order;
	}
	
	public int registerOrder(Order order) { // 주문하기
		int result = 0;
		return result;
	}
	
	public int updateShippingState(int orderNo, String shipping) { // 배송상태 변경
		int result = 0;
		return result;
	}
	
	public int updateOrder(Order order) { // 주문 변경 
		int result = 0;
		return result;
	}
	
	public int deleteOrder(int orderNo) { // 주문 삭제
		int result = 0;
		return result;
	}
}
