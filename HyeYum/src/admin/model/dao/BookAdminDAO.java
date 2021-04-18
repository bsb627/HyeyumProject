package admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import book.model.vo.BookInfo;
import book.model.vo.BookReview;
import common.JDBCTemplate;
import show.model.vo.ShowInfo;
import show.model.vo.ShowReview;

public class BookAdminDAO {

	public ArrayList<BookInfo> selectAllBookInfoList(Connection conn) { 

		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM BOOK_INFO ORDER BY INFO_NO ASC";
		ArrayList<BookInfo> bList = null;
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset != null) {
				bList = new ArrayList<BookInfo>();
				while (rset.next()) {
					BookInfo info = new BookInfo();
					info.setInfoNo(rset.getInt("INFO_NO"));
					info.setBookName(rset.getString("BOOK_NAME"));
					info.setGenre(rset.getString("GENRE"));
					info.setAuthor(rset.getString("AUTHOR"));
					info.setPublisher(rset.getString("PUBLISHER"));
					info.setIntro(rset.getString("INTRO"));
					info.setEnrollDate(rset.getDate("ENROLL_DATE"));
					bList.add(info);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return bList;
	}
	public BookInfo selectOneBookInfo(Connection conn, int infoNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		String query ="SELECT * FROM BOOK_INFO WHERE INFO_NO = ?";
		BookInfo info = new BookInfo();
		System.out.println("DAO, infoNo : " + infoNo);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, infoNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				info.setInfoNo(rset.getInt("INFO_NO"));
				info.setBookName(rset.getString("BOOK_NAME"));
				info.setGenre(rset.getString("GENRE"));
				info.setAuthor(rset.getString("AUTHOR"));
				info.setPublisher(rset.getString("PUBLISHER"));
				info.setIntro(rset.getString("INTRO"));
				info.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("DAO, rset : " + rset );
		return info;
	}

	public int insertBookInfo(Connection conn, BookInfo info) {  
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO BOOK_INFO VALUES(SEQ_BOOK_INFO.NEXTVAL,?,?,?,?,?,SYSDATE)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, info.getBookName());
			pstmt.setString(2, info.getGenre());
			pstmt.setString(3, info.getAuthor());
			pstmt.setString(4, info.getPublisher());
			pstmt.setString(5, info.getIntro());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int updateBookInfo(Connection conn, BookInfo info) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE BOOK_INFO SET BOOK_NAME = ?, GENRE = ?, AUTHOR = ?, PUBLISHER = ?, INTRO = ?, ENROLL_DATE = SYSDATE WHERE INFO_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, info.getBookName());
			pstmt.setString(2, info.getGenre());
			pstmt.setString(3, info.getAuthor());
			pstmt.setString(4, info.getPublisher());
			pstmt.setString(5, info.getIntro());
			pstmt.setInt(6, info.getInfoNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		System.out.println("DAO info : " + info);
		System.out.println("DAO result :" + result);
		return result ;
	}


	public int deleteBookInfo(Connection conn, String infoNo) {
		Statement stmt = null;
		int result = 0;
		String query = "DELETE FROM BOOK_INFO WHERE INFO_NO IN ("+infoNo+")";
		
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
	// BookReview
	public ArrayList<BookReview> selectAllBookReviewList(Connection conn) {

		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM BOOK_REVIEW ORDER BY INFO_NO ASC";
		ArrayList<BookReview> rList = null;
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset != null) {
				rList = new ArrayList<BookReview>();
				while (rset.next()) {
					BookReview review = new BookReview();
					review.setNo(rset.getInt("REVIEW_NO"));
					review.setDivision(rset.getString("DIVISION"));
					review.setTitle(rset.getString("TITLE"));
					review.setContents(rset.getString("CONTENTS"));
					review.setGenre(rset.getString("GENRE"));
					review.setInfoNo(rset.getInt("INFO_NO"));
					review.setUserId(rset.getString("USER_ID"));
					review.setHits(rset.getInt("HITS"));
					review.setEnrollDate(rset.getDate("ENROLL_DATE"));
					rList.add(review);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return rList;
	}
	public int deleteBookReview(Connection conn, String reviewNo) {
		Statement stmt = null;
		int result = 0;
		String query = "DELETE FROM BOOK_REVIEW WHERE REVIEW_NO IN ("+reviewNo+")";
		
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


//	public ArrayList<ShowReview> selectAllShowReviewList(Connection conn) {  // 관리자 공연 리뷰 리스트 출력
//
//		Statement stmt = null;
//		ResultSet rset = null;
//		String query = "SELECT REVIEW_NO, TITLE, CONTENTS, NICK, USER_ID, HITS, SNS_LINK, TICKET_NUMBER, INFO_NO, ENROLL_DATE FROM SHOW_REVIEW JOIN MEMBER USING (USER_ID) ORDER BY ENROLL_DATE";
//		ArrayList<ShowReview> rList = null;
//		
//		try {
//			stmt = conn.createStatement();
//			rset = stmt.executeQuery(query);
//			if(rset != null) {
//				rList = new ArrayList<ShowReview>();
//				while (rset.next()) {
//					ShowReview review = new ShowReview();
//					review.setNo(rset.getInt("REVIEW_NO"));
//					review.setTitle(rset.getString("TITLE"));
//					review.setContents(rset.getString("CONTENTS"));
//					review.setNick(rset.getString("NICK"));
//					review.setUserId(rset.getString("USER_ID"));
//					review.setHits(rset.getInt("HITS"));
//					review.setSnsLink(rset.getString("SNS_LINK"));
//					review.setTicketNumber(rset.getString("TICKET_NUMBER"));
//					review.setInfoNo(rset.getInt("INFO_NO"));
//					review.setEnrollDate(rset.getDate("ENROLL_DATE"));
//					rList.add(review);
//				}
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(rset);
//			JDBCTemplate.close(stmt);
//		}
//		
//		return rList;
//	}
//
//	public int deleteShowReview(Connection conn, String reviewNo) {
//		Statement stmt = null;
//		int result = 0;
//		String query = "DELETE FROM SHOW_REVIEW WHERE REVIEW_NO IN ("+reviewNo+")";
//		
//		try {
//			stmt = conn.createStatement();
//			result = stmt.executeUpdate(query);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(stmt);
//		}
//		
//		return result;
//	}


}
