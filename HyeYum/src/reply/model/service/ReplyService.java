package reply.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import common.JDBCTemplate;
import reply.model.dao.ReplyDAO;
import reply.model.vo.Reply;
import reply.model.vo.ReplyPageData;

public class ReplyService {
	private JDBCTemplate factory;
	
	public ReplyService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public ReplyPageData printAllReply(int currentPage, String replyType) { // 댓글 전체보기
		Connection conn = null;
		ReplyPageData pd = new ReplyPageData();
		try {
			conn = factory.createConnection();
			pd.setReplyList(new ReplyDAO().selectAllList(conn, currentPage, replyType));
			pd.setPageNavi(new ReplyDAO().getPageNavi(conn, currentPage, replyType));
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int modifyReply(Reply reply) { // 댓글 수정 
		int result = 0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new ReplyDAO().updateReply(conn, reply);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return result;
	}
	
	public int deleteReply(int replyNo) { // 댓글 삭제
		int result = 0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new ReplyDAO().deleteReply(conn, replyNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result ;
	}

}
