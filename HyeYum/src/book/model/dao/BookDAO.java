package book.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import book.model.vo.BookInfo;
import book.model.vo.BookReview;
import book.model.vo.BookShare;
import common.JDBCTemplate;

public class BookDAO {
	//BookInfo
	public ArrayList<BookInfo> selectAllBookInfo(Connection conn){ // 책정보 전체보기
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<BookInfo>bList = null;
		String query = "SELECT A.BOOKNO, A.TITLE, A.NICK, A.REGDATE, A.HITS, A.LIKES FROM (SELECT BOOKNO, TITLE, NICK, REGDATE, HITS, LIKES ORDER BY REGDATE) A WHERE ROWNUM BETWEEN ? AND ?";
				
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			bList = new ArrayList<BookInfo>();
			while(rset.next()) {
				
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
	public BookInfo selectOneBookInfo(Connection conn, int infoNo) { // 책정보 상세보기
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT A.BOOKNO, A.TITLE, A.NICK, A.REGDATE, A.HITS, A.LIKES FROM (SELECT BOOKNO, TITLE, NICK, REGDATE, HITS, LIKES ORDER BY REGDATE) A WHERE ROWNUM BETWEEN ? AND ?";
		BookInfo info = null;
		
		return info;
	}
	public int insertBookInfo(Connection conn, BookInfo bookInfo) { // 책정보 등록
		PreparedStatement pstmt = null;
		int result = 0;
		String query ="";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, bookInfo.getInfoNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int updateBookInfo(Connection conn, BookInfo bookInfo) { // 책정보 수정
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setLong(1,  bookInfo.getInfoNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int deleteBookInfo(Connection conn, int BookNo) { // 책정보 삭제
		PreparedStatement pstmt = null;
		int result = 0;
		return result;
	}
	
	// BookReview
	public ArrayList<BookReview> selectAllBookReview(Connection conn, int currentPage){ // 책리뷰 전체보기
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BookReview> bList = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY ENROLL_DATE DESC) AS NUM, REVIEW_NO, DIVISION, TITLE, NICK, ENROLL_DATE, HITS FROM BOOK_REVIEW JOIN MEMBER USING(USER_ID))WHERE NUM BETWEEN ? AND ?";
		int recordCountPerPage = 10;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,  start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			bList = new ArrayList<BookReview>();
			while(rset.next()) {
				BookReview review = new BookReview();
				review.setNo(rset.getInt("REVIEW_NO"));
				review.setDivision(rset.getString("DIVISION"));
				review.setTitle(rset.getString("TITLE"));
				review.setNick(rset.getString("NICK"));
				review.setEnrollDate(rset.getDate("ENROLL_DATE"));
				review.setHits(rset.getInt("HITS"));
				bList.add(review);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("DAO list" + bList);
		return bList;
	}
	public BookReview selectOneBookReview(Connection conn, int reviewNo) { //책리뷰 상세보기
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BookReview review = null;
		String query = "SELECT DIVISION, REVIEW_NO, TITLE, CONTENTS, ENROLL_DATE, HITS, NICK FROM BOOK_REVIEW JOIN MEMBER USING(USER_ID)WHERE REVIEW_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				review = new BookReview();
				review.setNo(rset.getInt("REVIEW_NO"));
				review.setDivision(rset.getString("DIVISION"));
				review.setTitle(rset.getString("TITLE"));
				review.setNick(rset.getString("NICK"));
				review.setContents(rset.getString("CONTENTS"));
				review.setEnrollDate(rset.getDate("ENROLL_DATE"));
				review.setHits(rset.getInt("HITS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return review;
	}
	public int insertBookReview(Connection conn, BookReview review) { // 책리뷰 등록
		return 0;
	}
	public int updateBookReview(Connection conn, BookReview review) { // 책리뷰 수정
		return 0;
	}
	public int deleteBookReview(Connection conn, int reviewNo) { // 책리뷰 삭제
		return 0;
	}
	public String getReviewPageNavi(Connection conn, int currentPage) { // 책리뷰 페이징
		int recordTotalCount = totalReviewCount(conn);
		int recordCountPerPage = 10;
		// 10개로 안떨어지는 상황 떄문에 추가로 변수 선언
		int pageTotalCount = 0;
		if ( recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		// 오류방지코드
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int naviCountPerPage = 10;
		int startNavi = ((currentPage -1)/ naviCountPerPage) * naviCountPerPage + 1;
		
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount; 
		}
		
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) { // 맨 처음 페이지
			needPrev = false;
		}
		if(endNavi == pageTotalCount) { // 맨마지막 페이지
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if(needPrev) { 
			sb.append("<a href='/bookReview/list?currentPage="+ (startNavi-1)+"'> < </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			sb.append("<a href='/bookReview/list?currentPage=" + i + "'>" + i + " </a>"); // 버튼을 눌렀을 때 다음페이지로 넘어가도록 주소를 줌
		}
		if(needNext) {
			sb.append("<a href='/bookReview/list?currentPage=" + (endNavi+1)+ "'> > </a>");
		}
		return sb.toString();
	}
	public int totalReviewCount(Connection conn) { //책리뷰 총 게시글 수
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM BOOK_REVIEW";
		// 전체 게시물의 개수
		// AS 는 별칭을 준 것. 컬럼명이 있어야 필드값 가져올 수 있기 때문에
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
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return recordTotalCount;
	}
	public ArrayList<BookReview> selectSearchReviewList(Connection conn, int currentPage, String searchCategory){ // 책리뷰 검색결과 전체보기
		return null;
	}
	public String getSearchReviewPageNavi(Connection conn, int currentPage, String search, String searchCategory) { // 책리뷰 검색 페이징
		return null;
	}
	public int searchTotalReviewCount(Connection conn, String search, String searchCategory) { // 책리뷰 검색
		return 0;
	}
	public int updateHitsReview(Connection conn, int reviewNo) { //  게시글 조회수 증가
		return 0;
	}
	public int insertLikesReview(Connection conn, int reviewNo, String userId) { // 게시글 좋아요 등록
		return 0;
	}
	public int updateLikesReview(Connection conn, int reviewNo, String userId) { // 좋아요 취소
		return 0;
	}
	
	// BookShare
	public ArrayList<BookShare> selectAllBookShare(Connection conn, int currentPage){ // 책나눔 전체보기
		
		return null;
	}
	public BookShare selectOneBookShare(Connection conn, int shareNo) { // 책나눔 상세보기
		
		return null;
	}
	public int insertBookShare(Connection conn, BookShare share) { // 책나눔 등록
		
		return 0;
	}
	public int updateBookShare(Connection conn, BookShare share) { // 책나눔 수정
		
		return 0;
	}
	public int deleteBookShare(Connection conn, int shareNo) { // 책나눔 삭제
		
		return 0;
	}
	public String getSharePageNavi(Connection conn, int currentPage) { // 책나눔 페이징
		return null;
	}
	public int totalShareCount(Connection conn) { // 책나눔 총 게시글 수
		
		return 0;
	}
	public ArrayList<BookShare>selectSearchBookShare(Connection conn, int currentPage, String search, String searchCategory){
		
		return null;
	}
	public String getSearchSharePageNavi(Connection conn, int currentPage, String search, String searchCategory) { // 책나눔 검색 페이징
		
		return null;
	}
	public int searchTotalShareCount(Connection conn, String search, String searchCategory ) {
		return 0;
	}
	public int  updateHitsShare(Connection conn, int shareNo) { // 조회수
		return 0;
	}
	public int insertLikesShare(Connection conn, int shareNo) { // 좋아요 등록
		return 0;
	}
	public int updateLikesShare(Connection conn, int shareNo, String userId) { //좋아요 취소
		return 0;
	}
}
