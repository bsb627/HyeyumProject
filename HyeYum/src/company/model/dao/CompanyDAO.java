package company.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import company.model.vo.Company;

public class CompanyDAO {
	

	
	public ArrayList<Company> selectAllList(Connection conn, int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}
	public String getPageNavi(Connection conn, int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}
	public int totalCount(Connection conn) {
		return 0;
	}
	
	public Company selectOneCompany(Connection conn, int companyCode) {
		// TODO Auto-generated method stub
		return null;
	}
	public int insertCompany(Connection conn, Company company) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int updateCompany(Connection conn, Company company) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int deleteCompany(Connection conn, int companyCode) {
		// TODO Auto-generated method stub
		return 0;
	}
}
