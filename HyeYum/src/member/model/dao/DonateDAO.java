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

	public int countAllBook(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int bookAllCount = 0;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM BOOK_REVIEW";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				bookAllCount = rset.getInt("TOTALCOUNT");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return bookAllCount;
	}

	public int countAllMovie(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int movieAllCount = 0;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM MOVIE_REVIEW";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				movieAllCount = rset.getInt("TOTALCOUNT");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return movieAllCount;
	}

	public int countAllShow(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int showAllCount = 0;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM SHOW_REVIEW";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				showAllCount = rset.getInt("TOTALCOUNT");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return showAllCount;
	}

	public int countAllMember(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int memberAllCount = 0;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM MEMBER";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				memberAllCount = rset.getInt("TOTALCOUNT");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return memberAllCount;
	}

	public int countAllCompany(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int companyAllCount = 0;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM COMPANY WHERE PARTNERSHIP = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "Y");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				companyAllCount = rset.getInt("TOTALCOUNT");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return companyAllCount;
	}

	
}
