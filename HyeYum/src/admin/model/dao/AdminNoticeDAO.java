package admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import notice.model.vo.Notice;

public class AdminNoticeDAO {

// 전체
 	public ArrayList<Notice> selectAllAdminNoticeList(Connection conn) {
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		ArrayList<Notice> nList = null;
		String query = "SELECT ROW_NUMBER() OVER(ORDER BY NOTICE_NO DESC) AS NUM, NOTICE_NO, TITLE, CONTENTS, USER_ID, ENROLL_DATE , HITS FROM NOTICE";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();		
			nList = new ArrayList<Notice>(); 
			while(rset.next()) { 
				Notice notice = new Notice(); 
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setTitle(rset.getString("TITLE"));
				notice.setContents(rset.getString("CONTENTS"));
				notice.setUserId(rset.getString("USER_ID"));
				notice.setEnrollDate(rset.getDate("ENROLL_DATE"));
				notice.setHits(rset.getInt("HITS"));
				nList.add(notice); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("DAO.." + nList);
		return nList;
	}

 	// 등록
	public int insertNotice(Connection conn, Notice notice) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query ="INSERT INTO NOTICE VALUES(SEQ_NOTICE.NEXTVAL, ? , ?, SYSDATE, 0,  ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getContents());
			pstmt.setString(3, notice.getUserId());
			result = pstmt.executeUpdate(); // ?
			System.out.println("인서트 노티스 디에이오 : 노티스" + notice);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		System.out.println("등록dao result" + result);
		return result;
	}

	// 삭제
	public int deleteNotice(Connection conn, String noticeNo) {
		Statement stmt = null; 
		int result = 0;
		String query ="DELETE FROM NOTICE WHERE NOTICE_NO IN("+ noticeNo+ ")"; 
		try {
			stmt = conn.createStatement();
			result =stmt.executeUpdate(query); 
			System.out.println("들어왔나요?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(stmt);
		}
		System.out.println("result" + result);
		return result;
	}

	// 하나만 출력
	public Notice selectOne(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		Notice notice = null;
		String query = "SELECT * FROM NOTICE WHERE NOTICE_NO = ?"; 
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			if(rset.next()) { 
				notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setTitle(rset.getString("TITLE"));
				notice.setContents(rset.getString("CONTENTS"));
				notice.setUserId(rset.getString("USER_ID"));
				notice.setEnrollDate(rset.getDate("ENROLL_DATE"));
				notice.setHits(rset.getInt("HITS"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return notice;
	}
	
	
	// 수정
	public int updateNotice(Connection conn, Notice notice) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE NOTICE  SET TITLE = ?, CONTENTS =? WHERE NOTICE_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getContents());
			pstmt.setInt(3, notice.getNoticeNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 조회?... 
	
	/*
	 * public int updateHitsNotice(Connection conn, int noticeNo) {
	 * PreparedStatement pstmt = null; int result = 0; String query =
	 * "UPDATE NOTICE SET HITS = NVL(HITS,0) + 1 WHERE NOTICE_NO = ?"; try { pstmt =
	 * conn.prepareStatement(query); pstmt.setInt(1, noticeNo); result =
	 * pstmt.executeUpdate(); } catch (SQLException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }finally { JDBCTemplate.close(pstmt); }
	 * return result; }
	 */

	
	
	
	
}
