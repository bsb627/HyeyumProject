package notice.model.vo;

import java.sql.Date;

public class Notice { // 공지

	private int noticeNo; // 글번호
	private String title; // 제목
	private String userId; // 사용자(관리자)
	private String contents; // 내용
	private Date enrollDate; // 작성일자
	private int hits; // 조회수
}
