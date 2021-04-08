package company.model.vo;

import java.util.ArrayList;



public class CompanyPageData {

	private ArrayList<Company> companyList;
	private String pageNavi;
	
	public CompanyPageData() {}

	public ArrayList<Company> getCompanyList() {
		return companyList;
	}

	public void setNoticeList(ArrayList<Company> companyList) {
		this.companyList = companyList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	public void setCompanyList(Object selectAllList) {
		// TODO Auto-generated method stub
		
	}

}
