package file.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import file.model.vo.FileData;

public class FileDAO {

	public int insertFileInfo(Connection conn, FileData fileData) {
		PreparedStatement pstmt = null;
		int result = 0;
		String fileType = fileData.getFileType();
		String query="";
		switch (fileType) {
		case "book": query = "INSERT INTO BOOKFILETBL () VALUES(?,?,?,?,?)";
			
			break;
		case "share": query = "INSERT INTO BOOKEFILETBL () VALUES(?,?,?,?,?)";
			
			break;
		case "movie": query = "INSERT INTO SHAREFILETBL VALUES(?,?,?,?,?)";
			
			break;

		default:
			break;
		}
	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fileData.getFileName());
			pstmt.setString(2, fileData.getFilePath());
			pstmt.setLong(3, fileData.getFileSize());
			pstmt.setString(4, fileData.getFileUser());
			pstmt.setTimestamp(5, fileData.getUploadTime());
			result = pstmt.executeUpdate();
			
			System.out.println(fileData.getFileName());
			System.out.println(fileData.getFilePath());
			System.out.println(fileData.getFileUser());
			System.out.println(fileData.getFileSize());
			System.out.println(fileData.getUploadTime());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
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
