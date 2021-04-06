package movie.model.vo;

import java.sql.Date;

public class MovieReview { // 영화 리뷰 게시판
	private int no; // 글번호
	private String movieName;// 영화명
	private String starRating;// 평점
	private String nick;// 닉네임
	private Date enrollDate; // 작성일
	private String spoiler;// 스포일러 유무
	private String contents;// 감상평
	private int hits;// 조회수
	private int likes;// 좋아요
	private String ticketNumber;// 예매 일련번호

	public MovieReview() {
		// TODO Auto-generated constructor stub
	}
}
