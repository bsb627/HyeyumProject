package order.model.vo;

import java.sql.Date;


public class Order { // 주문
	private int ordeNo; // 주문번호
	private String productName;// 제품명
	private int price;// 구매가격
	private int quantity;// 구매수량
	private int totalPrice; // 총 구매액
	private String userId;// 주문자
	private String shippingState;// 배송상태
	private Date orderDate;// 주문일자
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

}

