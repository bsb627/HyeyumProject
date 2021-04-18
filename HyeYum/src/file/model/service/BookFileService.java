package file.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import book.model.vo.BookInfo;
import book.model.vo.BookReview;
import book.model.vo.BookShare;
import common.JDBCTemplate;
import file.model.dao.BookFileDAO;
import file.model.dao.FileDAO;
import file.model.vo.FileData;
import show.model.vo.ShowInfo;
import show.model.vo.ShowReview;

public class BookFileService {
	
	private JDBCTemplate factory;
	
	public BookFileService() {
		factory = JDBCTemplate.getConnection();
	}
	// BookInfo
	public int registerFileInfo(FileData fileData, BookInfo info) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new BookFileDAO().insertFileInfo(conn, fileData, info);
			if(result> 0) {
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

	public ArrayList<FileData> printFileList() {
		Connection conn = null;
		ArrayList<FileData> list = null;
		
		try {
			conn = factory.createConnection();
			list = new BookFileDAO().selectFileListInfo(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return list;
	}

	public int removeFileInfo(String filePath, String fileUser) {
		
		Connection conn =null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new FileDAO().deleteFile(conn, filePath, fileUser);
			if(result > 0 ) {
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

	public int updateFileInfo(FileData fileData, BookInfo info) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new BookFileDAO().updateFileInfo(conn, fileData, info);
			if(result> 0) {
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

	public FileData printFileInfo(int infoNo) {
		FileData fileData = null;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			fileData = new BookFileDAO().selectFileOneInfo(conn,infoNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return fileData;
	}

		
	// BookShare
	public int registerFileShare(FileData fileData, BookShare share) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new BookFileDAO().insertFileShare(conn, fileData, share);
			if(result> 0) {
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

	public ArrayList<FileData> printFileShareList(String type) {
		Connection conn = null;
		ArrayList<FileData> list = null;
		
		try {
			conn = factory.createConnection();
			list = new BookFileDAO().selectFileListShare(conn, type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return list;
	}

	public int removeFileShare(String filePath, String fileUser) {
		
		Connection conn =null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new FileDAO().deleteFile(conn, filePath, fileUser);
			if(result > 0 ) {
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

	public int updateFileShare(FileData fileData, BookShare share) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new BookFileDAO().updateFileShare(conn, fileData, share);
			if(result> 0) {
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

	public FileData printFileShare(int shareNo) { // FileDate를 받아 넘겨줌
		FileData fileData = null;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			fileData = new BookFileDAO().selectFileOneShare(conn,shareNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return fileData;
	}
		
}
