package show.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import book.model.vo.BookInfo;
import common.JDBCTemplate;
import movie.model.vo.MovieInfo;
import show.model.dao.ShowDAO;
import show.model.vo.ShowData;
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
		} finally {
			JDBCTemplate.close(conn);
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
		} finally {
			JDBCTemplate.close(conn);
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
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int deleteShowInfo(String infoNo) { // 공연정보 삭제
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new ShowDAO().deleteInfo(conn, infoNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
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
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return review;
	}
	
	public int registerShowReview(ShowReview review) { // 관람후기 등록
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new ShowDAO().insertReview(conn, review);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
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
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int deleteShowReview(int reviewNo) { // 관람후기 삭제
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new ShowDAO().deleteReview(conn, reviewNo);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result ;
	}
	
	public ShowPageData searchPrintAllShowReview(int currentPage, String search) { // 관람후기 검색결과 전체보기
		Connection conn = null;
		ShowPageData pd = new ShowPageData();
		try {
			conn = factory.createConnection();
			pd.setReviewList(new ShowDAO().selectSearchReviewList(conn, currentPage, search));
			pd.setPageNavi(new ShowDAO().getSearchReviewPageNavi(conn, currentPage, search));
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
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
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
	
	public int plusLikesCount(int showNo, String userId) { // 좋아요수 증가
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new ShowDAO().insertLikesReview(conn, showNo, userId);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
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
	
	public int minusLikesCount(int showNo, String userId, String state) { // 좋아요수 취소 상태 변경
		int likes = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			likes = new ShowDAO().updateLikesReview(conn, showNo, userId, state);
			if(likes > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return likes;
	}

	public ArrayList<ShowData> printReplyCount() {
		ArrayList<ShowData> rList = null;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			rList = new ShowDAO().selectReplyCount(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return rList;
	}

	public int getLikes(String userId, int showNo) {
		int likes = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			likes = new ShowDAO().selectLikes(conn,userId,showNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return likes;
	}

	public int checkLikes(int showNo, String userId) {
		int result =0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new ShowDAO().checkShowLikes(conn, showNo, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int updateLikesCount(int showNo, String userId,String state) {
		int likes = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			likes = new ShowDAO().updateLikesReview(conn, showNo, userId, state);
			if(likes > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return likes;
	}

	public ArrayList<ShowData> printLikesCount() {
		ArrayList<ShowData> lList = null;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			lList = new ShowDAO().selectLikesCount(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return lList;
	}

	public ArrayList<ShowInfo> getShowInfoList() { // 관람후기 작성시 공연정보 불러오기
		ArrayList<ShowInfo> iList =null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			iList = new ShowDAO().getShowInfoList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return iList;
	}

	public ArrayList<String> getRegion() { // 지역 가져오기
		ArrayList<String> rList = null;
		
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			rList = new ShowDAO().getRegion(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return rList;
	}

	public ShowInfo getShowInfo(int no) {
		ShowInfo info = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			info = new ShowDAO().getShowInfo(conn, no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		// TODO Auto-generated method stub
		return info;
	}

	public int getLikesCount(int showNo) {
		int likes = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			likes = new ShowDAO().getLikeCount(conn,showNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return likes;
	}

	public ArrayList<BookInfo> getBookInfoList() {
		ArrayList<BookInfo> bList =null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			bList = new ShowDAO().getBookInfoList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return bList;
	}

	public ArrayList<MovieInfo> getMovieInfoList() {
		ArrayList<MovieInfo> mList =null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			mList = new ShowDAO().getMovieInfoList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return mList;
	}
}
