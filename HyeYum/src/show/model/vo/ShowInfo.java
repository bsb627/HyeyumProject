package show.model.vo;

import java.sql.Date;

public class ShowInfo { // 공연 정보
	private int infoNo; // 번호
	private String type; // 종류
	private String genre; // 장르(콘서트, 연극, 뮤지컬 등등)
	private String region; // 지역
	private String place; // 장소
	private String showName; // 공연제목
	private String termDate; // 공연기간
	private String ageGroup; // 관람등급
	private String runTime; // 관람시간
	private String cast; // 출연진
	private String price;// 가격
	private Date enrollDate; // 등록일
	
	public ShowInfo() {
		// TODO Auto-generated constructor stub
	}

	public int getInfoNo() {
		return infoNo;
	}

	public void setInfoNo(int infoNo) {
		this.infoNo = infoNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getTermDate() {
		return termDate;
	}

	public void setTermDate(String termDate) {
		this.termDate = termDate;
	}

	public String getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "ShowInfo [infoNo=" + infoNo + ", type=" + type + ", genre=" + genre + ", region=" + region + ", place="
				+ place + ", showName=" + showName + ", termDate=" + termDate + ", ageGroup=" + ageGroup + ", runTime="
				+ runTime + ", cast=" + cast + ", price=" + price + ", enrollDate=" + enrollDate + "]";
	}
	
	
	
}
