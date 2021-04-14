package admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.vo.Member;
import show.model.vo.ShowInfo;

public class AdminDAO {

	public ArrayList<ShowInfo> selectAllShowInfoList(Connection conn) { // 관리자 공연 정보 리스트 출력

		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM SHOW_INFO ORDER BY ENROLL_DATE DESC";
		ArrayList<ShowInfo> sList = null;
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset != null) {
				sList = new ArrayList<ShowInfo>();
				while (rset.next()) {
					ShowInfo info = new ShowInfo();
					info.setInfoNo(rset.getInt("INFO_NO"));
					info.setType(rset.getString("TYPE"));
					info.setGenre(rset.getString("GENRE"));
					info.setRegion(rset.getString("REGION"));
					info.setPlace(rset.getString("PLACE"));
					info.setShowName(rset.getString("SHOW_NAME"));
					info.setTermDate(rset.getString("TERM_DATE"));
					info.setAgeGroup(rset.getString("AGE_GROUP"));
					info.setRunTime(rset.getInt("RUN_TIME"));
					info.setCast(rset.getString("CAST"));
					info.setPrice(rset.getInt("PRICE"));
					info.setEnrollDate(rset.getDate("ENROLL_DATE"));
					sList.add(info);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		
		return sList;
	}

	public int insertShowInfo(Connection conn, ShowInfo info) { // 관리자단 공연 정보 등록 
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO SHOW_INFO VALUES(SEQ_SHOW_INFO_NO.NEXTVAL,?,?,?,?,?,?,?,?,?,?,SYSDATE)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, info.getType());
			pstmt.setString(2, info.getGenre());
			pstmt.setString(3, info.getRegion());
			pstmt.setString(4, info.getPlace());
			pstmt.setString(5, info.getShowName());
			pstmt.setString(6, info.getTermDate());
			pstmt.setString(7, info.getAgeGroup());
			pstmt.setInt(8, info.getRunTime());
			pstmt.setString(9, info.getCast());
			pstmt.setInt(10, info.getPrice());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}

	public ShowInfo selectOneShowInfo(Connection conn, int infoNo) {
			
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		String query ="SELECT * FROM SHOW_INFO WHERE INFO_NO = ?";
		ShowInfo info = new ShowInfo();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, infoNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				info.setInfoNo(rset.getInt("INFO_NO"));
				info.setType(rset.getString("TYPE"));
				info.setGenre(rset.getString("GENRE"));
				info.setRegion(rset.getString("REGION"));
				info.setPlace(rset.getString("PLACE"));
				info.setShowName(rset.getString("SHOW_NAME"));
				info.setTermDate(rset.getString("TERM_DATE"));
				info.setAgeGroup(rset.getString("AGE_GROUP"));
				info.setRunTime(rset.getInt("RUN_TIME"));
				info.setCast(rset.getString("CAST"));
				info.setPrice(rset.getInt("PRICE"));
				info.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return info;
	}

	public int deleteShowInfo(Connection conn, String infoNo) {
		Statement stmt = null;
		int result = 0;
		String query = "DELETE FROM SHOW_INFO WHERE INFO_NO IN ("+infoNo+")";
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(stmt);
		}
		
		return result;
	}

	public int updateShowInfo(Connection conn, ShowInfo info) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE SHOW_INFO SET TYPE = ?, GENRE = ?, REGION = ?, PLACE = ?, SHOW_NAME = ?, TERM_DATE = ?, AGE_GROUP = ?, RUN_TIME = ?, CAST = ?, PRICE = ? WHERE INFO_NO = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, info.getType());
			pstmt.setString(2, info.getGenre());
			pstmt.setString(3, info.getRegion());
			pstmt.setString(4, info.getPlace());
			pstmt.setString(5, info.getShowName());
			pstmt.setString(6, info.getTermDate());
			pstmt.setString(7, info.getAgeGroup());
			pstmt.setInt(8, info.getRunTime());
			pstmt.setString(9, info.getCast());
			pstmt.setInt(10, info.getPrice());
			pstmt.setInt(11, info.getInfoNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return result ;
	}



}
