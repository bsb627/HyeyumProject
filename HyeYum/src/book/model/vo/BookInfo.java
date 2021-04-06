package book.model.vo;

import java.sql.Date;

public class BookInfo { // 이달의 도서
	private int InfoNo; // 번호
	private String bookName; // 책이름
	private String genre; // 분류
	private String author; // 작가
	private String fileName; // 이미지
	private String publisher; // 출판사
	private String intro; // 내용
	private Date enrollDate; // 등록일
	
	public BookInfo() {
		// TODO Auto-generated constructor stub
	}

	public int getInfoNo() {
		return InfoNo;
	}

	public void setInfoNo(int infoNo) {
		InfoNo = infoNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "BookInfo [InfoNo=" + InfoNo + ", bookName=" + bookName + ", genre=" + genre + ", author=" + author
				+ ", fileName=" + fileName + ", publisher=" + publisher + ", intro=" + intro + ", enrollDate="
				+ enrollDate + "]";
	}
	
}
