package order.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import common.JDBCTemplate;
import order.model.vo.Order;

public class OrderDAO {
	public ArrayList<Order> selectAllOrderList(Connection conn, int currentPage, String userId) { // 주문리스트 전체보기
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Order> oList = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY ORDER_DATE DESC) AS NUM,ORDER_NO,USER_ID,PRODUCT_NO,PRODUCT_NAME,QUANTITY,TOTALPRICE,ORDER_DATE,SHIPPING_STATE FROM ORDERS JOIN PRODUCT USING(PRODUCT_NO) WHERE USER_ID = ?) WHERE NUM BETWEEN ? AND ?";
		
		int recordCountPerPage = 5;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			if (rset != null) {
				oList = new ArrayList<Order>();
				while(rset.next()) {
					Order order = new Order();
					order.setOrderNO(rset.getInt("ORDER_NO"));
					order.setOrderDate(rset.getDate("ORDER_DATE"));
					order.setProductName(rset.getString("PRODUCT_NAME"));
					order.setTotalPrice(rset.getInt("TOTALPRICE"));
					order.setQuantity(rset.getInt("QUANTITY"));
					order.setShippingState(rset.getString("SHIPPING_STATE"));
					oList.add(order);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return oList;
	}
	
	public Order selectOneOrder(Connection conn, int orderNo) { // 주문 상세보기
		return null;
	}

	public int insertOrder(Connection conn, String userId) { // 주문하기
		PreparedStatement pstmt = null;
		String query = "INSERT INTO ORDERS VALUES(SEQ_ORDER_NO.NEXTVAL,?,1,1,SYSDATE,15000,'주문완료')";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int updateShipping(Connection conn, int orderNo, String shipping) { // 배송상태 변경
		PreparedStatement pstmt = null;
		String query = "UPDATE ORDERS SET SHIPPING_STATE = ? WHERE ORDER_NO = ?";
		int result = 0;
		System.out.println(orderNo);
		System.out.println(shipping);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, shipping);
			pstmt.setInt(2, orderNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int updateOrder(Connection conn, Order order) { // 주문 변경 
		return 0;
	}

	public int deleteOrder(Connection conn, String orderNo) { // 주문 삭제
		Statement stmt = null;
		int result = 0;
		String query = "DELETE FROM ORDERS WHERE ORDER_NO IN ("+orderNo+")";
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(stmt);
		}
		
		return result;
	}
	
	public String getReviewPageNavi(Connection conn, int currentPage, String userId) { // 주문 페이징
		int recordTotalCount = totalOrderCount(conn, userId);
		int pageTotalCount = 0;
		int recordCountPerPage = 5;
		if ( recordTotalCount % recordCountPerPage > 0 ) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		if(currentPage < 1 ) {
			currentPage = 1;
		} else if(currentPage >  pageTotalCount) {
			currentPage = pageTotalCount;
		}
		
		int naviCountPerPage = 10;
		int startNavi = ((currentPage -1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		// 오류방지 코드
		if( endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if( needPrev ) {
			sb.append("<li><a href='/order/list?currentPage="+ (startNavi-1) + "'> 이전 </a></li>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(currentPage == i) {
				sb.append("<li class='active'><a href='/order/list?currentPage="+ i +"'>" + i + "</a></li>");
			}else {
				sb.append("<li><a href='/order/list?currentPage="+ i +"'>" + i + "</a></li>");
			}
		}
		if( needNext) {
			sb.append("<li><a href='/order/list?currentPage="+ (endNavi + 1) + "'> 다음 </a></li>");
		}
		return sb.toString();
	}
	
	public int totalOrderCount(Connection conn, String userId) { // 주문 총 개수
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM ORDERS WHERE USER_ID ='"+userId+"'";
		int recordTotalCount = 0;
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return recordTotalCount;
	}

	public ArrayList<Order> selectAdminAllOrderList(Connection conn) { // 관리자단 주문 리스트 전체 보기
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM ORDERS JOIN MEMBER USING(USER_ID) ORDER BY ORDER_NO DESC";
		ArrayList<Order> oList = null;
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if ( rset != null) {
				oList = new ArrayList<Order>();
				while(rset.next()) {
					Order order = new Order();
					order.setOrderNO(rset.getInt("ORDER_NO"));
					order.setUserId(rset.getString("USER_ID"));
					order.setNick(rset.getString("NICK"));
					order.setUserName(rset.getString("USER_NAME"));
					order.setAddress(rset.getString("ADDRESS"));
					order.setEmail(rset.getString("EMAIL"));
					order.setUserPhone(rset.getString("USER_PHONE"));
					order.setQuantity(rset.getInt("QUANTITY"));
					order.setOrderDate(rset.getDate("ORDER_DATE"));
					order.setPrice(rset.getInt("TOTALPRICE"));
					order.setShippingState(rset.getString("SHIPPING_STATE"));
					oList.add(order);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return oList;
	}
}
