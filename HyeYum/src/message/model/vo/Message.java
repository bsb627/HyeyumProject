package message.model.vo;

public class Message {
	private int  MessageNo; // 쪽지번호
	private String contents; // 내용
	private String readState; // 읽음여부
	private String receiver; // 수신자
	private String sender; // 발신자
	
	public Message() {
		// TODO Auto-generated constructor stub
	}

	public int getMessageNo() {
		return MessageNo;
	}

	public void setMessageNo(int messageNo) {
		MessageNo = messageNo;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getReadState() {
		return readState;
	}

	public void setReadState(String readState) {
		this.readState = readState;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	@Override
	public String toString() {
		return "Message [MessageNo=" + MessageNo + ", contents=" + contents + ", readState=" + readState + ", receiver="
				+ receiver + ", sender=" + sender + "]";
	}
	
	
	
}
