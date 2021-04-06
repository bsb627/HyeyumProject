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
	
	public BookInfo printShowInfo() {
		BookInfo info = null;
		return info;
	}
	public int modifyBookInfo() {
		int result = 0;
		return result;
	}
	public BookInfo insertShowInfo() {
		BookInfo info = null;
		return info;
	}
	public int deleteBookInfo() {
		int result = 0;
		return result ;
	}
	
	
	public BookReview printBookReview() {
		BookReview review = null;
		return review;
	}
	
	public int modifyBookReview() {
		int result = 0;
		return result;
	}
	
	public BookReview insertBookReview() {
		
		BookReview review = null;
		
		return review;
	}
	
	public int deleteBookReview() {
		int result = 0;
		return result ;
	}
	
	
	public BookShare printBookShare() {
		BookShare review = null;
		return review;
	}
	
	public int modifyBookShare() {
		int result = 0;
		return result;
	}
	
	public BookShare insertBookShare() {
		
		BookShare share = null;
		
		return share;
	}
	
	public int deleteBookShare() {
		int result = 0;
		return result ;
	}
}
