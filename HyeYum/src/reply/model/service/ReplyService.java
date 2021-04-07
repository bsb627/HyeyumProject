package reply.model.service;

import java.util.ArrayList;

import common.JDBCTemplate;
import reply.model.vo.Reply;

public class ReplyService {
	private JDBCTemplate factory;
	
	public ReplyService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public ArrayList<Reply> printAllReply() { // 댓글 전체보기
		ArrayList<Reply> list = null;
		return list;
	}
	
	public int modifyReply() { // 댓글 수정 
		int result = 0;
		return result;
	}
	
	public Reply registerReply() { // 댓글 등록
		Reply reply = null;
		return reply;
	}
	
	public int deleteReply() { // 댓글 삭제
		int result = 0;
		return result ;
	}

}
