package show.model.vo;

import java.sql.Date;

public class ShowReview { // 공연 후기 게시판
	private int no; // 글번호
	private String nick;// 닉네임
	private String title;// 제목
	private String contents; // 내용
	private String snsLink; // sns링크주소
	private int hits;// 조회수 
	private int likes; // 좋아요
	private String fileName; // 이미지파일
	private String ticketNumber; // 예매 일련 번호
	private Date enrollDate;  // 작성일

	
	
}
