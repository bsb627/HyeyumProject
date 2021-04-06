package book.model.vo;

import board.model.vo.Board;

public class BookShare extends Board{ // 나눔 게시판
	private String bookName; // 책이름
	private String region; // 지역
	private String fileName; // 파일이름

	public BookShare() {
		// TODO Auto-generated constructor stub
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
		return "ShowReview [no=" + super.no + ", title=" + super.title + ", contents=" + super.contents +", nick=" + super.nick + ", hits=" + super.hits+" likes=" + super.likes + ", enrollDate=" + super.enrollDate + "bookName=" + this.bookName + ", region=" + this.region + ", fileName=" + this.fileName + "]";
	}
	
	
	
	
}
