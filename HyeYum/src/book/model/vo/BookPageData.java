package book.model.vo;

import java.awt.print.Book;
import java.util.ArrayList;


public class BookPageData {

	private ArrayList<BookInfo> infoList;
	private ArrayList<BookReview> reviewList;
	private ArrayList<BookShare> shareList;
	private String pageNavi;

	public BookPageData() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<BookInfo> getInfoList() {
		return infoList;
	}

	public void setInfoList(ArrayList<BookInfo> infoList) {
		this.infoList = infoList;
	}

	public ArrayList<BookReview> getReviewList() {
		return reviewList;
	}

	public void setReviewList(ArrayList<BookReview> reviewList) {
		this.reviewList = reviewList;
	}

	public ArrayList<BookShare> getShareList() {
		return shareList;
	}

	public void setShareList(ArrayList<BookShare> shareList) {
		this.shareList = shareList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	@Override
	public String toString() {
		return "BookPageData [infoList=" + infoList + ", reviewList=" + reviewList + ", shareList=" + shareList
				+ ", pageNavi=" + pageNavi + "]";
	}


}
