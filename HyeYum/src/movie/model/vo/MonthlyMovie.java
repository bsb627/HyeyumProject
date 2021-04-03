package movie.model.vo;

import java.sql.Date;

public class MonthlyMovie { // 이달의 영화
	private String movieTitle;// 영화제목
	private String genre;// 장르
	private String cast; // 출연진
	private String director;// 감독
	private String ageGroup;// 관람등급
	private String runTime;	// 러닝타임
	private String synopsis; // 영화줄거리
	private String fileName; // 첨부파일명
	private Date enrollDate; // 등록일

	public MonthlyMovie() {
		// TODO Auto-generated constructor stub
	}
}
