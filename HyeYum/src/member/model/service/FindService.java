package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.JDBCTemplate;
import member.model.dao.FindDAO;
import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class FindService {
	private JDBCTemplate factory;
	
	public FindService() {
		factory = JDBCTemplate.getConnection();
	}

	public Member FindOneMember(String userName, String email) { // 회원 로그인
		Connection conn = null;
		Member member = null;
		
		try {
			conn = factory.createConnection();
			member = new FindDAO().findOneMember(conn, userName, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return member;
	}

	public Member findOneId(String userId) {
		Connection conn = null;
		Member member = null;
		
		try {
			conn = factory.createConnection();
			member = new FindDAO().findOneId(conn, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return member;
	}

	public Member findOneNameEmail(String userName, String email) {
		Connection conn = null;
		Member member = null;
		
		try {
			conn = factory.createConnection();
			member = new FindDAO().selectOneNameEmail(conn, userName, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return member;
	}

	public int updatePwd(String userName, String newPwd) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new FindDAO().updatePwd(conn, userName, newPwd);
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
