package answer.model.vo;

import java.sql.Date;

public class Answer {
	
	private String userId; //관리자 아이디
	private int answerNo; //답글번호
	private String title; //제목
	private String contents; //내용
	private int hits; //조회수
	private Date enrollDate; //작성일자

}
