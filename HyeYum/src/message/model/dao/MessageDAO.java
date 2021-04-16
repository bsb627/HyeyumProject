package message.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import message.model.vo.Message;
import qna.model.vo.Qna;

public class MessageDAO {

	// 보낸 메시지 전체 출력
	public ArrayList<Message> selectAllSentList(Connection conn, int currentPage, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Message> sentMsgList = null;
		String query = "SELECT *FROM (SELECT ROW_NUMBER() OVER (ORDER BY MESSAGE_NO DESC) AS NUM, MESSAGE_NO, CONTENTS, SEND_DATE, READ_STATE, RECEIVER, SENDER FROM MESSAGE WHERE SENDER = ? ) WHERE NUM BETWEEN ? AND ?";
		
		int recordCountPerPage = 10;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			sentMsgList = new ArrayList<Message>();
			while(rset.next()) {
				Message message = new Message();
				message.setMessageNo(rset.getInt("MESSAGE_NO"));
				message.setContents(rset.getString("CONTENTS"));
				message.setReadState(rset.getString("READ_STATE"));
				message.setSendTime(rset.getTimestamp("SEND_DATE"));
				message.setSender(rset.getString("SENDER"));
				message.setReceiver(rset.getString("RECEIVER"));
				sentMsgList.add(message);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return sentMsgList;

	}
	
	// 받은 메시지 전체 출력 
	public ArrayList<Message> selectAllRecievedList(Connection conn, int currentPage, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Message> sentMsgList = null;
		String query = "SELECT *FROM (SELECT ROW_NUMBER() OVER (ORDER BY MESSAGE_NO DESC) AS NUM, MESSAGE_NO, CONTENTS, SEND_DATE, READ_STATE, RECEIVER, SENDER FROM MESSAGE WHERE RECEIVER = ? ) WHERE NUM BETWEEN ? AND ?";
		
		int recordCountPerPage = 10;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			sentMsgList = new ArrayList<Message>();
			while(rset.next()) {
				Message message = new Message();
				message.setMessageNo(rset.getInt("MESSAGE_NO"));
				message.setContents(rset.getString("CONTENTS"));
				message.setReadState(rset.getString("READ_STATE"));
				message.setSendTime(rset.getTimestamp("SEND_DATE"));
				message.setSender(rset.getString("SENDER"));
				message.setReceiver(rset.getString("RECEIVER"));
				sentMsgList.add(message);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return sentMsgList;

	}
	

	// 메시지 하나 출력 
	public Message selectOne(Connection conn, int messageNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Message message = new Message();
		String query = "SELECT * FROM MESSAGE WHERE MESSAGE_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, messageNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				message.setMessageNo(rset.getInt("MESSAGE_NO"));
				message.setContents(rset.getString("CONTENTS"));
				message.setReadState(rset.getString("READ_STATE"));
				message.setSendTime(rset.getTimestamp("SEND_DATE"));
				message.setSender(rset.getString("SENDER"));
				message.setReceiver(rset.getString("RECEIVER"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return message;
	}
	
	// 메시지 삭제
	public int deleteMessage(Connection conn, int messageNo) {
		PreparedStatement pstmt = null;
		String query = "DELETE FROM MESSAGE WHERE MESSAGE_NO = ?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,	messageNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	// 메시지 전송 
	public int insertMessage(Connection conn, Message message) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO MESSAGE VALUES(MSG_NO.NEXTVAL, ?, SYSDATE, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, message.getContents());
			pstmt.setString(2, message.getReadState());
			pstmt.setString(3, message.getReceiver());
			pstmt.setString(4, message.getSender());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	// 검색
	public ArrayList<Message> selectSearchList(Connection conn, String search, String searchCategory, int currentPage) {
		return null;
		
	}
	
	// 검색네비 
	public String getSearchPageNavi(Connection conn, String search, int currentPage, String searchCategory) {
		PreparedStatement pstmt= null;
		
		int recordCountPerPage = 10; // 게시물을 10개씩 
		int naviCountPerPage = 10; // 네비를 10개씩 보여줄거
		int recordTotalCount = searchTotalCount(conn, search, searchCategory); // 전체 게시물 수
		return null;
	}




	public String selectSearchPageNavi(Connection conn, String searchCategory, String search, int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int searchTotalCount(Connection conn, String search, String searchCategory) {
		return 0;
		
	}

	//받은 메시지 네비
	public String getPageNaviRe(Connection conn, int currentPage, String userId) {
		int recordTotalCount = totalCountRe(conn, userId);
		int pageTotalCount = 0;
		int recordCountPerPage = 10;
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
			sb.append("<a href='/message/receivedList?currentPage=" + (startNavi-1) + "'> < </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if( currentPage == i) { sb.append("<a href='/message/receivedList?currentPage=" + i + "'>" +"<input type = 'button' class = 'btn btn-outline-primary active' value = '"+ i + "'>  </a>");}
			else { sb.append("<a href='/message/receivedList?currentPage=" + i + "'>" +"<input type = 'button' class = 'btn btn-outline-primary' value = '"+ i + "'>  </a>"); }
		}
		if( needNext) {
			sb.append("<a href='/message/receivedList?currentPage=" + (endNavi + 1) + "'> > </a>");
		}
		return sb.toString();
	}

	// 받은 메시지 전체 갯수 
	private int totalCountRe(Connection conn, String userId) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM MESSAGE WHERE RECEIVER = '" + userId +"'";
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


	// 보낸 메시지 네비 
	public String getPageNavi(Connection conn, int currentPage, String userId) {
		int recordTotalCount = totalCount(conn, userId);
		int pageTotalCount = 0;
		int recordCountPerPage = 10;
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
			sb.append("<a href='/message/sentList?currentPage=" + (startNavi-1) + "'> < </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if( currentPage == i) { sb.append("<a href='/message/sentList?currentPage=" + i + "'>" +"<input type = 'button' class = 'btn btn-outline-primary active' value = '"+ i + "'>  </a>");}
			else { sb.append("<a href='/message/sentList?currentPage=" + i + "'>" +"<input type = 'button' class = 'btn btn-outline-primary' value = '"+ i + "'>  </a>"); }
		}
		if( needNext) {
			sb.append("<a href='/message/sentList?currentPage=" + (endNavi + 1) + "'> > </a>");
		}
		return sb.toString();
	}
	
	
	// 보낸 메시지 전체 갯수
	public int totalCount(Connection conn, String userId) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM MESSAGE WHERE SENDER = '" + userId +"'";
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

	public int updateReadState(Connection conn, int messageNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MESSAGE SET READ_STATE = ? WHERE MESSAGE_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "읽음");
			pstmt.setInt(2, messageNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}
