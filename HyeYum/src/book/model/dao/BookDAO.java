package book.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import book.model.vo.BookInfo;
import book.model.vo.BookReview;
import book.model.vo.BookShare;

public class BookDAO {
	//BookInfo
	public ArrayList<BookInfo> selectAllBookInfo(Connection conn, int currentPage){ // 책정보 전체보기
		return null;
	}
	public BookInfo selectOneBookInfo(Connection conn, int showNo) { // 책정보 상세보기
		
		return null;
	}
	public int insertBookInfo(Connection conn, BookInfo bookInfo) { // 책정보 등록
		return 0;
	}
	public int updateBookInfo(Connection conn, BookInfo bookInfo) { // 책정보 수정
		return 0;
	}
	public int deleteBookInfo(Connection conn, int BookNo) { // 책정보 삭제
		return 0;
	}
	
	// BookReview
	public ArrayList<BookReview> selectAllBookReview(Connection conn, int currentPage){ // 책리뷰 전체보기
		return null;
	}
	public BookReview selectOneBookReview(Connection conn, int showNo) { //책리뷰 상세보기
		
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
	public int updateHitsReview(Connection conn, int bookNo) { //  게시글 조회수 증가
		return 0;
	}
	public int insertLikesReview(Connection conn, int bookNo, String userId) { // 게시글 좋아요 등록
		return 0;
	}
	public int updateLikesReview(Connection conn, int showNo, String userId) { // 좋아요 취소
		return 0;
	}
	// BookShare
	public ArrayList<BookShare> selectAllBookShare(Connection conn, int currentPage){ // 책나눔 전체보기
		
		return null;
	}
	public BookShare selectOneBookShare(Connection conn, int showNo) { // 책나눔 상세보기
		
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
	public int insertLikesReview(Connection conn, int shareNo) { // 좋아요 등록
		return 0;
	}
	public int updateLikesShare(Connection conn, int shareNo, String userId) { //좋아요 취소
		return 0;
	}
}
