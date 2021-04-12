package book.model.vo;

import board.model.vo.Board;

public class BookReview extends Board{ // 도서 리뷰 게시판
	private String bookName; // 책이름
	private String division; // 분류
	private String genre;// 장르
	private int infoNo;// 도서번호
	
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
	
	public int getInfoNo() {
		return infoNo;
	}

	public void setInfoNo(int infoNo) {
		this.infoNo = infoNo;
	}

	@Override
	public String toString() {
		return "BookReview [bookName=" + bookName + ", division=" + division + ", genre=" + genre + ", infoNo=" + infoNo
				+ "]";
	}

}
