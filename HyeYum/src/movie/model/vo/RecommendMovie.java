package movie.model.vo;

import java.sql.Date;

public class RecommendMovie { // 영화 추천 게시판
	private String movieTitle; // 영화제목
	private String genre; // 장르
	private String userName; // 작성자
	private String contents; // 내용
	private String fileName; // 파일이름
	private int hits; // 조회수
	private int pick;// 좋아요
	private Date enrollDate; // 작성일
	
	
	public RecommendMovie() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
