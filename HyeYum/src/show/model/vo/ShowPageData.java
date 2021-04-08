package show.model.vo;

import java.util.ArrayList;

public class ShowPageData {
	
	private ArrayList<ShowInfo> infoList;
	private ArrayList<ShowReview> reviewList;
	private String pageNavi;

	public ShowPageData() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<ShowInfo> getInfoList() {
		return infoList;
	}

	public void setInfoList(ArrayList<ShowInfo> infoList) {
		this.infoList = infoList;
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
		return "ShowPageData [infoList=" + infoList + ", reviewList=" + reviewList + ", pageNavi=" + pageNavi + "]";
	}
	
	
}
