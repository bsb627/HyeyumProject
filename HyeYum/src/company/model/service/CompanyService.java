package company.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.JDBCTemplate;
import company.model.dao.CompanyDAO;
import company.model.vo.Company;
import company.model.vo.CompanyPageData;

public class CompanyService {
	
	private JDBCTemplate factory;

	public CompanyService() {
		factory = new JDBCTemplate().getConnection();
		
	}
	
	// 전체 출력
	public CompanyPageData printAllCompany(int currentPage) {
		Connection conn = null;
		CompanyPageData pd = new CompanyPageData();
		try {
			conn = factory.createConnection();
			pd.setCompanyList(new CompanyDAO().selectAllList(conn, currentPage));
			pd.setPageNavi(new CompanyDAO().getPageNavi(conn, currentPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	// 하나 출력
	public Company printOne(int companyCode) {
		
		Connection conn = null;
		Company company = null;
		try {
			conn = factory.createConnection();
			company = new CompanyDAO().selectOneCompany(conn, companyCode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return company;
		
	}
	
	//  기업 등록
	public int registerCompany(Company company) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new CompanyDAO().insertCompany(conn, company);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}
	
	// 기업 정보 수정
	public int modifyCompany(Company company) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new CompanyDAO().updateCompany(conn, company);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}
	
	// 기업 삭제 
	public int deleteCompany(int companyCode) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new CompanyDAO().deleteCompany(conn, companyCode);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
}
