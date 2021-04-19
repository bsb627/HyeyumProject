package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.JDBCTemplate;
import member.model.dao.DonateDAO;

public class DonateService {
	
	private JDBCTemplate factory;
	
	public DonateService() {
		factory = JDBCTemplate.getConnection();
	}

	public int countBook(String userId) {
		Connection conn = null;
		int bookCount = 0;
		
		try {
			conn = factory.createConnection();
			bookCount = new DonateDAO().countBook(conn, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return bookCount;
	}

	public int countMovie(String userId) {
		Connection conn = null;
		int movieCount = 0;
		
		try {
			conn = factory.createConnection();
			movieCount = new DonateDAO().countMovie(conn, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return movieCount;
	}

	public int countShow(String userId) {
		Connection conn = null;
		int showCount = 0;
		
		try {
			conn = factory.createConnection();
			showCount = new DonateDAO().countShow(conn, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return showCount;
	}

}
