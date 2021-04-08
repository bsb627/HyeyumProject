package show.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.JDBCTemplate;
import show.model.vo.ShowInfo;
import show.model.vo.ShowPageData;
import show.model.vo.ShowReview;

public class ShowService {
	private JDBCTemplate factory;
	
	public ShowService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public ShowPageData printAllShowInfo(int currentPage) { // 공연정보 전체보기
		Connection conn = null;
		ShowPageData pd = new ShowPageData();
		try {
			conn = factory.createConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public ShowInfo printOneShowInfo(int showNo) { // 공연정보 상세보기
		ShowInfo info = null;
		return info;
	}
	
	public ShowInfo registerShowInfo(ShowInfo review) { // 공연정보 등록
		ShowInfo info = null;
		return info;
	}
	
	public int modifyShowInfo(ShowInfo review) { // 공연정보 수정
		int result = 0;
		return result;
	}
	
	public int deleteShowInfo(int showNo) { // 공연정보 삭제
		int result = 0;
		return result ;
	}
	
	public ShowPageData printAllShowReview(int currentPage) { // 관람후기 전체보기
		Connection conn = null;
		ShowPageData pd = new ShowPageData();
		try {
			conn = factory.createConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public ShowReview printOneShowReview(int showNo) { // 관람후기 상세보기
		ShowReview review = null;
		return review;
	}
	
	public ShowReview registerShowReview(int showNo) { // 관람후기 등록
		ShowReview review = null;
		return review;
	}
	
	public int modifyShowReview(int showNo) { // 관람후기 수정
		int result = 0;
		return result;
	}
	
	public int deleteShowReview(int showNo) { // 관람후기 삭제
		int result = 0;
		return result ;
	}
	
	public ShowPageData searchPrintAllShowReview(int currentPage) { // 관람후기 검색결과 전체보기
		Connection conn = null;
		ShowPageData pd = new ShowPageData();
		try {
			conn = factory.createConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public int addHitsCount(int ShowNo) { // 조회수 증가
		int result = 0;
		return result;
	}
	
	public int plusLikesCount(String userId, int ShowNo) { // 좋아요수 증가
		int result = 0;
		return result;
	}
	
	public int minusLikesCount(String userId, int ShowNo) { // 좋아요수 취소 상태 변경
		int result = 0;
		return result;
	}
	
}
