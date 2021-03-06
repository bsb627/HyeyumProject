package reply.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import reply.model.vo.Reply;

public class ReplyDAO {
	
	public ArrayList<Reply> selectAllList(Connection conn, int currentPage, String replyType,int showNo) { // 댓글 전체보기
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Reply> replyList = null;
		String query = "";
		String type = replyType;
		switch (type) {
		case "book":
			
			break;
		case "share":
			
			break;
		case "movie":
			
			break;
		case "show":
			query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY ENROLL_DATE DESC)AS NUM,REPLY_NO,REPLY_CONTENTS,ENROLL_DATE,USER_ID,REVIEW_NO,NICK FROM SHOW_REVIEW_REPLY JOIN MEMBER USING(USER_ID) WHERE REVIEW_NO = ?) WHERE NUM BETWEEN ? AND ?";
			break;
		}
		
		int recordCountPerPage = 5;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, showNo);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			if (rset != null) {
				replyList = new ArrayList<Reply>();
				while(rset.next()) {
					Reply reply = new Reply();
					reply.setNo(rset.getInt("REVIEW_NO"));
					reply.setReplyNo(rset.getInt("REPLY_NO"));
					reply.setContents(rset.getString("REPLY_CONTENTS"));
					reply.setEnrollDate(rset.getDate("ENROLL_DATE"));
					reply.setUserId(rset.getString("USER_ID"));
					reply.setNick(rset.getString("NICK"));
					replyList.add(reply);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return replyList;
	}

	public int insertReply(Connection conn, Reply reply) { // 댓글 등록
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "";
		String type = reply.getReplyType();
		switch (type) {
		case "book":
			
			break;
		case "share":
			
			break;
		case "movie":
			
			break;
		case "show":
			query = "INSERT INTO SHOW_REVIEW_REPLY VALUES(SEQ_SHOW_REPLY_NO.NEXTVAL,?,SYSDATE,?,?) ";
			break;
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reply.getContents());
			pstmt.setString(2, reply.getUserId());
			pstmt.setInt(3, reply.getNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int updateReply(Connection conn, Reply reply) {  // 댓글 수정 
		return 0;
	}

	public int deleteReply(Connection conn, int replyNo) { // 댓글 삭제
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM SHOW_REVIEW_REPLY WHERE REPLY_NO = ?";		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, replyNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}
	
	public String getPageNavi(Connection conn, int currentPage, String replyType,int showNo) { // 댓글 페이징
		int recordTotalCount = totalCount(conn, showNo);
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
			sb.append("<li><a href='/showReview/detail?no="+showNo+"&currentPage="+ (startNavi-1) + "'> 이전 </a></li>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(currentPage == i) {
				sb.append("<li class='active'><a href='/showReview/detail?no="+showNo+"&currentPage="+ i +"'>" + i + "</a></li>");
			}else {
				sb.append("<li><a href='/showReview/detail?no="+showNo+"&currentPage="+ i +"'>" + i + "</a></li>");
			}
		}
		if( needNext) {
			sb.append("<li><a href='/showReview/detail?no="+showNo+"&currentPage="+ (endNavi + 1) + "'> 다음 </a></li>");
		}
		return sb.toString();
	}
	
	public int totalCount(Connection conn, int showNo) { // 댓글 총 개수
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM SHOW_REVIEW_REPLY WHERE REVIEW_NO = "+showNo;
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

	public ArrayList<Reply> selectReplyList(Connection conn, int showNo) { // 댓글 ajax 용 출력

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Reply> replyList = null;
		String query  = "SELECT ROW_NUMBER() OVER(ORDER BY ENROLL_DATE ASC)AS NUM,REPLY_NO,REPLY_CONTENTS,ENROLL_DATE,USER_ID,REVIEW_NO,NICK FROM SHOW_REVIEW_REPLY JOIN MEMBER USING(USER_ID) WHERE REVIEW_NO = ?";
			
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, showNo);
			rset = pstmt.executeQuery();
			if (rset != null) {
				replyList = new ArrayList<Reply>();
				while(rset.next()) {
					Reply reply = new Reply();
					reply.setNo(rset.getInt("REVIEW_NO"));
					reply.setReplyNo(rset.getInt("REPLY_NO"));
					reply.setContents(rset.getString("REPLY_CONTENTS"));
					reply.setEnrollDate(rset.getDate("ENROLL_DATE"));
					reply.setUserId(rset.getString("USER_ID"));
					reply.setNick(rset.getString("NICK"));
					replyList.add(reply);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return replyList;
	}

	// BookReview 시작
	public int insertReplyBookReview(Connection conn, Reply reply) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO BOOK_REVIEW_REPLY VALUES(SEQ_BOOK_REVIEW_REPLY.NEXTVAL,?,SYSDATE,?,?) ";
		String type = reply.getReplyType();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reply.getContents());
			pstmt.setString(2, reply.getUserId());
			pstmt.setInt(3, reply.getNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteReplyBookReview(Connection conn, int replyNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM BOOK_REVIEW_REPLY WHERE NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, replyNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int totalCountBookReview(Connection conn, int reviewNo) { // 댓글 수
		Statement stmt = null;
		ResultSet rset = null;
		System.out.println("totalcount reviewNo DAO" + reviewNo);
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM BOOK_REVIEW_REPLY WHERE NO = "+reviewNo;
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

	public ArrayList<Reply> selectReplyListBookReview(Connection conn, int reviewNo) {

			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<Reply> replyList = null;
			System.out.println("DAO, reviewNo" + reviewNo);
			String query  = "SELECT ROW_NUMBER() OVER(ORDER BY ENROLL_DATE DESC)AS NUM,REPLY_NO,REPLY_CONTENTS,ENROLL_DATE,USER_ID,NO,NICK FROM BOOK_REVIEW_REPLY JOIN MEMBER USING(USER_ID) WHERE NO = ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, reviewNo);
				rset = pstmt.executeQuery();
				if (rset != null) {
					replyList = new ArrayList<Reply>();
					while(rset.next()) {
						Reply reply = new Reply();
						reply.setNo(rset.getInt("NO"));
						reply.setReplyNo(rset.getInt("REPLY_NO"));
						reply.setContents(rset.getString("REPLY_CONTENTS"));
						reply.setEnrollDate(rset.getDate("ENROLL_DATE"));
						reply.setUserId(rset.getString("USER_ID"));
						reply.setNick(rset.getString("NICK"));
						replyList.add(reply);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			System.out.println("DAO에서 replayList : "+replyList);
			return replyList;
		}

	public ArrayList<Reply> selecAllReplyList(Connection conn,int currentPage, String userId) { // 댓글모아보기
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query ="SELECT * FROM(SELECT ROW_NUMBER() OVER(ORDER BY ENROLL_DATE DESC)AS NUM, TYPE,REPLY_NO,REPLY_CONTENTS,ENROLL_DATE,USER_ID,NO FROM (SELECT '독서혜윰'AS TYPE,REPLY_NO,REPLY_CONTENTS,ENROLL_DATE,USER_ID,NO FROM BOOK_REVIEW_REPLY WHERE USER_ID=? UNION ALL SELECT '나눔혜윰'AS TYPE,REPLY_NO,REPLY_CONTENTS,ENROLL_DATE,USER_ID,SHARE_NO FROM BOOK_SHARE_REPLY WHERE USER_ID=? UNION ALL SELECT '감상혜윰'AS TYPE,REPLY_NO,REPLY_CONTENTS,ENROLL_DATE,USER_ID,NO FROM MOVIE_RECOMMEND_REPLY WHERE USER_ID=? UNION ALL SELECT '관람혜윰'AS TYPE, REPLY_NO,REPLY_CONTENTS,ENROLL_DATE,USER_ID,REVIEW_NO FROM SHOW_REVIEW_REPLY WHERE USER_ID=? ))WHERE NUM BETWEEN ? AND ?";
		ArrayList<Reply> rList = null;
		int recordCountPerPage = 10;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userId);
			pstmt.setString(3, userId);
			pstmt.setString(4, userId);
			pstmt.setInt(5, start);
			pstmt.setInt(6, end);
			rset = pstmt.executeQuery();
			if(rset != null) {
				rList = new ArrayList<Reply>();
				while(rset.next()) {
					Reply reply = new Reply();
					reply.setNum(rset.getInt("NUM"));
					reply.setNo(rset.getInt("NO"));
					reply.setReplyNo(rset.getInt("REPLY_NO"));
					reply.setReplyType(rset.getString("TYPE"));
					reply.setContents(rset.getString("REPLY_CONTENTS"));
					reply.setUserId(rset.getString("USER_ID"));
					reply.setEnrollDate(rset.getDate("ENROLL_DATE"));
					rList.add(reply);
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		// TODO Auto-generated method stub
		System.out.println("dao :" + rList);
		return rList;
	}
	
	public String getAllPageNavi(Connection conn, int currentPage, String userId) { // 댓글모아보기 페이징
		int recordTotalCount = totalAllCount(conn, userId);
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
			sb.append("<li><a href='/myReply?currentPage="+ (startNavi-1) + "'> 이전 </a></li>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(currentPage == i) {
				sb.append("<li class='active'><a href='/myReply?&currentPage="+ i +"'>" + i + "</a></li>");
			}else {
				sb.append("<li><a href='/myReply?currentPage="+ i +"'>" + i + "</a></li>");
			}
		}
		if( needNext) {
			sb.append("<li><a href='/myReply?currentPage="+ (endNavi + 1) + "'> 다음 </a></li>");
		}
		System.out.println("페이징"+sb.toString());
		return sb.toString();
	}

	
	public int totalAllCount(Connection conn, String userId) { // 댓글 모아보기 총 개수
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*)AS TOTALCOUNT FROM (SELECT 'BR'AS TYPE,REPLY_NO,REPLY_CONTENTS,ENROLL_DATE,USER_ID,NO FROM BOOK_REVIEW_REPLY WHERE USER_ID=? UNION ALL SELECT 'BS'AS TYPE,REPLY_NO,REPLY_CONTENTS,ENROLL_DATE,USER_ID,SHARE_NO FROM BOOK_SHARE_REPLY WHERE USER_ID=? UNION ALL SELECT 'MR'AS TYPE,REPLY_NO,REPLY_CONTENTS,ENROLL_DATE,USER_ID,NO FROM MOVIE_RECOMMEND_REPLY WHERE USER_ID=? UNION ALL SELECT 'SR'AS TYPE, REPLY_NO,REPLY_CONTENTS,ENROLL_DATE,USER_ID,REVIEW_NO FROM SHOW_REVIEW_REPLY WHERE USER_ID=?)";
		int recordTotalCount = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userId);
			pstmt.setString(3, userId);
			pstmt.setString(4, userId);
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
		System.out.println("count :" + recordTotalCount);
		return recordTotalCount;
	}
	// BookShare
	public int insertReplyBookShare(Connection conn, Reply reply) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO BOOK_SHARE_REPLY VALUES(SEQ_BOOK_SHARE_REPLY.NEXTVAL,?,SYSDATE,?,?) ";
		//String type = reply.getReplyType();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reply.getContents());
			pstmt.setString(2, reply.getUserId());
			pstmt.setInt(3, reply.getNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Reply> selectReplyListBookShare(Connection conn, int shareNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Reply> replyList = null;
		System.out.println("DAO, shareNo" + shareNo);
		String query  = "SELECT ROW_NUMBER() OVER(ORDER BY ENROLL_DATE DESC)AS NUM,REPLY_NO,REPLY_CONTENTS,ENROLL_DATE,USER_ID,SHARE_NO,NICK FROM BOOK_SHARE_REPLY JOIN MEMBER USING(USER_ID) WHERE SHARE_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, shareNo);
			rset = pstmt.executeQuery();
			if (rset != null) {
				replyList = new ArrayList<Reply>();
				while(rset.next()) {
					Reply reply = new Reply();
					reply.setNo(rset.getInt("SHARE_NO"));
					reply.setReplyNo(rset.getInt("REPLY_NO"));
					reply.setContents(rset.getString("REPLY_CONTENTS"));
					reply.setEnrollDate(rset.getDate("ENROLL_DATE"));
					reply.setUserId(rset.getString("USER_ID"));
					reply.setNick(rset.getString("NICK"));
					replyList.add(reply);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("DAO에서 share replyList : "+replyList);
		return replyList;
	}

	public int totalCountBookShare(Connection conn, int shareNo) {
		Statement stmt = null;
		ResultSet rset = null;
		System.out.println("totalcount shareNo DAO" + shareNo);
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM BOOK_SHARE_REPLY WHERE SHARE_NO = "+shareNo;
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

}
