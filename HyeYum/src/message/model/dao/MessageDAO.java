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
	// 보낸 메시지 네비 
	public String getPageNavi(Connection conn, int currentPage, String userId) {
			int recordTotalCount = totalCountSent(conn, userId);
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
	
	// 보낸 메시지 전체 갯수
	public int totalCountSent(Connection conn, String userId) {
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
	
	// 받은 메시지 전체 갯수 
	private int totalCountRe(Connection conn, String userId) {
			Statement stmt = null;
			ResultSet rset = null;
			String query = "SELECT COUNT(*) AS TOTALCOUNT FROM MESSAGERE WHERE RECEIVER = '" + userId +"'";
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
	
	// 받은 메시지 전체 출력 
	public ArrayList<Message> selectAllRecievedList(Connection conn, int currentPage, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Message> sentMsgList = null;
		String query = "SELECT *FROM (SELECT ROW_NUMBER() OVER (ORDER BY MESSAGE_NO DESC) AS NUM, MESSAGE_NO, CONTENTS, SEND_DATE, READ_STATE, RECEIVER, SENDER FROM MESSAGERE WHERE RECEIVER = ? ) WHERE NUM BETWEEN ? AND ?";
		
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
	
	// 받은 메시지 네비
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

	// 메시지 하나 출력 
	public Message selectOne(Connection conn, int messageNo, String table) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Message message = new Message();
		
		String query = "SELECT * FROM "+ table +" WHERE MESSAGE_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			//pstmt.setString(1, table);
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
	

	
	// (전송 취소 기능) 보낸 메시지 삭제 
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
	
	// (전송 취소 기능) 받은 메시지 삭제 
	public int deleteMessage2(Connection conn, int messageNo) {
		PreparedStatement pstmt = null;
		String query = "DELETE FROM MESSAGERE WHERE MESSAGE_NO = ?";
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
	

	// 보낸 메시지 테이블에 메시지 전송 
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
			e.printStackTrace();
		} 
		finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	// 보낸 메시지 테이블 읽음여부 업데이트 
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
	
	// 받은 메시지 테이블 읽음 여부 업데이트 
	public int updateReadState2(Connection conn, int messageNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MESSAGERE SET READ_STATE = ? WHERE MESSAGE_NO = ?";
		
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
	
	
	
	// 받은 메시지 검색
		public ArrayList<Message> selectSearchList(Connection conn,  String searchCategory,String search, int currentPage, String userId) {
			PreparedStatement pstmt  = null;
			ResultSet rset = null;
			String query = "SELECT * FROM ( SELECT ROW_NUMBER() OVER (ORDER BY MESSAGE_NO DESC)AS NUM, MESSAGE_NO, CONTENTS, SEND_DATE, READ_STATE, RECEIVER, SENDER FROM MESSAGERE WHERE "+ searchCategory +" LIKE ? AND RECEIVER = ?) WHERE NUM BETWEEN ? AND ?";
			ArrayList<Message> searchList = null;
			int recordCountPerPage = 10 ; 
			int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
			int end = currentPage*recordCountPerPage;
			System.out.println(searchCategory + search + userId);
			try {
				pstmt = conn.prepareStatement(query);
				//pstmt.setString(1, searchCategory);
				pstmt.setString(1,"%" + search + "%");
				pstmt.setString(2, userId);
				pstmt.setInt(3, start);
				pstmt.setInt(4, end);
				rset = pstmt.executeQuery();
				
				searchList = new ArrayList<Message>();
				while(rset.next()) {
					Message message = new Message();
					message.setMessageNo(rset.getInt("MESSAGE_NO"));
					message.setContents(rset.getString("CONTENTS"));
					message.setReadState(rset.getString("READ_STATE"));
					message.setSendTime(rset.getTimestamp("SEND_DATE"));
					message.setSender(rset.getString("SENDER"));
					message.setReceiver(rset.getString("RECEIVER"));
					searchList.add(message);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			
			return searchList;
			
		}
	// 받은 메시지 검색 페이지 네비 
		public String getSearchPageNavi(Connection conn, String searchCategory, String search, int currentPage, String userId) {
			
			
			int recordCountPerPage = 10;
			int naviCountPerPage = 5; 
			int recordTotalCount = searchTotalCount(conn,  searchCategory, search, userId); 
			
			int pageTotalCount = 0; 
			if( recordTotalCount % recordCountPerPage > 0) { 
				pageTotalCount = recordTotalCount / recordCountPerPage + 1;
			} else {
				pageTotalCount = recordTotalCount / recordCountPerPage;
			}
			// ====오류 방지용 코드 ==== //
			if (currentPage < 1 ) {
				currentPage = 1; // 
			} else if(currentPage > pageTotalCount) {
				currentPage = pageTotalCount; 
			}
								
			int startNavi = ((currentPage -1) / naviCountPerPage ) * naviCountPerPage + 1;
			int endNavi = startNavi + naviCountPerPage -1; 
			if(endNavi > pageTotalCount) {
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
			
			// a태그 만드는 코드
			StringBuilder sb = new StringBuilder();
			if(needPrev) {
				sb.append("<a href='/message/search/received?search-keyword="+search+ "search-category="+searchCategory+"&currentPage="+ (startNavi-1)+"'> 이전 </a>");
			}
			for(int i = startNavi; i <= endNavi; i++) {
				if( currentPage == i) {sb.append("<a href='/message/search/received?search-keyword="+search+ "&search-category="+searchCategory+"&currentPage=" + i + "'>"+ "<input type = 'button' class = 'btn btn-outline-primary  active' value = '"+ i + "'>    </a>"); }
				else {sb.append("<a href='/message/search/received?search-keyword="+search+ "&search-category="+searchCategory+"&currentPage=" + i + "'>"+ "<input type = 'button' class = 'btn btn-outline-primary' value = '"+ i + "'>    </a>");}
			}
			if(needNext) {
				sb.append("<a href='/message/search/received?search-keyword="+search+ "&search-category="+searchCategory+"currentPage="+ (endNavi+1)+"'> 다음 </a>");
			}
			
			return sb.toString();
		}
	// 받은 메시지 검색 토탈 갯수
		public int searchTotalCount(Connection conn, String searchCategory , String search, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM MESSAGE WHERE " + searchCategory + " LIKE ? AND RECEIVER = ?";
		int recordTotalCount = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%" );
			pstmt.setString(2, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return recordTotalCount;
		
	}

	

// 보낸 메시지 검색 리스트
	public ArrayList<Message> selectSearchListSent(Connection conn, String searchCategory, String search, int currentPage, String userId) {
		PreparedStatement pstmt  = null;
		ResultSet rset = null;
		String query = "SELECT * FROM ( SELECT ROW_NUMBER() OVER (ORDER BY MESSAGE_NO DESC)AS NUM, MESSAGE_NO, CONTENTS, SEND_DATE, READ_STATE, RECEIVER, SENDER FROM MESSAGE WHERE "+ searchCategory +" LIKE ? AND SENDER = ?) WHERE NUM BETWEEN ? AND ?";
		ArrayList<Message> searchList = null;
		int recordCountPerPage = 10 ; 
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			//pstmt.setString(1, searchCategory);
			pstmt.setString(1,"%" + search + "%");
			pstmt.setString(2, userId);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			rset = pstmt.executeQuery();
			
			searchList = new ArrayList<Message>();
			while(rset.next()) {
				Message message = new Message();
				message.setMessageNo(rset.getInt("MESSAGE_NO"));
				message.setContents(rset.getString("CONTENTS"));
				message.setReadState(rset.getString("READ_STATE"));
				message.setSendTime(rset.getTimestamp("SEND_DATE"));
				message.setSender(rset.getString("SENDER"));
				message.setReceiver(rset.getString("RECEIVER"));
				searchList.add(message);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return searchList;
	}
// 보낸 메시지 검색 페이지 네비
	public String getSearchPageNaviSent(Connection conn, String searchCategory, String search, int currentPage, String userId) {
		int recordCountPerPage = 10;
		int naviCountPerPage = 5; 
		int recordTotalCount = searchTotalCountSent(conn,searchCategory, search, userId); 
		
		int pageTotalCount = 0; 
		if( recordTotalCount % recordCountPerPage > 0) { 
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		// ====오류 방지용 코드 ==== //
		if (currentPage < 1 ) {
			currentPage = 1; // 
		} else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount; 
		}
							
		int startNavi = ((currentPage -1) / naviCountPerPage ) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage -1; 
		if(endNavi > pageTotalCount) {
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
		
		// a태그 만드는 코드
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/message/search/sent?search-keyword="+search+ "&serach-category="+searchCategory+"currentPage="+ (startNavi-1)+"'> 이전 </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if( currentPage == i) {sb.append("<a href='/message/search/sent?search-keyword="+search+ "&search-category="+searchCategory+"&currentPage=" + i + "'>"+ "<input type = 'button' class = 'btn btn-outline-primary active' value = '"+ i + "'>    </a>"); }
			else {sb.append("<a href='/message/search/sent?search-keyword="+search+ "&search-category="+searchCategory+"&currentPage=" + i + "'>"+ "<input type = 'button' class = 'btn btn-outline-primary' value = '"+ i + "'>    </a>");}
		}
		if(needNext) {
			sb.append("<a href='/message/search/sent?search-keyword="+search+ "&search-category="+searchCategory+"&currentPage="+ (endNavi+1)+"'> 다음 </a>");
		}
		return sb.toString();
	}
// 보낸 메시지 검색 토탈 카운트
	public int searchTotalCountSent(Connection conn, String searchCategory , String search, String userId) {
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	String query = "SELECT COUNT(*) AS TOTALCOUNT FROM MESSAGE WHERE " + searchCategory + " LIKE ? AND SENDER = ?";
	int recordTotalCount = 0;
	try {
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, "%" + search + "%" );
		pstmt.setString(2, userId);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			recordTotalCount = rset.getInt("TOTALCOUNT");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		JDBCTemplate.close(rset);
		JDBCTemplate.close(pstmt);
	}
	
	return recordTotalCount;
	
}
	
	
	
//선택된 메세지들 삭제
	public int deleteMessages(Connection conn, String msgNo, String table) {
		Statement stmt = null;
		String query = "DELETE FROM "+ table + " WHERE MESSAGE_NO IN ("+ msgNo +")";
		int result = 0;
		
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

	
	//==============받은 메시지 테이블에 메시지 추가============//
	public int insertMessage2(Connection conn, Message message) {
		PreparedStatement pstmt = null;
		int result2 = 0;
		String query = "INSERT INTO MESSAGERE VALUES(MSG_NO2.NEXTVAL, ?, SYSDATE, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, message.getContents());
			pstmt.setString(2, message.getReadState());
			pstmt.setString(3, message.getReceiver());
			pstmt.setString(4, message.getSender());
			result2 = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result2;
	}
}
