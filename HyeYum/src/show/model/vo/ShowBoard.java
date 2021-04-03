package show.model.vo;

import java.sql.Date;

public class ShowBoard { // 공연 게시판
	private String title;// 제목
	private String userName;// 작성자
	private String contents; // 내용
	private String fileName; // 이미지파일
	private int hits;// 조회수 
	private int likes; // 좋아요
	private String snsLink; // sns링크주소
	private String ticketNumber; // 예매 일련 번호
	private Date enrollDate;  // 작성일

	public ShowBoard() {
		// TODO Auto-generated constructor stub
	}
	
}
