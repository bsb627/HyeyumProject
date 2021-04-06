package book.model.vo;

import board.model.vo.Board;

public class BookShare extends Board{ // 나눔 게시판
	private String bookNo; // 글 번호
	private String bookName; // 책이름
	private String region; // 지역
	private String fileName; // 파일이름

	public BookShare() {
		// TODO Auto-generated constructor stub
	}
	
	// constructor
	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "BookShare [bookNo=" + bookNo + ", bookName=" + bookName + ", region=" + region + ", fileName="
				+ fileName + "]";
	}
	
}
