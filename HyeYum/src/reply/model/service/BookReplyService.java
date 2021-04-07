package reply.model.service;

import java.util.ArrayList;

import common.JDBCTemplate;
import reply.model.vo.BoardReply;

public class BookReplyService {
	private JDBCTemplate factory;
	
	public BookReplyService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public ArrayList<BoardReply> printAllBookReply() { // 도서후기 댓글 전체보기
		ArrayList<BoardReply> list = null;
		return list;
	}
	
	public int modifyBookReply() { // 도서후기 댓글 수정 
		int result = 0;
		return result;
	}
	
	public BoardReply registerBookReply() { // 도서후기 댓글 등록
		BoardReply reply = null;
		return reply;
	}
	
	public int deleteBookReply() { // 도서후기 댓글 삭제
		int result = 0;
		return result ;
	}
	
	public ArrayList<BoardReply> printAllShareReply() { // 도서나눔 댓글 전체보기
		ArrayList<BoardReply> list = null;
		return list;
	}
	
	public int modifyShareReply() { // 도서나눔 댓글 수정 
		int result = 0;
		return result;
	}
	
	public BoardReply registerShareReply() { // 도서나눔 댓글 등록
		BoardReply reply = null;
		return reply;
	}
	
	public int deleteShareReply() { // 도서나눔 댓글 삭제
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
