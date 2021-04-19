package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import book.model.vo.BookReview;
import common.JDBCTemplate;
import member.model.vo.MyPost;
import message.model.vo.Message;
import movie.model.vo.MovieRecommend;
import movie.model.vo.MovieReview;
import qna.model.vo.Qna;
import show.model.vo.ShowReview;

public class MyPostDAO {
	
	// 받은 메시지 전체 갯수 
	private int totalCount(Connection conn, String userId) {
			Statement stmt = null;
			ResultSet rset = null;
			String query = "SELECT COUNT (*) AS TOTALCOUNT FROM BOOK_REVIEW B1, BOOK_SHARE B2, MOVIE_REVIEW M, SHOW_REVIEW S, QNA Q WHERE B1.USER_ID = B2.USER_ID AND B2.USER_ID = M.USER_ID AND M.USER_ID = S.USER_ID AND S.USER_ID = Q.USER_ID"; 
//					"SELECT COUNT(*) AS TOTALCOUNT FROM MESSAGERE WHERE RECEIVER = '" + userId +"'";
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
	
//	// BookReview 받은 메시지 전체 출력 
//	public ArrayList<MyPost> selectAllList(Connection conn, int currentPage, String userId) {
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		ArrayList<MyPost> mList = null;
//		String query = "SELECT *FROM (SELECT ROW_NUMBER() OVER (ORDER BY ENROLL_DATE DESC) AS NUM, TITLE, ENROLL_DATE, HITS FROM BOOK_REVIEW WHERE USER_ID = ? ) WHERE NUM BETWEEN ? AND ?";
//		
//		int recordCountPerPage = 10;
//		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
//		int end = currentPage*recordCountPerPage;
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1,userId);
//			pstmt.setInt(2, start);
//			pstmt.setInt(3, end);
//			rset = pstmt.executeQuery();
//			mList = new ArrayList<MyPost>();
//			while(rset.next()) {
//				MyPost post = new MyPost();
//				post.setTitle(rset.getString("TITLE"));
//				post.setEnrollDate(rset.getDate("ENROLL_DATE"));
//				post.setHits(rset.getInt("HITS"));
//				mList.add(post);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			JDBCTemplate.close(rset);
//			JDBCTemplate.close(pstmt);
//		}
//		
//		return mList;
//	}
	// BookReview
	public ArrayList<BookReview> selectAllBookReview(Connection conn, int currentPage, String userId) { // 내가 쓴 글
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BookReview> bList = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY ENROLL_DATE DESC) AS NUM, TITLE, ENROLL_DATE, HITS FROM BOOK_REVIEW WHERE USER_ID = ? )WHERE NUM BETWEEN ? AND ?";
		int recordCountPerPage = 10;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		System.out.println("UserId : " + userId);
		System.out.println("start : " + start);
		System.out.println("end : " + end);
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,  userId);
			pstmt.setInt(2,  start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			bList = new ArrayList<BookReview>();
			while(rset.next()) {
				BookReview review = new BookReview();
				review.setTitle(rset.getString("TITLE")); 	
				review.setEnrollDate(rset.getDate("ENROLL_DATE"));
				review.setHits(rset.getInt("HITS"));
				bList.add(review);
			}
			System.out.println("POST DAO, bList : " + bList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return bList;
	}
	// movieReview
	public ArrayList<MovieReview> selectAllMovieReview(Connection conn,int currentPage,String userId) { // 내가 쓴 영화리뷰 
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MovieReview> review = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY ENROLL_DATE DESC) AS NUM, CONTENTS, ENROLL_DATE, STAR_RATING FROM MOVIE_REVIEW WHERE USER_ID = ? ) WHERE NUM BETWEEN ? AND ?";
		int recordCountPerPage = 10;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			review = new ArrayList<MovieReview>();
			if (rset != null) {
				while(rset.next()) {
					MovieReview mReview = new MovieReview();
					mReview.setContents(rset.getString("CONTENTS"));
					mReview.setEnrollDate(rset.getDate("ENROLL_DATE"));
					mReview.setStarRating(rset.getInt("STAR_RATING"));
					review.add(mReview);
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return review;
	}
	// MovieRecommend
	public ArrayList<MovieRecommend> selectAllMovieRecommend(Connection conn, int currentPage, String userId) { // 내가 쓴 글
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MovieRecommend> recommend = null;
		//RECOMMEND_NO, GENRE, TITLE, CONTENTS, HITS, ENROLL_DATE, USER_ID
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY ENROLL_DATE DESC) AS NUM, TITLE, ENROLL_DATE, HITS FROM MOVIE_RECOMMEND WHERE USER_ID = ?) WHERE NUM BETWEEN ? AND ? ";
		int recordCountPerPage = 10;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			recommend = new ArrayList<MovieRecommend>();
			if (rset != null) {
				while(rset.next()) {
					MovieRecommend mRecommend = new MovieRecommend();
					mRecommend.setTitle(rset.getString("TITLE"));
					mRecommend.setEnrollDate(rset.getDate("ENROLL_DATE"));
					mRecommend.setHits(rset.getInt("HITS"));
					recommend.add(mRecommend);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally { 
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
			return recommend;
		}
	// showReview
	public ArrayList<ShowReview> selectAllReviewList(Connection conn, int currentPage, String userId) { // 내가 쓴 글 보기
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ShowReview> showList = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY ENROLL_DATE DESC)AS NUM,TITLE, ENROLL_DATE, HITS FROM SHOW_REVIEW WHERE USER_ID = ?) WHERE NUM BETWEEN ? AND ?";
		
		int recordCountPerPage = 8;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			if (rset != null) {
				showList = new ArrayList<ShowReview>();
				while(rset.next()) {
					ShowReview review = new ShowReview();
					review.setTitle(rset.getString("TITLE"));
					review.setEnrollDate(rset.getDate("ENROLL_DATE"));
					review.setHits(rset.getInt("HITS"));
					showList.add(review);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return showList;
	}
	
	
	
	// 받은 메시지 네비
	public String getPageNaviRe(Connection conn, int currentPage, String userId) {
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

	

}
