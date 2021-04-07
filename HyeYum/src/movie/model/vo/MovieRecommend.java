package movie.model.vo;

import board.model.vo.Board;

public class MovieRecommend extends Board { // 영화 추천 게시판
	private String genre; // 장르
	
	public MovieRecommend() {
		// TODO Auto-generated constructor stub
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "MovieRecommend [genre=" + genre + "]";
	}
	
	
	
	
}
