package movie.model.vo;

import board.model.vo.Board;

public class MovieReview extends Board{ // 영화 리뷰 게시판
	private String movieName;// 영화명
	private String starRating;// 평점
	private String spoiler;// 스포일러 유무
	private String ticketNumber;// 예매 일련번호

	public MovieReview() {
		// TODO Auto-generated constructor stub
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getStarRating() {
		return starRating;
	}

	public void setStarRating(String starRating) {
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

	@Override
	public String toString() {
		return "MovieReview [movieName=" + movieName + ", starRating=" + starRating + ", spoiler=" + spoiler
				+ ", ticketNumber=" + ticketNumber + "]";
	}
	
	
}
