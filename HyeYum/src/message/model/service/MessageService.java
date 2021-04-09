package message.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import message.model.dao.MessageDAO;
import message.model.vo.Message;
import message.model.vo.MsgPageData;

public class MessageService {
	//  보낸메시지 전체출력.받은메시지 전체출력, 전송, 답장, 삭제, 검색
	private JDBCTemplate factory;
	
	public MessageService() {
		factory = new JDBCTemplate().getConnection();
	}
	// 보낸 메시지 전제출력
	public MsgPageData printAllSentList(int currentPage) {
		Connection conn = null;
		MsgPageData pd = new MsgPageData();
		
		try {
			conn = factory.createConnection();
			pd.setMsgList(new MessageDAO().selectAllSentList(conn, currentPage));
			pd.setPageNavi(new MessageDAO().getPageNavi(conn, currentPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	//받은 메시지 전체 출력
	public MsgPageData printAllRecievedList(int currentPage) {
		Connection conn = null;
		MsgPageData pd = new MsgPageData();
		
		try {
			conn = factory.createConnection();
			pd.setMsgList(new MessageDAO().selectAllRecievedList(conn, currentPage));
			pd.setPageNavi(new MessageDAO().getPageNavi(conn, currentPage));
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

	// 메시지 삭제
	public int deleteMessage(ArrayList<Message> Message) {

		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new MessageDAO().deleteMessage(conn, Message);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	// 글검색 
	public MsgPageData printSearchLsit(String search, String searchCategory, int currentPage) {
		Connection conn = null;
		MsgPageData pd = new MsgPageData();
		
		try {
			conn = factory.createConnection();
			pd.setMsgList(new MessageDAO().selectSearchList(conn, searchCategory, search, currentPage));
			pd.setPageNavi(new MessageDAO().selectSearchPageNavi(conn, searchCategory, search, currentPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	

}
