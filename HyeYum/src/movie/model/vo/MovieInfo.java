package movie.model.vo;

import java.sql.Date;

public class MovieInfo { // 영화 컨텐츠
	private String infoNo; // 컨텐츠 번호
	private String movieName;// 영화명
	private String genre;// 장르
	private String cast; // 출연진
	private String director;// 감독
	private String ageGroup;// 관람등급
	private String runTime;	// 러닝타임
	private String synopsis; // 영화줄거리
	private String fileName; // 첨부파일명
	private Date enrollDate; // 등록일

	public MovieInfo() {
		// TODO Auto-generated constructor stub
	}

	public String getInfoNo() {
		return infoNo;
	}

	public void setInfoNo(String infoNo) {
		this.infoNo = infoNo;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
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

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "MovieInfo [infoNo=" + infoNo + ", movieName=" + movieName + ", genre=" + genre + ", cast=" + cast
				+ ", director=" + director + ", ageGroup=" + ageGroup + ", runTime=" + runTime + ", synopsis="
				+ synopsis + ", fileName=" + fileName + ", enrollDate=" + enrollDate + "]";
	}
	
	
}
