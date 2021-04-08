package notice.model.vo;

import java.sql.Date;

public class Notice  { // 공지사항

	public int NoticeNo; // 글번호
	public String title; // 제목
	public String contents; // 내용
	public Date enrollDate; // 작성일자
	public int hits; // 조회수
	public String userId; // 작성자(관리자)
	
	public Notice() {}

	public int getNoticeNo() {
		return NoticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		NoticeNo = noticeNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Notice [NoticeNo=" + NoticeNo + ", title=" + title + ", contents=" + contents + ", enrollDate="
				+ enrollDate + ", hits=" + hits + ", userId=" + userId + "]";
	}
	
}
