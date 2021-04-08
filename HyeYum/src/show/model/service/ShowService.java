package show.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import common.JDBCTemplate;
import show.model.dao.ShowDAO;
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
			pd.setInfoList(new ShowDAO().selectAllInfoList(conn, currentPage));
			pd.setPageNavi(new ShowDAO().getInfoPageNavi(conn, currentPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public ShowInfo printOneShowInfo(int infoNo) { // 공연정보 상세보기
		ShowInfo info = null;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			info = new ShowDAO().selectOneInfo(conn, infoNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}
	
	public int registerShowInfo(ShowInfo showInfo) { // 공연정보 등록
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new ShowDAO().insertInfo(conn, showInfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int modifyShowInfo(ShowInfo showInfo) { // 공연정보 수정
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new ShowDAO().updateInfo(conn, showInfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteShowInfo(int infoNo) { // 공연정보 삭제
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new ShowDAO().deleteInfo(conn, infoNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result ;
	}
	
	public ShowPageData printAllShowReview(int currentPage) { // 관람후기 전체보기
		Connection conn = null;
		ShowPageData pd = new ShowPageData();
		try {
			conn = factory.createConnection();
			pd.setReviewList(new ShowDAO().selectAllReviewList(conn, currentPage));
			pd.setPageNavi(new ShowDAO().getReviewPageNavi(conn, currentPage));
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
		Connection conn = null;
		try {
			conn = factory.createConnection();
			review = new ShowDAO().selectOneReview(conn, showNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return review;
	}
	
	public int registerShowReview(ShowReview review) { // 관람후기 등록
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new ShowDAO().insertReview(conn, review);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int modifyShowReview(ShowReview review) { // 관람후기 수정
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new ShowDAO().updateReview(conn, review);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteShowReview(int showNo) { // 관람후기 삭제
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new ShowDAO().deleteReview(conn, showNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result ;
	}
	
	public ShowPageData searchPrintAllShowReview(int currentPage, String search, String searchCategory) { // 관람후기 검색결과 전체보기
		Connection conn = null;
		ShowPageData pd = new ShowPageData();
		try {
			conn = factory.createConnection();
			pd.setReviewList(new ShowDAO().selectSearchReviewList(conn, currentPage, search, searchCategory));
			pd.setPageNavi(new ShowDAO().getSearchReviewPageNavi(conn, currentPage, searchCategory, searchCategory));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public int addHitsCount(int showNo) { // 조회수 증가
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new ShowDAO().updateHitsReview(conn, showNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int plusLikesCount(int showNo, String userId) { // 좋아요수 증가
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new ShowDAO().insertLikesReview(conn, showNo, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int minusLikesCount(int showNo, String userId) { // 좋아요수 취소 상태 변경
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new ShowDAO().updateHitsReview(conn, showNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
