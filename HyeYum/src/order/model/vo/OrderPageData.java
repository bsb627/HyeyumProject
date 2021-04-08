package order.model.vo;

import java.util.ArrayList;

public class OrderPageData {
	
	private ArrayList<Order> orderList;
	private String pageNavi;

	public OrderPageData() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "OrderPageData [orderList=" + orderList + ", pageNavi=" + pageNavi + "]";
	}
	
	
	
}
