package show.model.service;

import common.JDBCTemplate;
import show.model.vo.ShowInfo;
import show.model.vo.ShowReview;

public class ShowService {
	private JDBCTemplate factory;
	
	public ShowService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public ShowInfo printShowInfo() {
		ShowInfo info = null;
		return info;
	}
	
	public int modifyShowInfo() {
		int result = 0;
		return result;
	}
	
	public ShowInfo insertShowInfo() {
		ShowInfo info = null;
		return info;
	}
	
	public int deleteShowInfo() {
		int result = 0;
		return result ;
	}
	
	public ShowReview printShowReview() {
		ShowReview review = null;
		return review;
	}
	
	public int modifyShowReview() {
		int result = 0;
		return result;
	}
	
	public ShowReview insertShowReview() {
		ShowReview review = null;
		return review;
	}
	
	public int deleteShowReview() {
		int result = 0;
		return result ;
	}
	
	public int addHitsCount() {
		int result = 0;
		return result;
	}
	
	public int addLikesCount() {
		int result = 0;
		return result;
	}
}
