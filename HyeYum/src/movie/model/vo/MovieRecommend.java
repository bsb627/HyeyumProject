package movie.model.vo;

import board.model.vo.Board;

public class MovieRecommend extends Board { // 영화 추천 게시판
	private int rowNo; // 글번호
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

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	@Override
	public String toString() {
		return "MovieRecommend [no=" + super.no + ", title=" + super.title + ", contents=" + super.contents +", nick=" + super.nick + ", hits=" + super.hits+" likes=" + super.likes + ", enrollDate=" + super.enrollDate + ", genre=" + genre + "]";
	}
	
	
	
}
