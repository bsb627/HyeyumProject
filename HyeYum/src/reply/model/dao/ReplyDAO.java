package reply.model.dao;

import java.sql.Connection;
import java.util.ArrayList;
import reply.model.vo.Reply;

public class ReplyDAO {
	
	public ArrayList<Reply> selectAllList(Connection conn, int currentPage) {
		return null;
	}

	public int insertReply(Connection conn, Reply reply) {
		
		return 0;
	}

	public int deleteReply(Connection conn, int qnaNo) {
		return 0;
	}

	public int updateReply(Connection conn, Reply Reply) {
		return 0;
	}
	
	public String getPageNavi(Connection conn, int currentPage) {
		return null;
	}
	
	public int totalCount(Connection conn) {
		return 0;
	}

	
}
