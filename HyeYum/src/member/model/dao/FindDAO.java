package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.JDBCTemplate;
import member.model.vo.Member;

public class FindDAO {

	public Member findOneMember(Connection conn, String userName, String email) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MEMBER WHERE USER_NAME='" + userName + "'AND EMAIL='" + email +"'";
		Member member = null;
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				member = new Member();
				member.setUserId(rset.getString("USER_ID"));
				member.setUserPwd(rset.getString("USER_PWD"));
				member.setUserName(rset.getString("USER_NAME"));
				member.setUserNick(rset.getString("NICK"));
				member.setUserPhone(rset.getString("USER_PHONE"));
				member.setUserEmail(rset.getString("EMAIL"));
				member.setUserAddress(rset.getString("ADDRESS"));
				member.setRegDate(rset.getDate("REG_DATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return member;
	}

	public Member findOneId(Connection conn, String userId) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MEMBER WHERE USER_ID='" + userId +"'";
		Member member = null;
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				member = new Member();
				member.setUserId(rset.getString("USER_ID"));
				member.setUserPwd(rset.getString("USER_PWD"));
				member.setUserName(rset.getString("USER_NAME"));
				member.setUserNick(rset.getString("NICK"));
				member.setUserPhone(rset.getString("USER_PHONE"));
				member.setUserEmail(rset.getString("EMAIL"));
				member.setUserAddress(rset.getString("ADDRESS"));
				member.setRegDate(rset.getDate("REG_DATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return member;
	}

	public Member selectOneNameEmail(Connection conn, String userName, String email) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MEMBER WHERE USER_NAME='" + userName +"' AND EMAIL='" + email +"'";
		Member member = null;
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				member = new Member();
				member.setUserId(rset.getString("USER_ID"));
				member.setUserPwd(rset.getString("USER_PWD"));
				member.setUserName(rset.getString("USER_NAME"));
				member.setUserNick(rset.getString("NICK"));
				member.setUserPhone(rset.getString("USER_PHONE"));
				member.setUserEmail(rset.getString("EMAIL"));
				member.setUserAddress(rset.getString("ADDRESS"));
				member.setRegDate(rset.getDate("REG_DATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return member;
	}

	public int updatePwd(Connection conn, String userName, String newPwd) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UDATE MEMBER SET USER_PWD = ? WHERE USER_NAME = ?";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, userName);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
