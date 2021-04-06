package board.model.vo;

import java.sql.Date;

public class Board {
	protected int no; // 글번호
	protected String title; //제목
	protected String contents; // 내용
	protected String nick; // 작성자
	protected int hits; // 조회 수
	protected int likes; // 좋아요 수
	protected Date enrollDate; // 작성일
	
	public Board() {
		// TODO Auto-generated constructor stub
	}
}
