package message.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import message.model.vo.Message;

public class MessageDAO {

	public ArrayList<Message> selectAllSentList(Connection conn, int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public ArrayList<Message> selectAllRecievedList(Connection conn, int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPageNavi(Connection conn, int currentPage) {

		// TODO Auto-generated method stub
		return null;
	}
	
	public int totalCount(Connection conn) {
		Statement stmt= null;
		ResultSet rset = null;
		return 0;
	}

	public Message selectOne(Connection conn, int messageNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int deleteMessage(Connection conn, ArrayList<Message> Message) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int insertMessage(Connection conn, Message message) {

		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public ArrayList<Message> selectSearchList(Connection conn, String search, String searchCategory, int currentPage) {
		return null;
		
	}
	
	public String getSearchPageNavi(Connection conn, String search, int currentPage, String searchCategory) {
		PreparedStatement pstmt= null;
		
		int recordCountPerPage = 10; // 게시물을 10개씩 
		int naviCountPerPage = 10; // 네비를 10개씩 보여줄거
		int recordTotalCount = searchTotalCount(conn, search, searchCategory); // 전체 게시물 수
		return null;
	}




	public String selectSearchPageNavi(Connection conn, String searchCategory, String search, int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int searchTotalCount(Connection conn, String search, String searchCategory) {
		return 0;
		
	}



}
