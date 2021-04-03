package qna.model.vo;

import java.sql.Date;


public class QnA { // 1:1 문의
	private String nick; // 작성자 닉네임
	private String title; // 제목
	private String qnaPassword; // 비밀번호
	private String category; // 분류
	private String contents; // 내용
	private String fileName; // 첨부파일
	private int hits; // 조회수
	private Date enrollDate; // 작성일
	
	public QnA() {
		// TODO Auto-generated constructor stub
	}
}
