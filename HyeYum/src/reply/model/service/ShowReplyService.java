package reply.model.service;

import common.JDBCTemplate;
import reply.model.vo.BoardReply;

public class ShowReplyService {
	private JDBCTemplate factory;
	
	public ShowReplyService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public BoardReply printShowReviewReply() {
		BoardReply reply = null;
		return reply;
	}
	
	public int modifyShowReviewReply() {
		int result = 0;
		return result;
	}
	
	public BoardReply insertShowReviewReply() {
		BoardReply reply = null;
		return reply;
	}
	
	public int deleteShowReviewReply() {
		int result = 0;
		return result ;
	}
	
}
