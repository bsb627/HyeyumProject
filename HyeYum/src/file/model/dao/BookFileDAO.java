package file.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.model.vo.BookInfo;
import book.model.vo.BookShare;
import common.JDBCTemplate;
import file.model.vo.FileData;

public class BookFileDAO {
	
	// BookInfo
	public int insertFileInfo(Connection conn, FileData fileData, BookInfo info) {
		PreparedStatement pstmt = null;
		int result = 0;
		String fileType = fileData.getFileType();
		String query="INSERT INTO BOOK_INFO_FILE VALUES(SEQ_BOOK_INFO_FILE.NEXTVAL,?,?,?,'admin',?,?)";
	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fileData.getFileName());
			pstmt.setString(2, fileData.getFilePath());
			pstmt.setLong(3, fileData.getFileSize());
			pstmt.setTimestamp(4, fileData.getUploadTime());
			pstmt.setInt(5, getInfoNo(conn,info));
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	private int getInfoNo(Connection conn, BookInfo info) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT INFO_NO FROM BOOK_INFO WHERE BOOK_NAME = ? AND GENRE = ? AND AUTHOR = ? AND PUBLISHER = ? AND INTRO =? ORDER BY INFO_NO ASC";
		int infoNo =  0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, info.getBookName());
			pstmt.setString(2, info.getGenre());
			pstmt.setString(3, info.getAuthor());
			pstmt.setString(4, info.getPublisher());
			pstmt.setString(5, info.getIntro());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				infoNo = rset.getInt("INFO_NO");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return infoNo;
		
	}

	public ArrayList<FileData> selectFileListInfo(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FileData> list = null;
		String query="SELECT INFO_NO,FILE_NO,FILE_NAME,FILE_PATH,FILE_SIZE,FILE_USER,UPLOAD_TIME FROM BOOK_INFO_FILE JOIN BOOK_INFO USING (INFO_NO) WHERE INFO_NO IS NOT NULL";
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
				data.setUploadTime(rset.getTimestamp("UPLOAD_TIME"));
				list.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int deleteFileInfo(Connection conn, String filePath, String fileUser) {
		
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

	public int updateFileInfo(Connection conn, FileData fileData, BookInfo info) {
		PreparedStatement pstmt = null;
		int result = 0;
		String fileType = fileData.getFileType();
		String query= "UPDATE BOOK_INFO_FILE SET FILE_NAME =?, FILE_PATH=?,FILE_SIZE=?,UPLOAD_TIME=? WHERE INFO_NO =?";
	
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
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public FileData selectFileOneInfo(Connection conn, int infoNo) { 
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM BOOk_INFO_FILE WHERE INFO_NO=?";
		FileData fileData = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, infoNo);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				fileData = new FileData();
				fileData.setFileNo(rset.getInt("FILE_NO"));
				fileData.setFileName(rset.getString("FILE_NAME"));
				fileData.setFilePath(rset.getString("FILE_PATH"));
				fileData.setFileSize(rset.getLong("FILE_SIZE"));
				fileData.setFileUser(rset.getNString("FILE_USER"));
				fileData.setUploadTime(rset.getTimestamp("UPLOAD_TIME"));
				fileData.setNo(rset.getInt("INFO_NO"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return fileData;
	}

	// BookShare
	public int insertFileShare(Connection conn, FileData fileData, BookShare share) {
		PreparedStatement pstmt = null;
		int result = 0;
		String fileType = fileData.getFileType();
		String query="INSERT INTO BOOK_SHARE_FILE VALUES(SEQ_BOOK_SHARE_FILE.NEXTVAL,?,?,?,?,?,?)";
		 	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fileData.getFileName());
			pstmt.setString(2, fileData.getFilePath());
			pstmt.setLong(3, fileData.getFileSize());
			pstmt.setString(4, fileData.getFileUser());
			pstmt.setTimestamp(5, fileData.getUploadTime());
			pstmt.setInt(6, getShareNo(conn, share)); // SHARE_NO
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	private int getShareNo(Connection conn, BookShare share) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT SHARE_NO FROM BOOK_SHARE WHERE REGION = ? AND TITLE= ? AND CONTENTS = ? AND USER_ID = ? ORDER BY ENROLL_DATE DESC";
		int shareNo = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, share.getRegion());
			pstmt.setString(2, share.getTitle());
			pstmt.setString(3, share.getContents());
			pstmt.setString(4, share.getUserId());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				shareNo = rset.getInt("SHARE_NO");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shareNo;
	}

	public ArrayList<FileData> selectFileListShare(Connection conn, String type) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FileData> list = null;
		String query ="SELECT INFO_NO,FILE_NO,FILE_NAME,FILE_PATH,FILE_SIZE,UPLOAD_TIME FROM BOOK_SHARE_FILE JOIN BOOK_SHARE USING (SHARE_NO) WHERE SHARE_NO IS NOT NULL";
				
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
				data.setUploadTime(rset.getTimestamp("UPLOAD_TIME"));
				list.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int deleteFileShare(Connection conn, String filePath, String fileUser) {
		
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
	
	public int updateFileShare(Connection conn, FileData fileData, BookShare share) {
		PreparedStatement pstmt = null;
		int result = 0;
		String fileType = fileData.getFileType();
		String  query = "UPDATE BOOK_SHARE_FILE SET FILE_NAME =?, FILE_PATH=?,FILE_SIZE=?,UPLOAD_TIME=? WHERE SHARE_NO =?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fileData.getFileName());
			pstmt.setString(2, fileData.getFilePath());
			pstmt.setLong(3, fileData.getFileSize());
			pstmt.setTimestamp(4, fileData.getUploadTime());
			pstmt.setInt(5, share.getNo());
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public FileData selectFileOneShare(Connection conn, int shareNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM BOOK_SHARE_FILE WHERE SHARE_NO=?";
		FileData fileData = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, shareNo);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				fileData = new FileData();
				fileData.setFileNo(rset.getInt("FILE_NO"));
				fileData.setFileName(rset.getString("FILE_NAME"));
				fileData.setFilePath(rset.getString("FILE_PATH"));
				fileData.setFileSize(rset.getLong("FILE_SIZE"));
				fileData.setUploadTime(rset.getTimestamp("UPLOAD_TIME"));
				fileData.setNo(rset.getInt("SHARE_NO"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return fileData;
	}
}
