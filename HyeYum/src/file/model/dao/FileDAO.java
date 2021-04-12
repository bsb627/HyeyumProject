package file.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import file.model.vo.FileData;
import show.model.vo.ShowReview;

public class FileDAO {

	public int insertFileInfo(Connection conn, FileData fileData, ShowReview review) {
		PreparedStatement pstmt = null;
		int result = 0;
		String fileType = fileData.getFileType();
		String query="";
		switch (fileType) {
		case "book": query = "";
			
			break;
		case "share": query = "";
			
			break;
		case "movie": query = "";
			
			break;
		case "show": query = "INSERT INTO SHOW_FILE VALUES(SEQ_SHOW_FILE_NO.NEXTVAL,?,?,?,?,?,NULL)";
		
		break;

		default:
			break;
		}
	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fileData.getFileName());
			pstmt.setString(2, fileData.getFilePath());
			pstmt.setLong(3, fileData.getFileSize());
			pstmt.setTimestamp(4, fileData.getUploadTime());
			pstmt.setInt(5, getReviewNo(conn,review));
			result = pstmt.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	private int getReviewNo(Connection conn, ShowReview review) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT REVIEW_NO FROM SHOW_REVIEW WHERE TITLE = ? AND CONTENTS = ? AND SNS_LINK = ? AND TICKET_NUMBER = ? AND USER_ID =? ORDER BY ENROLL_DATE DESC";
		int showNo =  0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, review.getTitle());
			pstmt.setString(2, review.getContents());
			pstmt.setString(3, review.getSnsLink());
			pstmt.setString(4, review.getTicketNumber());
			pstmt.setString(5, review.getNick());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				showNo = rset.getInt("REVIEW_NO");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return showNo;
		
	}

	public ArrayList<FileData> selectFileList(Connection conn, String type) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FileData> list = null;
		String query = "";
		switch (type) {
		case "book":
			
			break;
		case "share":
			
			break;
		case "movie":
			
			break;
		case "show":
			query="SELECT REVIEW_NO,FILE_NO,FILE_NAME,FILE_PATH,FILE_SIZE,USER_ID,UPLOAD_TIME FROM SHOW_FILE JOIN SHOW_REVIEW USING (REVIEW_NO) WHERE REVIEW_NO IS NOT NULL";
			
			break;

		default:
			break;
		}
		
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			list = new ArrayList<FileData>();
			while(rset.next()) {
				FileData data = new FileData();
				data.setNo(rset.getInt("REVIEW_NO"));
				data.setFileNo(rset.getInt("FILE_NO"));
				data.setFileName(rset.getString("FILE_NAME"));
				data.setFilePath(rset.getString("FILE_PATH"));
				data.setFileSize(rset.getLong("FILE_SIZE"));
				data.setFileUser(rset.getString("USER_ID"));
				data.setFileType(type);
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

	public int deleteFile(Connection conn, String filePath, String fileUser) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM FILETBL WHERE FILEPATH = ? AND FILEUSER = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, filePath);
			pstmt.setString(2, fileUser);
			result = pstmt.executeUpdate();
			System.out.println("DAOresult : " + result );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateFileInfo(Connection conn, FileData fileData, ShowReview review) {
		PreparedStatement pstmt = null;
		int result = 0;
		String fileType = fileData.getFileType();
		String query="";
		switch (fileType) {
		case "book": query = "";
			
			break;
		case "share": query = "";
			
			break;
		case "movie": query = "";
			
			break;
		case "show": query = "UPDATE SHOW_FILE SET FILE_NAME =?, FILE_PATH=?,FILE_SIZE=?,UPLOAD_TIME=? WHERE REVIEW_NO =?";
		
		break;

		default:
			break;
		}
	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fileData.getFileName());
			pstmt.setString(2, fileData.getFilePath());
			pstmt.setLong(3, fileData.getFileSize());
			pstmt.setTimestamp(4, fileData.getUploadTime());
			pstmt.setInt(5, review.getNo());
			result = pstmt.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
