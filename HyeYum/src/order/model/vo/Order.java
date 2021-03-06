package order.model.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class Order {

	private int orderNO; // 주문번호
	private String productName; // 제품명
	private int price; // 제품가격
	private int quantity; // 주문수량
	private int totalPrice; // 총 가격
	private String userId; // 구매자
	private String nick; // 닉네임
	private String userName; //이름
	private String address; // 주소
	private String email; // 이메일
	private String userPhone; // 핸드폰
	private String shippingState; // 배송상태
	private Timestamp orderTime; // 주문시간
	private Date orderDate; // 주문일
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderNO() {
		return orderNO;
	}

	public void setOrderNO(int orderNO) {
		this.orderNO = orderNO;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getShippingState() {
		return shippingState;
	}

	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}
	
	

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Override
	public String toString() {
		return "Order [orderNO=" + orderNO + ", productName=" + productName + ", price=" + price + ", quantity="
				+ quantity + ", totalPrice=" + totalPrice + ", userId=" + userId + ", shippingState=" + shippingState
				+ ", orderTime=" + orderTime + "]";
	}
	
	
}
