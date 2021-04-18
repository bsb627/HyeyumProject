package admin.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import admin.model.dao.AdminDAO;
import admin.model.dao.AdminMovieDAO;
import common.JDBCTemplate;
import movie.model.vo.MovieInfo;
import movie.model.vo.MovieRecommend;
import movie.model.vo.MovieReview;
import show.model.vo.ShowInfo;
import show.model.vo.ShowReview;

public class AdminMovieService {
	
	private JDBCTemplate factory;
	public AdminMovieService() {
		factory = JDBCTemplate.getConnection();
	}

	
	public ArrayList<MovieInfo> printAllMovieInfoList() { // 관리자 공연 정보 리스트 출력
		ArrayList<MovieInfo> mList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			mList = new AdminMovieDAO().selectAllMovieInfoList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return mList;
	}

	public int registerMovieInfo(MovieInfo movieInfo) { // 관리자 영화 정보 등록
		int result = 0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new AdminMovieDAO().insertMovieInfo(conn,movieInfo);
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

	public MovieInfo printOneMovieInfo(int infoNo) {
		MovieInfo mInfo = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			mInfo = new AdminMovieDAO().selectOneMovieInfo(conn, infoNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return mInfo;
	}

	public int deleteMovieInfo(String infoNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new AdminMovieDAO().deleteMovieInfo(conn, infoNo);
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

	public int updateMovieInfo(MovieInfo movieInfo) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new AdminMovieDAO().updateMovieInfo(conn, movieInfo);
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

	public ArrayList<MovieReview> printAllMovieReviewList() { // 관리자 공연 리뷰 리스트 출력
		ArrayList<MovieReview> mList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			mList = new AdminMovieDAO().selectAllMovieReviewList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		
		return mList;
	}

	public int deleteMovieReview(int reviewNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new AdminMovieDAO().deleteMovieReview(conn, reviewNo);
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
	
	public int deleteMovieRecommend(String recommendNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new AdminMovieDAO().deleteMovieRecommend(conn, recommendNo);
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


	public ArrayList<MovieRecommend> printAllMovieRecommendList() {
		ArrayList<MovieRecommend> mList = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			mList = new AdminMovieDAO().selectAllMovieRecommendList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return mList;
	}


	public MovieRecommend printOneMovieRecommend(int recommendNo) {
		MovieRecommend recommend = new MovieRecommend();
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			recommend = new AdminMovieDAO().selectOneMovieRecommend(conn, recommendNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return recommend;
	}
}
