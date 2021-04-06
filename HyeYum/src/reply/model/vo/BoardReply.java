package reply.model.vo;

import java.sql.Date;

public class BoardReply {
	protected int no; // 글번호
	protected int replyNo; // 댓글번호
	protected String contents; // 내용
	protected String userId; // 작성자
	protected Date enrollDate; // 작성일
	
	public BoardReply() {
		// TODO Auto-generated constructor stub
	}
}
