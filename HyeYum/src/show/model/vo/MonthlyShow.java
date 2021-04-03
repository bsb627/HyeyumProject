package show.model.vo;

import java.sql.Date;

public class MonthlyShow { // 이달의 공연
	private String showName; // 공연제목
	private String ageGroup; // 관람등급
	private String region; // 지역
	private String place; // 장소
	private String genre; // 장르(콘서트, 연극, 뮤지컬 등등)
	private String termDate; // 공연기간
	private String fileName; // 이미지
	private String runTime; // 관람시간
	private String cast; // 출연진
	private String price;// 가격
	private Date enrollDate; // 등록일
	
	public MonthlyShow() {
		// TODO Auto-generated constructor stub
	}
}
