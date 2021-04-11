package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.dao.MemberDAO;
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
		
		try {
			conn = factory.createConnection();
			member = new MemberDAO().selectOneMember(conn, userId, userPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return member;
	}
	
	public Member selectOneById(String userId) { // 마이페이지 - 내 정보
		Connection conn = null;
		Member member = null;
		
		return member;
	}
	
	public ArrayList<Member> selectMemberList() { // 회원 전체 출력
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
	
	public int modifyMember(Member member) { //회원 정보 수정
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new MemberDAO().updateMember(conn, member);
			if (result > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int registerMember(Member member) { // 회원가입
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new MemberDAO().insertMember(conn, member);
			if (result > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int deleteMember(String userId) { // 회원 탈퇴
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new MemberDAO().deleteMember(conn, userId);
			if (result > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int restoreMember(Member member) { // 탈퇴회원 복구 
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new MemberDAO().restoreMember(conn, member);
			if (result > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

}
