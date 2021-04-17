package file.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import book.model.vo.BookShare;
import common.JDBCTemplate;
import file.model.dao.BookFileDAO;
import file.model.dao.FileDAO;
import file.model.dao.MovieFileDAO;
import file.model.vo.FileData;
import movie.model.vo.MovieInfo;
import movie.model.vo.MovieRecommend;


public class MovieFileService {
	
	private JDBCTemplate factory;
	
	public MovieFileService() {
		factory = JDBCTemplate.getConnection();
	}
	
	
	/*
	 * 
	 
	// MovieInfo
	public int registerMovieFileInfo(FileData fileData, MovieInfo movieInfo) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new MovieFileDAO().insertMovieFileInfo(conn, fileData, movieInfo);
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

	public ArrayList<FileData> printMovieFileList(String type) {
		Connection conn = null;
		ArrayList<FileData> list = null;
		
		try {
			conn = factory.createConnection();
			list = new MovieFileDAO().selectMovieFileList(conn, type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return list;
	}

	public int removeMovieFileInfo(String filePath, String fileUser) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new MovieFileDAO().deleteMovieFile(conn, filePath, fileUser);
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

	public int updateMovieFileInfo(FileData fileData, MovieInfo movieInfo) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new MovieFileDAO().updateMovieFileInfo(conn, fileData, movieInfo);
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

	public FileData printMovieFileInfo(int movieNo) {
		FileData fileData = null;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			fileData = new MovieFileDAO().selectMovieFileOne(conn, movieNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return fileData;
	}

	/////////////Movie Recommend
	
	public int registerFileRecommend(FileData fileData, MovieRecommend recommend) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new MovieFileDAO().insertFileRecommend(conn, fileData, recommend);
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

	public ArrayList<FileData> printFileRecommendList(String type) {
		Connection conn = null;
		ArrayList<FileData> list = null;
		
		try {
			conn = factory.createConnection();
			list = new MovieFileDAO().selectFileRecommendList(conn, type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return list;
	}

	public int removeFileRecommend(String filePath, String fileUser) {
		
		Connection conn =null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new MovieFileDAO().deleteFileRecommend(conn, filePath, fileUser);
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

	public int updateFileRecommend(FileData fileData, MovieRecommend recommend) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new MovieFileDAO().updateFileRecommend(conn, fileData, recommend);
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

	public FileData printFileRecommend(int recommendNo) { // FileDate를 받아 넘겨줌
		FileData fileData = null;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			fileData = new MovieFileDAO().selectFileOneRecommend(conn,recommendNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return fileData;
	}
		
*/


}
