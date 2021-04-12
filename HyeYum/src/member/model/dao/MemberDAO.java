package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.vo.Member;
import movie.model.vo.MovieReview;

public class MemberDAO {
	
	public Member selectOneMember(Connection conn, String userId, String userPwd) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MEMBER WHERE USER_ID='" + userId + "'AND USER_PWD='" + userPwd +"'";
		Member member = null;
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				member = new Member();
				member.setUserId(rset.getString("USER_ID"));
				member.setUserPwd(rset.getString("USER_PWD"));
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
	
	public Member selectOneById(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MEMBER WHERE USER_ID = ?";
		//USER_ID, USER_PWD, USER_NAME, NICK, USER_PHONE, EMAIL, ADDRESS, ENROLL_DATE, OUT_DATE, OUT_STATE, OUT_REASON
		Member member = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				member = new Member();
				member.setUserId(rset.getString("USER_ID"));
				member.setUserPwd(rset.getString("USER_PWD"));
				member.setUserName(rset.getString("USER_NAME"));
				member.setUserNick(rset.getString("NICK"));
				member.setUserPhone(rset.getString("USER_PHONE"));
				member.setUserEmail(rset.getString("EMAIL"));
				member.setUserAddress(rset.getString("ADDRESS"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));
				member.setOutDate(rset.getDate("OUT_DATE"));
				member.setOutState(rset.getString("OUT_STATE"));
				member.setOutReason(rset.getString("OUT_REASON"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return member;
	}
	
	public ArrayList<Member> selectMemberList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = null;
		String query = "SELECT * FROM MEMBER";
		//USER_ID, USER_PWD, USER_NAME, NICK, USER_PHONE, EMAIL, ADDRESS, ENROLL_DATE, OUT_DATE, OUT_STATE, OUT_REASON
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<Member>();
			while(rset.next()) {
				Member member = new Member();
				member.setUserId(rset.getString("USER_ID"));
				member.setUserPwd(rset.getString("USER_PWD"));
				member.setUserName(rset.getString("USER_NAME"));
				member.setUserNick(rset.getString("NICK"));
				member.setUserPhone(rset.getString("USER_PHONE"));
				member.setUserEmail(rset.getString("EMAIL"));
				member.setUserAddress(rset.getString("ADDRESS"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));
				member.setOutDate(rset.getDate("OUT_DATE"));
				member.setOutState(rset.getString("OUT_STATE"));
				member.setOutReason(rset.getString("OUT_REASON"));
				list.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(stmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}
	
	public ArrayList<Member> printAllDeleteMember(Connection conn, int currentPage) { // 탈퇴멤버 출력
		ArrayList<Member> list = null;
		
		return list;
	}
	
	public String getDeleteMemberPageNavi(Connection conn, int currentPage) { 
		return null;
	}
	
	public int totalDeleteMemberCount(Connection conn) {
		return 0;
	}
	
	public int insertMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,SYSDATE, NULL, NULL,NULL)";
		//USER_ID, USER_PWD, USER_NAME, NICK, USER_PHONE, EMAIL, ADDRESS, ENROLL_DATE, OUT_DATE, OUT_STATE, OUT_REASON
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getUserNick());
			pstmt.setString(5, member.getUserPhone());
			pstmt.setString(6, member.getUserEmail());
			pstmt.setString(7, member.getUserAddress());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int updateMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MEMBER SET MEMBER_PWD=?, USER_PHONE=?, EMAIL=?, ADDRESS=? WHERE USER_ID = ?";
		// 불러올 정보:USER_ID 수정할 정보 : MEMBER_PWD, USER_PHONE, EMAIL, ADDRESS
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserPwd());
			pstmt.setString(2, member.getUserPhone());
			pstmt.setString(3, member.getUserEmail());
			pstmt.setString(4, member.getUserAddress());
			pstmt.setString(5, member.getUserId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deleteMember(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM MEMBER WHERE MEMBER_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int restoreMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MEMBER SET OUT_STATE=? WHERE USER_ID =?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getOutState()); 
			pstmt.setString(2, member.getUserId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
