package reply.model.service;

import common.JDBCTemplate;
import show.model.vo.ShowInfo;

public class ShowReplyService {
	private JDBCTemplate factory;
	
	public ShowReplyService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public ShowInfo printShowReviewReply() {
		ShowInfo info = null;
		return info;
	}
	
	public int modifyShowReviewReply() {
		int result = 0;
		return result;
	}
	
	public ShowInfo insertShowReviewReply() {
		
		ShowInfo info = null;
		
		return info;
	}
	
	public int deleteShowReviewReply() {
		int result = 0;
		return result ;
	}
	
}
