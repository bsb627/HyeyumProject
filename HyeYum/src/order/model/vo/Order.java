package order.model.vo;

import java.sql.Timestamp;

public class Order {

	private int orderNO;
	private String productName;
	private int price;
	private int quantity;
	private int totalPrice;
	private String userId;
	private String shippingState;
	private Timestamp orderTime; // 주문시간
}
