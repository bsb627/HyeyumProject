package file.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import file.model.vo.FileData;
import movie.model.vo.MovieInfo;
import movie.model.vo.MovieRecommend;

public class MovieFileDAO {

	public int insertFileMovieInfo(Connection conn, FileData fileData, MovieInfo info) {
		PreparedStatement pstmt = null;
		int result = 0;
		String fileType = fileData.getFileType();
		String query="INSERT INTO MOVIE_FILE VALUES(SEQ_MOVIE_FILE.NEXTVAL,?,?,?,?,?,NULL)";
	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fileData.getFileName());
			pstmt.setString(2, fileData.getFilePath());
			pstmt.setLong(3, fileData.getFileSize());
			pstmt.setTimestamp(4, fileData.getUploadTime());
			pstmt.setInt(5, getMovieInfoNo(conn,info));
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	private int getMovieInfoNo(Connection conn, MovieInfo info) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT INFO_NO FROM MOVIE_INFO WHERE MOVIE_NAME= ? AND GENRE = ? AND CAST = ? AND DIRECTOR = ? AND AGE_GROUP = ? AND RUNTIME = ? AND SYNOPSIS = ? ORDER BY ENROLL_DATE DESC";
		int infoNo = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, info.getMovieName());
			pstmt.setString(2, info.getGenre());
			pstmt.setString(3, info.getCast());
			pstmt.setString(4, info.getDirector());
			pstmt.setString(5, info.getAgeGroup());
			pstmt.setString(6, info.getRunTime());
			pstmt.setString(7, info.getSynopsis());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				infoNo = rset.getInt("INFO_NO");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return infoNo;
	}

	public ArrayList<FileData> selectMovieInfoFileList(Connection conn) {
		//System.out.println("select list dao");
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FileData> list = null;
		String query = "SELECT INFO_NO, FILE_NO, FILE_NAME, FILE_PATH, FILE_SIZE, UPLOAD FROM MOVIE_FILE JOIN MOVIE_INFO USING (INFO_NO) WHERE INFO_NO IS NOT NULL";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			list = new ArrayList<FileData>();
			while(rset.next()) {
				FileData data = new FileData();
				data.setNo(rset.getInt("INFO_NO"));
				data.setFileNo(rset.getInt("FILE_NO"));
				data.setFileName(rset.getString("FILE_NAME"));
				data.setFilePath(rset.getString("FILE_PATH"));
				data.setFileSize(rset.getLong("FILE_SIZE"));
				data.setUploadTime(rset.getTimestamp("UPLOAD"));
				list.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		//System.out.println("파일리스트 :" + list);
		return list;
	}

	public int updateMovieFileInfo(Connection conn, FileData fileData, MovieInfo info) {
		System.out.println("Modify DAO");
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MOVIE_FILE SET FILE_NAME =?, FILE_PATH=?,FILE_SIZE=?, UPLOAD=? WHERE INFO_NO = ?";
	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fileData.getFileName());
			pstmt.setString(2, fileData.getFilePath());
			pstmt.setLong(3, fileData.getFileSize());
			pstmt.setTimestamp(4, fileData.getUploadTime());
			pstmt.setInt(5, info.getInfoNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			JDBCTemplate.close(pstmt);
		}
		System.out.println("Modify DAO result : " + result);
		return result;
	}

	public int deleteMovieFileInfo(Connection conn, String filePath, String fileUser) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM FILETBL WHERE FILEPATH = ? AND FILEUSER = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, filePath);
			pstmt.setString(2, fileUser);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	/*
	

	public int deleteMovieFile(Connection conn, String filePath, String fileUser) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateMovieFileInfo(Connection conn, FileData fileData, MovieInfo movieInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public FileData selectMovieFileOne(Connection conn, int movieNo) {
		// TODO Auto-generated method stub
		return null;
	}

	/////////////Movie Recommend
	
	public int insertFileRecommend(Connection conn, FileData fileData, MovieRecommend recommend) {
		PreparedStatement pstmt = null;
		int result = 0;
		String fileType = fileData.getFileType();
		String query="INSERT INTO MOVIE_FILE VALUES(SEQ_MOVIE_FILE.NEXTVAL,?,?,?,?,NULL,?)";
		//FILE_NO, FILE_NAME, FILE_PATH, FILE_SIZE, UPLOAD, INFO_NO, RECOMMEND_NO
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fileData.getFileName());
			pstmt.setString(2, fileData.getFilePath());
			pstmt.setLong(3, fileData.getFileSize());
			pstmt.setTimestamp(4, fileData.getUploadTime());
			pstmt.setInt(5, getRowNo(conn, recommend)); // RECOMMEND_NO
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	private int getRowNo(Connection conn, MovieRecommend recommend) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT RECOMMEND_NO FROM MOVIE_RECOMMEND WHERE GENRE = ? AND TITLE = ? AND CONTENTS = ? AND HITS = ? AND USER_ID = ? ORDER BY ENROLL_DATE DESC";
		int recommendNo = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, recommend.getGenre());
			pstmt.setString(2, recommend.getTitle());
			pstmt.setString(3, recommend.getContents());
			pstmt.setInt(4, recommend.getHits());
			pstmt.setString(5, recommend.getUserId());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recommendNo = rset.getInt(recommendNo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("recommend" + recommendNo);
		return recommendNo;
	}
	

	public ArrayList<FileData> selectFileRecommendList(Connection conn, String type) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FileData> list = null;
		String query = "SELECT RECOMMEND_NO,FILE_NO,FILE_NAME,FILE_PATH,FILE_SIZE, UPLOAD FROM MOVIE_FILE JOIN MOVIE_RECOMMEND USING (RECOMMEND_NO) WHERE RECOMMEND_NO IS NOT NULL";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			list = new ArrayList<FileData>();
			while(rset.next()) {
				FileData data = new FileData();
				data.setNo(rset.getInt("RECOMMEND_NO"));
				data.setFileNo(rset.getInt("FILE_NO"));
				data.setFileName(rset.getString("FILE_NAME"));
				data.setFilePath(rset.getString("FILE_PATH"));
				data.setFileSize(rset.getLong("FILE_SIZE"));
				data.setUploadTime(rset.getTimestamp("UPLOAD"));
				list.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int deleteFileRecommend(Connection conn, String filePath, String fileUser) {
			
			PreparedStatement pstmt = null;
			int result = 0;
			String query = "DELETE FROM FILETBL WHERE FILEPATH = ? AND FILEUSER = ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, filePath);
				pstmt.setString(2, fileUser);
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
		}

	public int updateFileRecommend(Connection conn, FileData fileData, MovieRecommend recommend) {
		PreparedStatement pstmt = null;
		int result = 0;
		String fileType = fileData.getFileType();
		String  query = "UPDATE MOVIE_FILE SET FILE_NAME =?, FILE_PATH=?,FILE_SIZE=?,UPLOAD=? WHERE RECOMMEND_NO =?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fileData.getFileName());
			pstmt.setString(2, fileData.getFilePath());
			pstmt.setLong(3, fileData.getFileSize());
			pstmt.setTimestamp(4, fileData.getUploadTime());
			pstmt.setInt(5, recommend.getNo());
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public FileData selectFileOneRecommend(Connection conn, int recommendNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MOVIE_FILE WHERE RECOMMEND_NO=?";
		FileData fileData = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, recommendNo);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				fileData = new FileData();
				fileData.setFileNo(rset.getInt("FILE_NO"));
				fileData.setFileName(rset.getString("FILE_NAME"));
				fileData.setFilePath(rset.getString("FILE_PATH"));
				fileData.setFileSize(rset.getLong("FILE_SIZE"));
				fileData.setUploadTime(rset.getTimestamp("UPLOAD_TIME"));
				fileData.setNo(rset.getInt("RECOMMEND_NO"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return fileData;
	}
	
	*/
}
