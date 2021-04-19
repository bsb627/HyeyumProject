package reply.model.vo;

import java.sql.Date;

public class Reply {
	private int no; // 글번호
	private int replyNo; // 댓글번호
	private int num; // 로우넘버
	private String contents; // 내용
	private String userId; // 작성자
	private String nick; // 닉네임
	private String replyType; // 게시판타입
	private Date enrollDate; // 작성일
	
	public Reply() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getReplyType() {
		return replyType;
	}

	public void setReplyType(String replyType) {
		this.replyType = replyType;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Reply [no=" + no + ", replyNo=" + replyNo + ", contents=" + contents + ", userId=" + userId
				+ ", replyType=" + replyType + ", enrollDate=" + enrollDate + "]";
	}
	
	

}
