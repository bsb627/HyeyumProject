package movie.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import movie.model.dao.MovieDAO;
import movie.model.vo.MovieInfo;
import movie.model.vo.MoviePageData;
import movie.model.vo.MovieRecommend;
import movie.model.vo.MovieReview;

public class MovieService {
	
	private JDBCTemplate factory;
	
	public MovieService() {
		factory = JDBCTemplate.getConnection();
	}
	
	// 이 달의 영화
	public ArrayList<MovieInfo> printAllMovieInfo() { // 영화정보 전체보기
		Connection conn = null;
		ArrayList<MovieInfo> mInfo = null;
		try {
			conn = factory.createConnection();
			mInfo = new MovieDAO().selectAllMovieInfoList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return mInfo;
	}
	
	public MovieInfo printOneMovieInfo(int infoNo) { // 영화정보 상세보기
		Connection conn = null;
		MovieInfo info = null;
		try {
			conn = factory.createConnection();
			info = new MovieDAO().selectOneMovieInfo(conn, infoNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return info;
	}
	
	public int registerMovieInfo(MovieInfo movieInfo) { // 영화정보 등록
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new MovieDAO().insertMovieInfo(conn, movieInfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int modifyMovieInfo(MovieInfo movieInfo) { // 영화정보 수정
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new MovieDAO().updateMovieInfo(conn, movieInfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int deleteMovieInfo(int infoNo) { // 영화정보 삭제
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new MovieDAO().deleteMovieInfo(conn, infoNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	// 영화 리뷰
	public MoviePageData printAllMovieReviewList(int currentPage) { // 영화리뷰 전체보기 
		Connection conn = null;
		MoviePageData mpd = new MoviePageData();
		try {
			conn = factory.createConnection();
			mpd.setReviewList(new MovieDAO().selectAllMovieReview(conn, currentPage));
			mpd.setPageNavi(new MovieDAO().getMovieReviewPageNavi(conn, currentPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return mpd;
	}
	
	public MovieReview printOneMovieReview(int reviewNo) { // 영화리뷰 상세보기
		Connection conn = null;
		MovieReview review = null;
		try {
			conn = factory.createConnection();
			review = new MovieDAO().selectOneMovieReview(conn, reviewNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return review;
	}
	
	public int registerMovieReview(MovieReview movieReview) { // 영화리뷰 등록
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new MovieDAO().insertMovieReview(conn, movieReview);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int modifyMovieReview(MovieReview movieReview) { // 영화리뷰 수정
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new MovieDAO().updateMovieReview(conn, movieReview);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int deleteMovieReview(ArrayList<Integer> reviewNo) { // 영화리뷰 삭제
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new MovieDAO().deleteMovieReview(conn, reviewNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int ReviewPlusLikesCount(int reviewNo, String userId) { // 영화리뷰 좋아요 수 증가
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new MovieDAO().insertLikesReview(conn, reviewNo, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int ReviewMinusLikesCount(int reviewNo, String userId) { // 영화리뷰 좋아요 수 감소
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new MovieDAO().updateLikesReview(conn, reviewNo, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public MoviePageData searchPrintAllMovieReview(int currentPage, String search, String searchCategory) { // 영화리뷰 검색결과 전체보기
		Connection conn = null;
		MoviePageData mpd = new MoviePageData();
		try {
			conn = factory.createConnection();
			mpd.setReviewList(new MovieDAO().selectSearchReviewList(conn, currentPage, search, searchCategory));
			mpd.setPageNavi(new MovieDAO().getSearchReviewPageNavi(conn, currentPage, search, searchCategory));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return mpd;
	}
	
	// 추천혜윰
	public MoviePageData printAllMovieRecommend(int currentPage) { // 추천글 전체보기
		Connection conn = null;
		MoviePageData mpd = new MoviePageData();
		try {
			conn = factory.createConnection();
			mpd.setRecommendList(new MovieDAO().selectAllMovieRecommend(conn, currentPage));
			mpd.setPageNavi(new MovieDAO().getMovieRecommendPageNavi(conn, currentPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return mpd;
	}
	
	public MovieRecommend printOneMovieRecommend(int recommendNo) { // 추천글 상세보기
		Connection conn = null;
		MovieRecommend recommend = null;
		try {
			conn = factory.createConnection();
			recommend = new MovieDAO().selectOneMovieRecommend(conn, recommendNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return recommend;
	}

	public int registerMovieRecommend(MovieRecommend movieRecommend) { // 추천글 등록
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new MovieDAO().insertMovieRecommend(conn, movieRecommend);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int modifyMovieRecommend(MovieRecommend movieRecommend) { // 추천글 수정 
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new MovieDAO().updateMovieRecommend(conn, movieRecommend);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int deleteMovieRecommend(ArrayList<Integer> recommendNo) { // 추천글 삭제
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new MovieDAO().deleteMovieRecommend(conn, recommendNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public MoviePageData printSearchAllMovieRecommendList(int currentPage, String search, String searchCategory) { // 추천글 검색결과 전체보기
		Connection conn = null;
		MoviePageData mpd = new MoviePageData();
		try {
			conn = factory.createConnection();
			mpd.setRecommendList(new MovieDAO().selectSearchRecommendList(conn, currentPage, search, searchCategory));
			mpd.setPageNavi(new MovieDAO().getSearchRecommendPageNavi(conn, currentPage, search, searchCategory));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return mpd;
	}

	public int RecommendPlusLikesCount(int recommendNo, String userId) { // 추천글 좋아요 수 증가
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new MovieDAO().insertLikesRecommend(conn, recommendNo, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int RecommendMinusLikesCount(int recommendNo, String userId) { // 추천글 좋아요 수 감소
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new MovieDAO().updateLikesRecommend(conn, recommendNo, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	public int RecommendHitsCount(int recommendNo) { // 추천글 조회 수 증가
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new MovieDAO().updateHitsRecommend(conn, recommendNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
}