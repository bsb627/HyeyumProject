package member.model.service;

import common.JDBCTemplate;

public class DonateService {
	
	private JDBCTemplate factory;
	
	public DonateService() {
		factory = JDBCTemplate.getConnection();
	}

	public int selectBook(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
