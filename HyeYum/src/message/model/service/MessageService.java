package message.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import message.model.dao.MessageDAO;
import message.model.vo.Message;
import message.model.vo.MsgPageData;
import qna.model.dao.QnaDAO;

public class MessageService {
	//  보낸메시지 전체출력.받은메시지 전체출력, 전송, 답장, 삭제, 검색
	private JDBCTemplate factory;
	
	public MessageService() {
		factory = JDBCTemplate.getConnection();
	}
	// 보낸 메시지 전제출력
	public MsgPageData printAllSentList(int currentPage, String userId) {
		Connection conn = null;
		MsgPageData pd = new MsgPageData();
		try {
			conn = factory.createConnection();
			pd.setMsgList(new MessageDAO().selectAllSentList(conn, currentPage, userId));
			pd.setPageNavi(new MessageDAO().getPageNavi(conn, currentPage, userId));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	//받은 메시지 전체 출력
	public MsgPageData printAllRecievedList(int currentPage, String userId) {
		Connection conn = null;
		MsgPageData pd = new MsgPageData();
		
		try {
			conn = factory.createConnection();
			pd.setMsgList(new MessageDAO().selectAllRecievedList(conn, currentPage, userId));
			pd.setPageNavi(new MessageDAO().getPageNaviRe(conn, currentPage, userId));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	// 메시지 하나 출력
	public Message printOne(int messageNo) {
		Connection conn = null;
		Message message = null;
		try {
			conn = factory.createConnection();
			message = new MessageDAO().selectOne(conn, messageNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return message;
	}
	
	// 메시지 보내기
	public int sendMessage(Message message) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new MessageDAO().insertMessage(conn, message);
			if( result > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
		
	}

	// 메시지 삭제
	public int deleteMessage(int messageNo) {

		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new MessageDAO().deleteMessage(conn, messageNo);
			if( result > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	// 받은  메시지   검색 
	public MsgPageData printSearchList( String searchCategory, String search,int currentPage, String userId) {
		Connection conn = null;
		MsgPageData pd = new MsgPageData();
		
		try {
			conn = factory.createConnection();
			pd.setMsgList(new MessageDAO().selectSearchList(conn,   searchCategory, search, currentPage, userId));
			pd.setPageNavi(new MessageDAO().getSearchPageNavi(conn,  searchCategory, search, currentPage, userId));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
		
	}
	// 보낸 메시지   검색 
	public MsgPageData printSearchListSent( String searchCategory, String search,int currentPage, String userId) {
		Connection conn = null;
		MsgPageData pd = new MsgPageData();
		
		try {
			conn = factory.createConnection();
			pd.setMsgList(new MessageDAO().selectSearchListSent(conn,   searchCategory, search, currentPage, userId));
			pd.setPageNavi(new MessageDAO().getSearchPageNaviSent(conn,  searchCategory, search, currentPage, userId));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
		
	}
	public int updateReadState(int messageNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new MessageDAO().updateReadState(conn, messageNo);
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
//	public int deleteMessages(String msgNo) {
//		Connection conn = null;
//		int result = 0;
//		try {
//			conn = factory.createConnection();
//			result = new MessageDAO().deleteMessages(conn, msgNo);
//			if(result > 0) {
//				JDBCTemplate.commit(conn);
//			} else {
//				JDBCTemplate.rollback(conn);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			JDBCTemplate.close(conn);
//		}
//		return result;
//	}

	

}
