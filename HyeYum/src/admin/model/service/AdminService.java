package admin.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import admin.model.dao.AdminDAO;
import common.JDBCTemplate;
import show.model.vo.ShowInfo;

public class AdminService {

	private JDBCTemplate factory;
	public AdminService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public ArrayList<ShowInfo> printAllShowInfoList() { // 관리자 공연 정보 리스트 출력
		ArrayList<ShowInfo> sList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			sList = new AdminDAO().selectAllShowInfoList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return sList;
	}

	public int registerShowInfo(ShowInfo info) { // 관리자 공연 정보 등록
		int result = 0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new AdminDAO().insertShowInfo(conn,info);
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
