package reply.model.vo;

import java.sql.Timestamp;

public class Reply {
	private int no; // 글번호
	private int replyNo; // 댓글번호
	private String contents; // 내용
	private String userId; // 작성자
	private String replyType; // 게시판타입
	private Timestamp enrollDate; // 작성일

}
