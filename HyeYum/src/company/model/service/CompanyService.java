package company.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.JDBCTemplate;
import company.model.dao.CompanyDAO;
import company.model.vo.Company;
import company.model.vo.CompanyPageData;
import qna.model.dao.QnaDAO;

public class CompanyService {
	
	private JDBCTemplate factory;

	public CompanyService() {
		factory = JDBCTemplate.getConnection();
		
	}

	public int registerCompany(Company company) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new CompanyDAO().registerCompany(conn, company);
			if(result > 0) {
				JDBCTemplate.commit(conn);
				
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	


	
}

