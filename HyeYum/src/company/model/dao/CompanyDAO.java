package company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import company.model.vo.Company;

public class CompanyDAO {

	

	public int registerCompany(Connection conn, Company company) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO COMPANY "
				+ "VALUES(SEQ_COMPANY.NEXTVAL,?,?,?,SYSDATE)";  
		
		try {
			pstmt = conn.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}


	
}
