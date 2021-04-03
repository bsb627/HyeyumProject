package book.model.vo;

import java.sql.Date;

public class ShareBook { // 나눔 게시판
	private String bookName; // 책이름
	private String region; // 지역
	private String title; // 제목
	private String fileName; // 파일이름
	private String userName; // 작성자
	private String contents; // 내용
	private Date enrollDate; // 작성일
	private int hits; // 조회수
	private int likes;// 좋아요
	

	public ShareBook() {
		// TODO Auto-generated constructor stub
	}
	
	
}
