package show.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import show.model.vo.ShowInfo;
import show.model.vo.ShowReview;

public class ShowDAO {
	public ArrayList<ShowReview> selectAllInfoList(Connection conn, int currentPage) {
		return null;
	}
	
	public ShowInfo selectOneInfo(Connection conn, int qnaNo) {
		return null;
	}

	public int insertInfo(Connection conn, ShowInfo review) {
		
		return 0;
	}

	public int deleteInfo(Connection conn, int qnaNo) {
		return 0;
	}

	public int updateInfo(Connection conn, ShowInfo review) {
		return 0;
	}
	
	public ArrayList<ShowReview> selectAllReviewList(Connection conn, int currentPage) {
		return null;
	}
	
	public ShowReview selectOneReview(Connection conn, int qnaNo) {
		return null;
	}

	public int insertReview(Connection conn, ShowReview review) {
		
		return 0;
	}

	public int deleteReview(Connection conn, int qnaNo) {
		return 0;
	}

	public int updateReview(Connection conn, ShowReview review) {
		return 0;
	}
	
	public String getReviewPageNavi(Connection conn, int currentPage) {
		return null;
	}
	
	public int totalReviewCount(Connection conn) {
		return 0;
	}
	
	public ArrayList<ShowReview> selectSearchReviewList(Connection conn, String search, int currentPage) {
		return null;
	}

	public String getSearchReviewPageNavi(Connection conn, String search, int currentPage) {
		return null;
	}

	private int searchTotalReviewCount(Connection conn, String search) {
		return 0;
	}

	
}
