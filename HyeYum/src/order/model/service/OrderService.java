package order.model.service;

import java.util.ArrayList;

import common.JDBCTemplate;
import order.model.vo.Order;

public class OrderService {
	private JDBCTemplate factory;
	
	public OrderService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public ArrayList<Order> printAllOrderList(){ // 주문리스트 전체보기
		ArrayList<Order> list = null;
		return list;
	}
	
	public Order printOneOrder() { // 주문 상세보기
		Order order = null;
		return order;
	}
	
	public int registerOrder() { // 주문하기
		int result = 0;
		return result;
	}
	
	public int updateShippingState() { // 배송상태 변경
		int result = 0;
		return result;
	}
	
	public int updateOrder() { // 주문 변경 
		int result = 0;
		return result;
	}
	
	public int deleteOrder() { // 주문 삭제
		int result = 0;
		return result;
	}
}
