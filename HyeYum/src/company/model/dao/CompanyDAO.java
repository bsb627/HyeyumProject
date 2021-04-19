package company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import company.model.vo.Company;

public class CompanyDAO {

	

	public int registerCompany(Connection conn, Company company) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO COMPANY VALUES (SEQ_COMPANY_NO.NEXTVAL,?,?,?,?,?,?,'N',SYSDATE)";  
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, company.getCompanyName());
			pstmt.setInt(2, company.getCompanyNumber());
			pstmt.setInt(3, company.getPhone());
			pstmt.setString(4, company.getContents());
			pstmt.setString(5, company.getAddress());
			pstmt.setString(6, company.getEmail());
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
