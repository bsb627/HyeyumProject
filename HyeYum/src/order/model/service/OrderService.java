package order.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import order.model.dao.OrderDAO;
import order.model.vo.Order;
import order.model.vo.OrderPageData;
import show.model.vo.ShowPageData;

public class OrderService {
	private JDBCTemplate factory;
	
	public OrderService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public OrderPageData printAllOrderList(int currentPage, String userId){ // 주문리스트 전체보기
		Connection conn = null;
		OrderPageData pd = new OrderPageData();
		try {
			conn = factory.createConnection();
			pd.setOrderList(new OrderDAO().selectAllOrderList(conn, currentPage, userId));
			pd.setPageNavi(new OrderDAO().getReviewPageNavi(conn, currentPage, userId));
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
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			order = new OrderDAO().selectOneOrder(conn, orderNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return order;
	}
	
	public int registerOrder(String userId) { // 주문하기
		int result = 0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new OrderDAO().insertOrder(conn, userId);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int updateShippingState(int orderNo, String shipping) { // 배송상태 변경
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new OrderDAO().updateShipping(conn, orderNo, shipping);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int updateOrder(Order order) { // 주문 변경 
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new OrderDAO().updateOrder(conn, order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteOrder(String orderNo) { // 주문 삭제
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new OrderDAO().deleteOrder(conn, orderNo);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int getOrderCount(String userId) {
		int orderCount = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			orderCount = new OrderDAO().totalOrderCount(conn, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return orderCount;
	}

	public ArrayList<Order> adminPrintAllOrderList() { // 관리자단 주문 리스트 전체 보기
		ArrayList<Order> oList = null;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			oList = new OrderDAO().selectAdminAllOrderList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
 		return oList;
	}
}
