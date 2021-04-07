package order.model.dao;

import java.sql.Connection;
import java.util.ArrayList;
import order.model.vo.Order;

public class OrderDAO {
	public ArrayList<Order> selectAllOrderList(Connection conn, int currentPage) {
		return null;
	}
	
	public Order selectOneOrder(Connection conn, int qnaNo) {
		return null;
	}

	public int insertOrder(Connection conn, Order order) {
		return 0;
	}

	public int deleteOrder(Connection conn, int qnaNo) {
		return 0;
	}

	public int updateOrder(Connection conn, Order order) {
		return 0;
	}
	
	public int updateShipping(Connection conn, String shipping) {
		return 0;
	}
	
	public String getReviewPageNavi(Connection conn, int currentPage) {
		return null;
	}
	
	public int totalReviewCount(Connection conn) {
		return 0;
	}
}
