package reply.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import reply.model.dao.ReplyDAO;
import reply.model.vo.Reply;
import reply.model.vo.ReplyPageData;
import sun.net.ConnectionResetException;

public class ReplyService {
	private JDBCTemplate factory;
	
	public ReplyService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public ReplyPageData printAllReply(int currentPage, String replyType, int showNo) { // 댓글 전체보기
		Connection conn = null;
		ReplyPageData pd = new ReplyPageData();
		try {
			conn = factory.createConnection();
			pd.setReplyList(new ReplyDAO().selectAllList(conn, currentPage, replyType, showNo));
			pd.setPageNavi(new ReplyDAO().getPageNavi(conn, currentPage, replyType,showNo));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public int registerReply(Reply reply) { // 댓글 등록
		int result = 0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new ReplyDAO().insertReply(conn, reply);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int modifyReply(Reply reply) { // 댓글 수정 
		int result = 0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new ReplyDAO().updateReply(conn, reply);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
				
		return result;
	}
	
	public int deleteReply(int replyNo, String type) { // 댓글 삭제
		int result = 0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new ReplyDAO().deleteReply(conn, replyNo, type);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return result ;
	}

	public int totalCount(int showNo) {
		int count = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			count = new ReplyDAO().totalCount(conn, showNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return count;
	}

	public ArrayList<Reply> printReplyList(int showNo) {
		ArrayList<Reply> rList = null;
		Connection conn =null;
		try {
			conn = factory.createConnection();
			rList = new ReplyDAO().selectReplyList(conn,showNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		// TODO Auto-generated method stub
		return rList;
	}
	
	// BookReview 시작 
	public int registerReplyBookReview(Reply reply) { //댓글 등록
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new ReplyDAO().insertReplyBookReview(conn, reply);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int BookReviewDeleteReply(int replyNo, String type) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new ReplyDAO().deleteReplyBookReview(conn, replyNo);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return result ;
	}

	public int totalCountBookReview(int reviewNo) {
		int count = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			count = new ReplyDAO().totalCountBookReview(conn, reviewNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return count;
	}

	public ArrayList<Reply> printReplyListBookReview(int reviewNo) {
		ArrayList<Reply> rList = null;
		Connection conn =null;
		try {
			conn = factory.createConnection();
			rList = new ReplyDAO().selectReplyListBookReview(conn,reviewNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		// TODO Auto-generated method stub
		return rList;
	}

}
