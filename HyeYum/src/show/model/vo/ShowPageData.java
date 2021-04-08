package show.model.vo;

import java.util.ArrayList;

public class ShowPageData {
	
	private ArrayList<ShowInfo> showList;
	private ArrayList<ShowReview> reviewList;
	private String pageNavi;

	public ShowPageData() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<ShowInfo> getShowList() {
		return showList;
	}

	public void setShowList(ArrayList<ShowInfo> showList) {
		this.showList = showList;
	}

	public ArrayList<ShowReview> getReviewList() {
		return reviewList;
	}

	public void setReviewList(ArrayList<ShowReview> reviewList) {
		this.reviewList = reviewList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "ShowPageData [showList=" + showList + ", reviewList=" + reviewList + ", pageNavi=" + pageNavi + "]";
	}
	
	
}
