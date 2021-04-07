package member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.vo.Member;

public class MemberService {
	
	private JDBCTemplate factory;
	
	public MemberService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public Member selectOneMember() {
		Connection conn = null;
		
		return null;
	}
	
	public Member selectOneById() {
		Connection conn = null;
		
		return null;
	}
	
	public ArrayList<Member> selectMemberList() {
		ArrayList<Member> list = null;
		Connection conn = null;
		
		return list;
	}
	
	public int modifyMember() {
		return 0;
	}
	
	public int registerMember() {
		return 0;
	}
	
	public int deleteMember() {
		return 0;
	}

}
