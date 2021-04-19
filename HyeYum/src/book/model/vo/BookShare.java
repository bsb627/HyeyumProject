package book.model.vo;

import board.model.vo.Board;

public class BookShare extends Board{ // 나눔 게시판
	private String region; // 지역
	
	// constructor
	public BookShare() {
		// TODO Auto-generated constructor stub
	}
	
	// getter / setter
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}



	@Override
	public String toString() {
		return "BookShareReview [no=" + super.no + ", title=" + super.title + ", contents=" + super.contents +", nick=" + super.nick + ", hits=" + super.hits+" likes=" + super.likes + ", enrollDate=" + super.enrollDate + "BookShare [region=" + region +  "]";
	}
	
}
