package movie.model.vo;

import board.model.vo.Board;

public class MovieReview extends Board{ // 영화 리뷰 게시판
	private int reNo; // 리뷰 글번호
	private String movieName;// 영화명
	private int starRating;// 평점
	private String spoiler;// 스포일러 유무
	private String ticketNumber;// 예매 일련번호
	private int infoNo; // 영화컨텐츠 번호
	

	public MovieReview() {
		// TODO Auto-generated constructor stub
	}


	public int getReNo() {
		return reNo;
	}


	public void setReNo(int reNo) {
		this.reNo = reNo;
	}


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public int getStarRating() {
		return starRating;
	}


	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}


	public String getSpoiler() {
		return spoiler;
	}


	public void setSpoiler(String spoiler) {
		this.spoiler = spoiler;
	}


	public String getTicketNumber() {
		return ticketNumber;
	}


	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}


	public int getInfoNo() {
		return infoNo;
	}


	public void setInfoNo(int infoNo) {
		this.infoNo = infoNo;
	}


	@Override
	public String toString() {
		return "MovieReview [reNo=" + reNo + ", movieName=" + movieName + ", starRating=" + starRating + ", spoiler="
				+ spoiler + ", ticketNumber=" + ticketNumber + ", infoNo=" + infoNo + "]";
	}



		
}
