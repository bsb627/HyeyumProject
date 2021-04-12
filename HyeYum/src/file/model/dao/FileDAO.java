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

	public ArrayList<FileData> selectFileList(Connection conn, String userId) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FileData> list = null;
		String query = "SELECT * FROM FILETBL WHERE FILEUSER = ?";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setNString(1, userId);
			rset = pstmt.executeQuery();
			list = new ArrayList<FileData>();
			while(rset.next()) {
				FileData data = new FileData();
				data.setFileName(rset.getString("FILENAME"));
				data.setFilePath(rset.getString("FILEPATH"));
				data.setFileSize(rset.getLong("FILESIZE"));
				data.setFileUser(rset.getString("FILEUSER"));
				data.setUploadTime(rset.getTimestamp("UPLOADTIME"));
				list.add(data); // 최종 저장소인 list에 한 개의 행을 하나씩 저장함
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

}
