package movie.model.vo;

import java.util.ArrayList;

public class MoviePageData {
	private ArrayList<MovieInfo> movieList;
	private ArrayList<MovieReview> reviewList;
	private ArrayList<MovieRecommend> recommendList;
	private String pageNavi;
	
	public MoviePageData() {}

	public ArrayList<MovieInfo> getMovieList() {
		return movieList;
	}

	public void setMovieList(ArrayList<MovieInfo> movieList) {
		this.movieList = movieList;
	}

	public ArrayList<MovieReview> getReviewList() {
		return reviewList;
	}

	public void setReviewList(ArrayList<MovieReview> reviewList) {
		this.reviewList = reviewList;
	}

	public ArrayList<MovieRecommend> getRecommendList() {
		return recommendList;
	}

	public void setRecommendList(ArrayList<MovieRecommend> recommendList) {
		this.recommendList = recommendList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "MoviePageData [movieList=" + movieList + ", reviewList=" + reviewList + ", recommendList="
				+ recommendList + ", pageNavi=" + pageNavi + "]";
	}
	
	
}
