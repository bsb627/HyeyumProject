package file.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import file.model.dao.FileDAO;
import file.model.vo.FileData;
import movie.model.vo.MovieRecommend;
import show.model.vo.ShowInfo;
import show.model.vo.ShowReview;

public class MovieFileService {
	
	private JDBCTemplate factory;
	
	public MovieFileService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public int registerMovieFileInfo(FileData fileData, MovieRecommend recommend) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new FileDAO().insertMovieFileInfo(conn, fileData, recommend);
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
			list = new FileDAO().selectMovieFileList(conn, type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return list;
	}

	public int removeMovieFile(String filePath, String fileUser) {
		
		Connection conn =null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new FileDAO().deleteMovieFile(conn, filePath, fileUser);
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

	public int updateMovieFileInfo(FileData fileData, ShowReview review) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new FileDAO().updateMovieFileInfo(conn, fileData, review);
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

	public FileData printMovieFile(int showNo) {
		FileData fileData = null;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			fileData = new FileDAO().selectMovieFileOne(conn,showNo);
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

	public ArrayList<FileData> printMovieInfoFileList() {
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

	public int updateFileMovieInfo(FileData fileData, ShowInfo info) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new FileDAO().updateFileMovieInfo(conn, fileData, info);
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

	public ArrayList<FileData> printMovieReviewFileList() {
		Connection conn = null;
		ArrayList<FileData> list = null;
		
		try {
			conn = factory.createConnection();
			list = new FileDAO().selectMovieReviewFileList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return list;
	}
}
