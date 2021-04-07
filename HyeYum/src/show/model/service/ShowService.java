package show.model.service;

import java.util.ArrayList;

import common.JDBCTemplate;
import show.model.vo.ShowInfo;
import show.model.vo.ShowReview;

public class ShowService {
	private JDBCTemplate factory;
	
	public ShowService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public ArrayList<ShowInfo> printAllShowInfo() { // 공연정보 전체보기
		ArrayList<ShowInfo> list = null;
		return list;
	}
	
	public ShowInfo printOneShowInfo() { // 공연정보 상세보기
		ShowInfo info = null;
		return info;
	}
	
	public ShowInfo registerShowInfo() { // 공연정보 등록
		ShowInfo info = null;
		return info;
	}
	
	public int modifyShowInfo() { // 공연정보 수정
		int result = 0;
		return result;
	}
	
	
	public int deleteShowInfo() { // 공연정보 삭제
		int result = 0;
		return result ;
	}
	
	public ArrayList<ShowReview> printAllShowReview() { // 관람후기 전체보기
		ArrayList<ShowReview> list = null;
		return list;
	}
	
	public ShowReview printOneShowReview() { // 관람후기 상세보기
		ShowReview review = null;
		return review;
	}
	
	public ShowReview registerShowReview() { // 관람후기 등록
		ShowReview review = null;
		return review;
	}
	
	public int modifyShowReview() { // 관람후기 수정
		int result = 0;
		return result;
	}
	
	public int deleteShowReview() { // 관람후기 삭제
		int result = 0;
		return result ;
	}
	
	public ArrayList<ShowReview> searchPrintAllShowReview() { // 관람후기 검색결과 전체보기
		ArrayList<ShowReview> list = null;
		return list;
	}
	
	public int addHitsCount() { // 조회수 증가
		int result = 0;
		return result;
	}
	
	public int plusLikesCount() { // 좋아요수 증가
		int result = 0;
		return result;
	}
	
	public int minusLikesCount() { // 좋아요수 빼기
		int result = 0;
		return result;
	}
	
}
