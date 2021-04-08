package order.model.dao;

import java.sql.Connection;
import java.util.ArrayList;
import order.model.vo.Order;

public class OrderDAO {
	public ArrayList<Order> selectAllOrderList(Connection conn, int currentPage) { // 주문리스트 전체보기
		return null;
	}
	
	public Order selectOneOrder(Connection conn, int orderNo) { // 주문 상세보기
		return null;
	}

	public int insertOrder(Connection conn, Order order) { // 주문하기
		return 0;
	}
	
	public int updateShipping(Connection conn, int orderNo, String shipping) { // 배송상태 변경
		return 0;
	}
	
	public int updateOrder(Connection conn, Order order) { // 주문 변경 
		return 0;
	}

	public int deleteOrder(Connection conn, int orderNo) { // 주문 삭제
		return 0;
	}
	
	public String getReviewPageNavi(Connection conn, int currentPage) { // 주문 페이징
		return null;
	}
	
	public int totalReviewCount(Connection conn) { // 주문 총 개수
		return 0;
	}
}
