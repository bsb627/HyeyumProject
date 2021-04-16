package movie.model.vo;

public class MovieData {
	private int recommendNo;
	private int reviewNo;
	private int totalCount;
	private int likesCount;
	
	
	public MovieData() {
		// TODO Auto-generated constructor stub
	}


	public int getRecommendNo() {
		return recommendNo;
	}


	public void setRecommendNo(int recommendNo) {
		this.recommendNo = recommendNo;
	}


	public int getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public int getLikesCount() {
		return likesCount;
	}


	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}


	@Override
	public String toString() {
		return "MovieData [recommendNo=" + recommendNo + ", reviewNo=" + reviewNo + ", totalCount=" + totalCount
				+ ", likesCount=" + likesCount + "]";
	}


	
}
