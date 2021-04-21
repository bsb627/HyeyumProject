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
	
	
	
	//==================관리자============================//

	public int countAllBook() {
		Connection conn = null;
		int bookAllCount = 0;
		
		try {
			conn = factory.createConnection();
			bookAllCount = new DonateDAO().countAllBook(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return bookAllCount;
	}

	public int countAllMovie() {
		Connection conn = null;
		int movieAllCount = 0;
		
		try {
			conn = factory.createConnection();
			movieAllCount = new DonateDAO().countAllMovie(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return movieAllCount;
	}

	public int countAllShow() {
		Connection conn = null;
		int showAllCount = 0;
		
		try {
			conn = factory.createConnection();
			showAllCount = new DonateDAO().countAllShow(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return showAllCount;
	}

	public int countAllMember() {
		Connection conn = null;
		int memberAllCount = 0;
		
		try {
			conn = factory.createConnection();
			memberAllCount = new DonateDAO().countAllMember(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return memberAllCount;
	}

	public int countAllCompany() {
		Connection conn = null;
		int companyrAllCount = 0;
		
		try {
			conn = factory.createConnection();
			companyrAllCount = new DonateDAO().countAllCompany(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return companyrAllCount;
	}

	


}
