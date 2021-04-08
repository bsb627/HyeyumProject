package book.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import book.model.dao.BookDAO;
import book.model.vo.BookInfo;
import book.model.vo.BookPageData;
import book.model.vo.BookReview;
import book.model.vo.BookShare;
import common.JDBCTemplate;


public class BookService {

	private JDBCTemplate factory;
	
	public BookService() {
		factory = JDBCTemplate.getConnection();
	}
	
	// BookInfo
	public BookPageData printAllBookInfo(int currentPage) { // 책정보 목록+페이징
		Connection conn = null;
		BookPageData pd = new BookPageData();
		try {
			conn = factory.createConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public BookInfo printOneBookInfo(int infoNo) { // 책정보 상세보기
		BookInfo info = null;
		return info;
	}
	public int modifyBookInfo(BookInfo bookInfo) { // 책정보 수정
		int result = 0;
		return result;
	}
	public int registerBookInfo(BookInfo bookInfo) { //책정보 등록
		int result = 0;
		return result;
	}
	public int deleteBookInfo(int infoNo) { //책정보 삭제
		int result = 0;
		return result ;
	}

	// BookReview
	public BookPageData printAllBookReview(int currentPage) { // 책리뷰 목록 + 페이징
		Connection conn = null;
		BookPageData pd = new BookPageData();
		
		try {
			conn = factory.createConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	public BookReview printOneBookReview(int reviewNo) {//책리뷰 상세보기
		BookReview review = null;
				
		return review;
	}
	public int modifyBookReview(BookReview review) { //책리뷰 수정
		int result = 0;
		return result;
	}
	public int registerBookReview(BookReview review) { //책리뷰 등록
		int result = 0;
		return result;
	}
	public int deleteBookReview(int reviewNo) { //책리뷰 삭제
		int result = 0;
		return result ;
	}
	
	public BookPageData seachPrintAllBookReview(int currentPage, String search, String searchCategory) { // 책리뷰 검색결과
		Connection conn = null;
		BookPageData pd = new BookPageData();
		
		try {
			conn = factory.createConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public int BookReviewHits(int reviewNo) {// 조회수 증가
		int result=0;
		return result;
	}
	public int BookReviewPlusLikes(String userId, int reviewNo) {
		int result = 0;
		return result;
	}
	public int BookReviewMinusLikes(String userId, int reviewNo) {
		int result = 0;
		return result;
	}
	
	// BookShare
	public BookPageData printAllBookShare(int currentPage) {// 책나눔 목록 + 페이징
		Connection conn = null;
		BookPageData pd = new BookPageData();
		
		try {
			conn = factory.createConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public BookShare printOneBookShare(int shareNo) { // 책나눔 상세보기
		BookShare share = null;
		return share;
	}
	public int registerBookShare(BookShare share) { // 책나눔 등록
		int result = 0;
		return result;
	}
	public int modifyBookShare(BookShare share) { //책나눔 수정
		int result = 0;
		return result;
	}
	public int deleteBookShare(int shareNo) { // 책나눔 삭제
		int result = 0;
		return result ;
	}
	public BookPageData searchPrintAllBookReview(int currentPage, String search, String searchCategory) { //책리뷰 검색결과 전체보기  
		Connection conn = null;
		BookPageData pd = new BookPageData();
		
		try {
			conn = factory.createConnection();
			pd.setReviewList(new BookDAO().selectSearchReviewList(conn, currentPage, searchCategory));
			pd.setPageNavi(new BookDAO().getSearchReviewPageNavi(conn, currentPage, search, searchCategory));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	public int addHitsCount(int shareNo) { // 조회수 증가
		int result = 0;
		return result;
	}
	
	public int plusLikesCount(int shareNo, String userId) { // 좋아요수 증가
		int result = 0;
		return result;
	}
	
	public int minusLikesCount(int shareNo, String userId) { // 좋아요수 빼기
		int result = 0;
		return result;
	}
	
}
