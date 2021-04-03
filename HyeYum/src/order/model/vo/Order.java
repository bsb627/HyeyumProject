package order.model.vo;

import java.sql.Date;


public class Order { // 주문
	private String companyName;// 제품명
	private String price;// 구매가격
	private String quantity;// 구매수량
	private String userName;// 주문자
	private String shippingState;// 배송상태
	private Date enrollDate;// 주문일자
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

}
