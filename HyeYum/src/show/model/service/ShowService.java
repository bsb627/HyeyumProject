package show.model.service;

import common.JDBCTemplate;
import show.model.vo.ShowInfo;

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
	
	public ShowInfo printShowReview() {
		ShowInfo info = null;
		return info;
	}
	
	public int modifyShowReview() {
		int result = 0;
		return result;
	}
	
	public ShowInfo insertShowReview() {
		
		ShowInfo info = null;
		
		return info;
	}
	
	public int deleteShowReview() {
		int result = 0;
		return result ;
	}
	
	public ShowInfo printShowReviewReply() {
		ShowInfo info = null;
		return info;
	}
	
	public int modifyShowReviewReply() {
		int result = 0;
		return result;
	}
	
	public ShowInfo insertShowReviewReply() {
		
		ShowInfo info = null;
		
		return info;
	}
	
	public int deleteShowReviewReply() {
		int result = 0;
		return result ;
	}
	
	
}
