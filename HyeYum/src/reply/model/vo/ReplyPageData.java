package reply.model.vo;

import java.util.ArrayList;

public class ReplyPageData {
	
	private ArrayList<Reply> replyList;
	private String pageNavi;

	public ReplyPageData() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyList(ArrayList<Reply> replyList) {
		this.replyList = replyList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "ReplyPageData [replyList=" + replyList + ", pageNavi=" + pageNavi + "]";
	}
	
	
	
}
