package company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			pstmt.setString(3, company.getPhone());
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

	public ArrayList<Company> selectAllCompanyList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM COMPANY ORDER BY ENROLL_DATE DESC";
		ArrayList<Company> cList = null;
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if( rset != null) {
				cList = new ArrayList<Company>();
				while(rset.next()) {
					Company company = new Company();
					company.setCompanyCode(rset.getInt("COMPANY_CODE"));
					company.setCompanyName(rset.getString("COMPANY_NAME"));
					company.setCompanyNumber(rset.getInt("COMPANY_NUMBER"));
					company.setPhone(rset.getString("PHONE"));
					company.setContents(rset.getString("CONTENTS"));
					company.setAddress(rset.getString("ADDRESS"));
					company.setEmail(rset.getString("EMAIL"));
					company.setPartnership(rset.getString("PARTNERSHIP"));
					company.setEnrollDate(rset.getDate("ENROLL_DATE"));
					cList.add(company);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return cList;
	}

	public int deleteCompany(Connection conn, String companyNo) {
		Statement stmt = null;
		String query = "DELETE FROM COMPANY WHERE COMPANY_CODE IN ("+companyNo+")";
		int result = 0;
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(stmt);
		}
		// TODO Auto-generated method stub
		return result;
	}

	public int updateCompany(Connection conn, String state, int no) {
		Statement stmt = null;
		int result = 0;
		String query = "";
		if(state.equals("N")) {
			query = "UPDATE COMPANY SET PARTNERSHIP = 'Y' WHERE COMPANY_CODE = "+no+"";
		}else if(state.equals("Y")) {
			query = "UPDATE COMPANY SET PARTNERSHIP = 'N' WHERE COMPANY_CODE = "+no+"";
		}
		
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


	
}
