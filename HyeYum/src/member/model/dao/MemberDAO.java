package member.model.dao;

import java.sql.Connection;
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
		Member member = null;
		return member;
	}
	
	public ArrayList<Member> selectMemberList(Connection conn) {
		ArrayList<Member> list = null;
		
		return list;
	}
	
	public ArrayList<Member> printAllDeleteMember(Connection conn, int currentPage) {
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
		int result = 0;
		
		return result;
	}
	
	public int updateMember(Connection conn, Member member) {
		int result = 0;
		
		return result;
	}
	
	public int deleteMember(Connection conn, String userId) {
		int result = 0;
		
		return result;
	}
	
	public int restoreMember(Connection conn, String userId) {
		int result = 0;
		return result;
	}
}
