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
		String query = "SELECT * FROM BOOKINFO";
				
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
		String query = "SELECT * FROM BOOKINFO WHERE INFONO = ?";
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
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<BookReview> bList = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY BOOKREVIEW_NO DESC) AS NUM, BOOKREVIEW_NO, DIVISION, TITLE, ENROLL_DATE, HITS, LIKES";
				
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			bList = new ArrayList<BookReview>();
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
	public BookReview selectOneBookReview(Connection conn, int reviewNo) { //책리뷰 상세보기
		
		return null;
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
		return null;
	}
	public int totalReviewCount(Connection conn) { //책리뷰 총 게시글 수
		return 0;
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
