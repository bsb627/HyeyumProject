package admin.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import admin.model.dao.AdminNoticeDAO;

import common.JDBCTemplate;
import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;

public class AdminNoticeService {
	
		
		private JDBCTemplate factory;
		public AdminNoticeService() {
			factory = JDBCTemplate.getConnection();
		}

		// 리스트
		
	public ArrayList<Notice> printAllAdminNoticeList() {
		ArrayList<Notice> nList = null;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			nList = new AdminNoticeDAO().selectAllAdminNoticeList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return nList;
	}

	// 등록
	
	public int registerNotice(Notice notice) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new AdminNoticeDAO().insertNotice(conn, notice);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {					// 후..............
			JDBCTemplate.close(conn); // 꺼진 finally도 다시보자.......................................
		}
		return result;
	}

	// 삭제
	public int deleteNotice(String noticeNo) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new AdminNoticeDAO().deleteNotice(conn, noticeNo);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	
	// 하나만 출력
	
	public Notice printOneAdmin(int noticeNo) {
		Connection conn = null;
		Notice notice = null;
		try {
			conn = factory.createConnection();
			notice = new AdminNoticeDAO().selectOne(conn, noticeNo);
			System.out.println(notice.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
	}
		return notice;

	
	
}
	// 수정
	public int modifyNotice(Notice notice) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new AdminNoticeDAO().updateNotice(conn, notice);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
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



	/*
	 * public Notice printOne(int noticeNo) {
	 * 
	 * return null; }
	 */
	
	
	/*
	 * // 조회증가 public int updateHits(int noticeNo) { int result = 0; Connection conn
	 * = null; try { conn = factory.createConnection(); result = new
	 * AdminNoticeDAO().updateHitsNotice(conn, noticeNo); if(result > 0) {
	 * JDBCTemplate.commit(conn); }else { JDBCTemplate.rollback(conn); } } catch
	 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace();
	 * }finally { JDBCTemplate.close(conn); } return result; }
	 * 
	 * }
	 */