package message.model.vo;

import java.util.ArrayList;

public class MsgPageData {
	
	private ArrayList<Message> msgList;
	private String pageNavi;
	
	public MsgPageData() {}

	public ArrayList<Message> getMsgList() {
		return msgList;
	}

	public void setMsgList(ArrayList<Message> msgList) {
		this.msgList = msgList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
	

}
