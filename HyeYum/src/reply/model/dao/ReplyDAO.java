package reply.model.dao;

import java.sql.Connection;
import java.util.ArrayList;
import reply.model.vo.Reply;

public class ReplyDAO {
	
	public ArrayList<Reply> selectAllList(Connection conn, int currentPage, String replyTpye) { // 댓글 전체보기
		return null;
	}

	public int insertReply(Connection conn, Reply reply) { // 댓글 등록
		return 0;
	}
	
	public int updateReply(Connection conn, Reply reply) {  // 댓글 수정 
		return 0;
	}

	public int deleteReply(Connection conn, int replyNo) { // 댓글 삭제
		return 0;
	}
	
	public String getPageNavi(Connection conn, int currentPage, String replyType) { // 댓글 페이징
		return null;
	}
	
	public int totalCount(Connection conn) { // 댓글 총 개수
		return 0;
	}

	
}
