package reply.model.service;

import java.util.ArrayList;

import common.JDBCTemplate;
import reply.model.vo.BoardReply;

public class ShowReplyService {
	private JDBCTemplate factory;
	
	public ShowReplyService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public ArrayList<BoardReply> printAllShowReply() { // 관람후기 댓글 전체보기
		ArrayList<BoardReply> list = null;
		return list;
	}
	
	public int modifyShowReply() { // 관람후기 댓글 수정 
		int result = 0;
		return result;
	}
	
	public BoardReply registerShowReply() { // 관람후기 댓글 등록
		BoardReply reply = null;
		return reply;
	}
	
	public int deleteShowReply() { // 관람후기 댓글 삭제
		int result = 0;
		return result ;
	}
	
	public int plusReplyLikesCount() { // 좋아요수 증가
		int result = 0;
		return result;
	}
	
	public int minusReplyLikesCount() { // 좋아요수 빼기
		int result = 0;
		return result;
	}
	
}
