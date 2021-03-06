package admin.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import admin.model.dao.AdminDAO;
import admin.model.dao.BookAdminDAO;
import book.model.vo.BookInfo;
import book.model.vo.BookReview;
import book.model.vo.BookShare;
import common.JDBCTemplate;
import show.model.vo.ShowInfo;
import show.model.vo.ShowReview;

public class BookAdminService {

	private JDBCTemplate factory;
	public BookAdminService() {
		factory = JDBCTemplate.getConnection();
	}
	
	// BookInfo
	public ArrayList<BookInfo> printAllBookInfoList() { 
		ArrayList<BookInfo> bList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			bList = new BookAdminDAO().selectAllBookInfoList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return bList;
	}

	public int registerBookInfo(BookInfo info) { 
		int result = 0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new BookAdminDAO().insertBookInfo(conn,info);
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

	public BookInfo printOneBookInfo(int infoNo) {
		BookInfo info = null;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			info = new BookAdminDAO().selectOneBookInfo(conn, infoNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return info;
	}

	public int deleteBookInfo(String infoNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new BookAdminDAO().deleteBookInfo(conn, infoNo);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}

	public int updateBookInfo(BookInfo info) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new BookAdminDAO().updateBookInfo(conn, info);
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
	// BookReview
	public ArrayList<BookReview> printAllBookReviewList() { 
		ArrayList<BookReview> rList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			rList = new BookAdminDAO().selectAllBookReviewList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return rList;
	}

	public int deleteBookReview(String reviewNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new BookAdminDAO().deleteBookReview(conn, reviewNo);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}
	// BookShare
	public ArrayList<BookShare> printAllBookShareList() {
		ArrayList<BookShare> rList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			rList = new BookAdminDAO().selectAllBookShareList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return rList;
	}

	public int deleteBookShare(String shareNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new BookAdminDAO().deleteBookShare(conn, shareNo);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}

}
