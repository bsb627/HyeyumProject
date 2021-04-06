package book.model.vo;

import board.model.vo.Board;

public class BookReview extends Board{ // 도서 리뷰 게시판
	private String bookName; // 책이름
	private String division; // 분류
	private String genre;// 장르
	
	// constructor
	public BookReview() {
		// TODO Auto-generated constructor stub
	}
	
	// getter/setter


	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "BookReview [title=" + super.title + ", contents=" + super.contents +", nick=" + super.nick + ", hits=" + super.hits+" likes=" + super.likes + ", enrollDate=" + super.enrollDate+ "bookName=" + this.bookName + ", division=" + this.division + ", genre=" + this.genre + 
				  "]";
	}

	
	
	
	
}
