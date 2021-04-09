package movie.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import movie.model.vo.MovieInfo;
import movie.model.vo.MovieRecommend;
import movie.model.vo.MovieReview;

public class MovieDAO {
	
	// 이 달의 영화
	public ArrayList<MovieInfo> selectAllMovieInfoList(Connection conn) { // 영화정보 전체보기
		
		return null;
	}
	
	public MovieInfo selectOneMovieInfo(Connection conn,int infoNo) { // 영화정보 상세보기
		
		return null;
	}
	
	public int insertMovieInfo(Connection conn, MovieInfo movieInfo) { // 영화정보 등록
		int result = 0;
		
		return result;
	}
	
	public int updateMovieInfo(Connection conn, MovieInfo movieInfo) { // 영화정보 수정
		int result = 0;
		
		return result;
	}
	
	public int deleteMovieInfo(Connection conn, int infoNo) { // 영화정보 삭제
		int result = 0;
		
		return result;
	}
	
	// 영화 리뷰
	public ArrayList<MovieReview> selectAllMovieReview(Connection conn,int currentPage) { // 영화리뷰 전체보기
		ArrayList<MovieReview> mReview = null;	
		return mReview;
	}
	
	public String getMovieReviewPageNavi(Connection conn, int currentPage) { // 영화리뷰 페이징
		return null;
	}
	
	public int totalReviewCount(Connection conn) { // 영화리뷰 총 게시글 수
		return 0;
	}
	
	public MovieReview selectOneMovieReview(Connection conn, int reviewNo) { // 영화리뷰 상세보기
		
		return null;
	}
	
	public int insertMovieReview(Connection conn, MovieReview movieReview) { // 영화리뷰 등록
		int result = 0;
		
		return result;
	}
	
	public int updateMovieReview(Connection conn, MovieReview movieReview) { // 영화리뷰 수정
		int result = 0;
		
		return result;
	}
	
	public int deleteMovieReview(Connection conn, int reviewNo) { // 영화리뷰 삭제
		int result = 0;
		
		return result;
	}
	
	public ArrayList<MovieReview> selectSearchReviewList(Connection conn, int currentPage, String search, String searchCategory) { // 영화리뷰 검색결과 전체보기
		ArrayList<MovieReview> mReview = null;
		
		return mReview;
	}
	
	public String getSearchReviewPageNavi(Connection conn, int currentPage, String search, String searchCategory) { // 영화리뷰 검색 페이징
		return null;
	}
	
	public int searchTotalReviewCount(Connection conn, String search, String searchCategory) { // 영화리뷰 검색 총 게시글 수
		return 0;
	}
	
	public int insertLikesReview(Connection conn, int reviewNo, String userId) { // 해당 게시글 좋아요 등록
		return 0;
	}
	
	public int updateLikesReview(Connection conn, int reviewNo, String userId) { // 해당 게시글 좋아요 취소
		return 0;
	}
	
	
	// 추천혜윰
	public ArrayList<MovieRecommend> selectAllMovieRecommend(Connection conn, int currentPage) { // 추천글 전체보기
		ArrayList<MovieRecommend> mRecommend = null;
			return mRecommend;
		}
	
	public String getMovieRecommendPageNavi(Connection conn, int currentPage)  { // 추천글 페이징
		return null;
	}
	
	public int totalRecommendCount(Connection conn) { // 추천글 총 게시글 수
		return 0;
	}
	
	public MovieRecommend selectOneMovieRecommend(Connection conn, int recommendNo) { // 추천글 상세보기
		
		return null;
	}
	
	public int insertMovieRecommend(Connection conn, MovieRecommend movieRecommend) { // 추천글 등록
		int result = 0;
		
		return result;
	}
	
	public int updateMovieRecommend(Connection conn, MovieRecommend movieRecommend) { // 추천글 수정
		int result = 0;
		
		return result;
	}
	
	public int deleteMovieRecommend(Connection conn, int recommendNo) { // 추천글 삭제
		int result = 0;
		
		return result;
	}
	
	public ArrayList<MovieRecommend> selectSearchRecommendList(Connection conn, int currentPage, String search, String searchCategory) { //추천글 검색결과 전체보기
		ArrayList<MovieRecommend> mRecommend = null;
		
		return mRecommend;
	}
	
	public String getSearchRecommendPageNavi(Connection conn, int currentPage, String search, String searchCategory) { // 추천글 검색 페이징
		
		return null;
	}
	
	public int searchTotalRecommendCount(Connection conn, String search, String searchCategory) { // 추천글 검색 총 게시글 수
		return 0;
	}
	
	public int updateHitsRecommend(Connection conn, int recommendNo) { // 해당 게시글 조회수 증가
		return 0;
	}
	
	public int insertLikesRecommend(Connection conn, int recommendNo, String userId) { // 해당 게시글 좋아요 등록
		return 0;
	}
	
	public int updateLikesRecommend(Connection conn, int recommendNo, String userId) { // 해당 게시글 좋아요 취소
		return 0;
	}
	
}
