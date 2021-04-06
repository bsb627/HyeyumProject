package show.model.vo;

import board.model.vo.Board;

public class ShowReview extends Board{ // 공연 게시판
	private String snsLink; // sns링크주소
	private String ticketNumber; // 예매 일련 번호
	
	public ShowReview() {
		// TODO Auto-generated constructor stub
	}

	
	public String getSnsLink() {
		return snsLink;
	}

	public void setSnsLink(String snsLink) {
		this.snsLink = snsLink;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	@Override
	public String toString() {
		return "ShowReview [no=" + super.no + ", title=" + super.title + ", contents=" + super.contents +", nick=" + super.nick + ", hits=" + super.hits+" likes=" + super.likes + ", enrollDate=" + super.enrollDate + ", snsLink=" + this.snsLink + ", ticketNumber=" + this.ticketNumber + "]";
	}
	
	
}
