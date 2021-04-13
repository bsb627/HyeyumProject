package admin.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import show.model.vo.ShowInfo;

public class AdminDAO {

	public ArrayList<ShowInfo> selectAllShowInfoList(Connection conn) { // 관리자 공연 정보 리스트 출력

		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM SHOW_INFO";
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

}
