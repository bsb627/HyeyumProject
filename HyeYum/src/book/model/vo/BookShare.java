package book.model.vo;

import board.model.vo.Board;

public class BookShare extends Board{ // 나눔 게시판
	private String region; // 지역

	public BookShare() {
		// TODO Auto-generated constructor stub
	}
	
	// constructor

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	
}