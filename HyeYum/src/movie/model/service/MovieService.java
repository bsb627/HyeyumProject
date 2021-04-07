package movie.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import movie.model.vo.MovieInfo;
import movie.model.vo.MovieRecommend;
import movie.model.vo.MovieReview;

public class MovieService {
	
	private JDBCTemplate factory;
	
	public MovieService() {
		factory = JDBCTemplate.getConnection();
	}
	
	// 이 달의 영화
	public MovieInfo printAllMovieInfo() {
		Connection conn = null;
		ArrayList<MovieInfo> mInfo =null;
		MovieInfo info = new MovieInfo();
	
		return info;
	}
	
	public MovieInfo printOneMovieInfo() {
		Connection conn = null;
		MovieInfo info = null;
		return info;
	}
	
	public int modifyShowInfo() {
		Connection conn = null;
		int result = 0;
		return result;
	}
	
	public MovieInfo registerMovieInfo() {
		Connection conn = null;
		MovieInfo info = null;
		return info;
	}
	
	public int deleteMovieInfo() {
		Connection conn = null;
		int result = 0;
		return result;
	}
	
	// 영화 리뷰
	public MovieReview printAllMovieReview() {
		Connection conn = null;
		ArrayList<MovieReview> mReview =null;
		MovieReview review = new MovieReview();
	
		return review;
	}
	
	public MovieReview printOneMovieReview() {
		Connection conn = null;
		MovieReview review = null;
		return review;
	}
	
	public int modifyMovieReview() {
		Connection conn = null;
		int result = 0;
		return result;
	}
	
	public MovieReview registerMovieReview() {
		Connection conn = null;
		MovieReview review = null;
		return review;
	}
	
	public int deleteMovieReview() {
		Connection conn = null;
		int result = 0;
		return result;
	}
	
	public int MovieReviewLikes() { // 좋아요 수 
		return 0;
	}
	
	public int MovieReviewHits() { // 조회 수 
		return 0;
	}
	
	// 추천혜윰
	public MovieRecommend printAllMovieRecommend() {
		Connection conn = null;
		ArrayList<MovieRecommend> mRecommend = null;
		MovieRecommend recommend = new MovieRecommend();
		
		return recommend;
	}
	
	public MovieRecommend printOneMovieRecommend() {
		Connection conn = null;
		MovieRecommend recommend = null;
		return recommend;
	}
	
	public int modifyMovieRecommend() {
		Connection conn = null;
		int result = 0;
		return result;
	}
	
	public MovieRecommend registerMovieRecommend() {
		Connection conn = null;
		MovieRecommend recommend = null;
		return recommend;
	}
	
	public int deleteMovieRecommend() {
		Connection conn = null;
		int result = 0;
		return result;
	}
	
	public MovieReview printSearchMovieReviewList() {
		Connection conn = null;
		MovieReview review = new MovieReview();
		
		return review;
	}
	
	public MovieRecommend printSearchMovieRecommendList() {
		Connection conn = null;
		MovieRecommend recommend = new MovieRecommend();
		
		return recommend;
	}
	
	public int MovieRecommendLikes() {
		Connection conn = null;
		int result = 0;
		return result;
	}
	
	public int MovieRecommendHits() {
		Connection conn = null;
		int result = 0;
		return result;
	}
}
