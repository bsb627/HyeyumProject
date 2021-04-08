package qna.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import qna.model.vo.Qna;

public class QnaDAO {
	
	public ArrayList<Qna> selectAllList(Connection conn, int currentPage) {
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

	public Qna selectOne(Connection conn, int qnaNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertQuestion(Connection conn, Qna qna) {
		
		return 0;
	}
	
	public int insertAnswer(Connection conn, Qna qna) {
		
		return 0;
	}

	public int deleteQna(Connection conn, int qnaNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateQna(Connection conn, Qna qna) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Qna> selectSearchList(Connection conn, String search, String searchCategory, int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSearchPageNavi(Connection conn, String search, String searchCategory, int currentPage) {
		PreparedStatement pstmt= null;
		
		int recordCountPerPage = 10; // 게시물을 10개씩 
		int naviCountPerPage = 10; // 네비를 10개씩 보여줄거
		int recordTotalCount = searchTotalCount(conn, search, searchCategory); // 전체 게시물 수
		return null;
	}


	private int searchTotalCount(Connection conn, String search, String searchCategory) {
		return 0;
		
	}
	
}
