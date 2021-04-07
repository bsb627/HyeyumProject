package book.model.service;

import book.model.vo.BookInfo;
import book.model.vo.BookReview;
import book.model.vo.BookShare;
import common.JDBCTemplate;
import show.model.vo.ShowInfo;


public class BookService {

	private JDBCTemplate factory;
	
	public BookService() {
		factory = JDBCTemplate.getConnection();
	}
	
	// BookInfo
	public BookInfo printAllBookInfo() {
		BookInfo info = null;
		return info;
	}
	public BookInfo printOneBookInfo() {
		
		return null;
	}
	public int modifyBookInfo() {
		int result = 0;
		return result;
	}
	public int registerBookInfo() {
		BookInfo info = null;
		return 0;
	}
	public int deleteBookInfo() {
		int result = 0;
		return result ;
	}
	public int BookInfoHits() {
		
		return 0;
	}
	public int BookInfoLikes() {
		
		return 0;
	}
	// BookReview
	public BookReview printAllBookReview() {
		BookReview review = null;
		return review;
	}
	public BookReview printOneBookReview() {
		
		return null;
	}
	public int modifyBookReview() {
		int result = 0;
		return result;
	}
	public int registerBookReview() {
		
		return 0;
	}
	public int deleteBookReview() {
		int result = 0;
		return result ;
	}
	public int BookReviewHits() {
		
		return 0;
	}
	public int BookReviewLikes() {
		
		return 0;
	}
	
	// BookShare
	public BookShare printAllBookShare() {
		BookShare review = null;
		return review;
	}
	public BookShare printOneBookShare() {
		return null;
	}
	public int registerBookShare() {

		return 0;
	}
	public int modifyBookShare() {
		int result = 0;
		return result;
	}
	public int deleteBookShare() {
		int result = 0;
		return result ;
	}
	// 조회수
	public int BookSharehits() {
		
		return 0;
	}
	// 좋아요
	public int BookSharelikes() {
		
		return 0;
	}
}
