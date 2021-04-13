package file.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import file.model.dao.FileDAO;
import file.model.vo.FileData;
import show.model.vo.ShowInfo;
import show.model.vo.ShowReview;

public class FileService {
	
	private JDBCTemplate factory;
	
	public FileService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public int registerFileInfo(FileData fileData, ShowReview review) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new FileDAO().insertFileInfo(conn, fileData, review);
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

	public ArrayList<FileData> printFileList(String type) {
		Connection conn = null;
		ArrayList<FileData> list = null;
		
		try {
			conn = factory.createConnection();
			list = new FileDAO().selectFileList(conn, type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return list;
	}

	public int removeFile(String filePath, String fileUser) {
		
		Connection conn =null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new FileDAO().deleteFile(conn, filePath, fileUser);
			System.out.println("service result : " + result);
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

	public int updateFileInfo(FileData fileData, ShowReview review) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new FileDAO().updateFileInfo(conn, fileData, review);
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

	public FileData printFile(int showNo) {
		FileData fileData = null;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			fileData = new FileDAO().selectFileOne(conn,showNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return fileData;
	}

	public int registerFileShowInfo(FileData fileData, ShowInfo info) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new FileDAO().insertFileShowInfo(conn, fileData, info);
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

	public ArrayList<FileData> printShowInfoFileList() {
		Connection conn = null;
		ArrayList<FileData> list = null;
		
		try {
			conn = factory.createConnection();
			list = new FileDAO().selectShowInfoFileList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return list;
	}
}
