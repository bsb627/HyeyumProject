package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;

public class DonateDAO {

	public int countBook(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int bookCount = 0;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM BOOK_REVIEW WHERE USER_ID = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				bookCount = rset.getInt("TOTALCOUNT");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return bookCount;
	}

	public int countMovie(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int bookCount = 0;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM MOVIE_REVIEW WHERE USER_ID = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				bookCount = rset.getInt("TOTALCOUNT");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return bookCount;
	}

	public int countShow(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int bookCount = 0;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM SHOW_REVIEW WHERE USER_ID = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				bookCount = rset.getInt("TOTALCOUNT");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return bookCount;
	}

	
}
