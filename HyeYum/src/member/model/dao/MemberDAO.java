package member.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import member.model.vo.Member;
import movie.model.vo.MovieReview;

public class MemberDAO {
	
	public Member selectOneMember(Connection conn, String userId, String userPwd) {
		Member member = null;
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
