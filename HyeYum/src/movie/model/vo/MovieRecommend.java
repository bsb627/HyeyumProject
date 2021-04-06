package movie.model.vo;

import java.sql.Date;

public class MovieRecommend { // 영화 추천 게시판
	private int no; // 글번호 
	private String title; // 제목
	private String genre; // 장르
	private String nick; // 닉네임
	private String contents; // 내용
	private String fileName; // 파일명
	private int hits; // 조회수
	private int pick;// 좋아요
	private Date enrollDate; // 작성일
	
	
	public MovieRecommend() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
