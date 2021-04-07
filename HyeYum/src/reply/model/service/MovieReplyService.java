package reply.model.service;

import java.util.ArrayList;

import common.JDBCTemplate;
import reply.model.vo.BoardReply;

public class MovieReplyService {
	private JDBCTemplate factory;
	
	public MovieReplyService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public ArrayList<BoardReply> printAllMovieReply() { // 영화추천 댓글 전체보기
		ArrayList<BoardReply> list = null;
		return list;
	}
	
	public int modifyMovieReply() { // 영화추천 댓글 수정 
		int result = 0;
		return result;
	}
	
	public BoardReply registerMovieReply() { // 영화추천 댓글 등록
		BoardReply reply = null;
		return reply;
	}
	
	public int deleteMovieReply() { // 영화추천 댓글 삭제
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
