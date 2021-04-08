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
		return info;
	}
	
	public MovieInfo registerMovieInfo(MovieInfo movieInfo) { // 영화정보 등록
		Connection conn = null;
		MovieInfo info = null;
		return info;
	}
	
	public int modifyShowInfo(MovieInfo movieInfo) { // 영화정보 수정
		Connection conn = null;
		int result = 0;
		return result;
	}
	
	public int deleteMovieInfo(int infoNo) { // 영화정보 삭제
		Connection conn = null;
		int result = 0;
		return result;
	}
	
	// 영화 리뷰
	public MoviePageData printAllMovieReviewList(int currentPage) { // 영화리뷰 전체보기 
		Connection conn = null;
		MoviePageData mpd = new MoviePageData();
		try {
			conn = factory.createConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return mpd;
	}
	
	public MovieReview printOneMovieReview(int currentPage) { // 영화리뷰 상세보기
		Connection conn = null;
		MovieReview review = null;
		return review;
	}
	
	public MovieReview registerMovieReview(MovieReview movieReview) { // 영화리뷰 등록
		Connection conn = null;
		MovieReview review = null;
		return review;
	}
	
	public int modifyMovieReview(MovieReview movieReview) { // 영화리뷰 수정
		Connection conn = null;
		int result = 0;
		return result;
	}
	
	public int deleteMovieReview(int reviewNo) { // 영화리뷰 삭제
		Connection conn = null;
		int result = 0;
		return result;
	}
	
	public int ReviewPlusLikesCount(int reviewNo, String userId) { // 영화리뷰 좋아요 수 증가
		return 0;
	}
	
	public int ReviewMinusLikesCount(int reviewNo, String userId) { // 영화리뷰 좋아요 수 감소
		return 0;
	}
	
	public int ReviewHitsCount(int reviewNo) { // 영화리뷰 조회 수 증가
		return 0;
	}
	
	public MoviePageData searchPrintAllMovieReview(int currentPage, String search, String searchCategory) { // 영화리뷰 검색결과 전체보기
		Connection conn = null;
		MoviePageData mpd = new MoviePageData();
		
		try {
			conn = factory.createConnection();
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
		return recommend;
	}

	public MovieRecommend registerMovieRecommend(MovieRecommend movieRecommend) { // 추천글 등록
		Connection conn = null;
		MovieRecommend recommend = null;
		return recommend;
	}
	
	public int modifyMovieRecommend(MovieRecommend movieRecommend) { // 추천글 수정 
		Connection conn = null;
		int result = 0;
		return result;
	}
	
	public int deleteMovieRecommend(int recommendNo) { // 추천글 삭제
		Connection conn = null;
		int result = 0;
		return result;
	}
	
	public MoviePageData printSearchAllMovieRecommendList() { // 추천글 검색결과 전체보기
		Connection conn = null;
		MoviePageData mpd = new MoviePageData();
		
		try {
			conn = factory.createConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return mpd;
	}

	public int RecommendPlusLikesCount(int recommendNo, String userId) { // 추천글 좋아요 수 증가
		return 0;
	}
	
	public int RecommendMinusLikesCount(int recommendNo, String userId) { // 추천글 좋아요 수 감소
		return 0;
	}
	
	public int RecommendHitsCount(int recommendNo) { // 추천글 조회 수 증가
		return 0;
	}
	
}