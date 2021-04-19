package member.model.vo;

import java.sql.Date;

public class MyPost {

	private String title;  // 제목
	private Date enrollDate; // 등록일
	private int hits; // 조회수
	private String contents; // 내용
	private String boardName; // 게시판 이름
	
	// getter/setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	@Override
	public String toString() {
		return "MyPost [title=" + title + ", enrollDate=" + enrollDate + ", hits=" + hits + ", contents=" + contents
				+ ", boardName=" + boardName + "]";
	}
	
}