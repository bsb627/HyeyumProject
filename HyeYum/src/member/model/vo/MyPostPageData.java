package member.model.vo;

import java.util.ArrayList;

public class MyPostPageData {
	
	private ArrayList<MyPost> myPList;
	private String pageNavi;
	
	public MyPostPageData() {}

	public ArrayList<MyPost> getMyPList() {
		return myPList;
	}

	public void setMyPList(ArrayList<MyPost> myPList) {
		this.myPList = myPList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

}
