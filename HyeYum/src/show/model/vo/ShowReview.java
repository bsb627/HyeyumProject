package show.model.vo;

import board.model.vo.Board;

public class ShowReview extends Board{ // 공연 게시판
	private int contentsNo; // 공연번호
	private String fileName; // 이미지파일
	private String snsLink; // sns링크주소
	private String ticketNumber; // 예매 일련 번호
	
	public ShowReview() {
		// TODO Auto-generated constructor stub
	}

	
	public int getContentsNo() {
		return contentsNo;
	}


	public void setContentsNo(int contentsNo) {
		this.contentsNo = contentsNo;
	}


	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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
		return "ShowReview [no=" + super.no + ", title=" + super.title + ", contents=" + super.contents +", nick=" + super.nick + ", hits=" + super.hits+" likes=" + super.likes + ", enrollDate=" + super.enrollDate + "fileName=" + this.fileName + "contentsNo=" + this.contentsNo + ", snsLink=" + this.snsLink + ", ticketNumber=" + this.ticketNumber + "]";
	}
	
	
}
