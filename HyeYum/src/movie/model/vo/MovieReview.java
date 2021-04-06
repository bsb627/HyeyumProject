package movie.model.vo;

import board.model.vo.Board;

public class MovieReview extends Board{ // 영화 리뷰 게시판
	private int reviewNo;
	private String movieName;// 영화명
	private String starRating;// 평점
	private String spoiler;// 스포일러 유무
	private String ticketNumber;// 예매 일련번호

	public MovieReview() {
		// TODO Auto-generated constructor stub
	}
}
