package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.vo.Member;
import member.model.vo.MemberPageData;

public class MemberService {
	
	private JDBCTemplate factory;
	
	public MemberService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public Member selectOneMember(String userId, String userPwd) { // 회원 로그인
		Connection conn = null;
		Member member = null;
		
		return member;
	}
	
	public Member selectOneById(String userId) { // 마이페이지 - 내 정보
		Connection conn = null;
		Member member = null;
		
		return member;
	}
	
	public ArrayList<Member> selectMemberList() {
		ArrayList<Member> list = null;
		Connection conn = null;
		
		return list;
	}
	
	public MemberPageData printAllDeleteMemberList(int currentPage) { // 탈퇴멤버 출력
		Connection conn = null;
		MemberPageData mpd = new MemberPageData();
		try {
			conn = factory.createConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return mpd;
	}
	
	public int modifyMember(Member member) {
		Connection conn = null;
		int result = 0;
		
		return result;
	}
	
	public int registerMember(Member member) {
		Connection conn = null;
		int result = 0;
		
		return result;
	}
	
	public int deleteMember(String userId) {
		Connection conn = null;
		int result = 0;
		
		return result;
	}
	
	public int restoreMember(String userId) {
		Connection conn = null;
		int result = 0;
		
		return result;
	}

}
