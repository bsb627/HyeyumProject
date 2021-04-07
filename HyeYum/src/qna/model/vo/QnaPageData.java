package qna.model.vo;

import java.util.ArrayList;

public class QnaPageData {
	
	private ArrayList<Qna> qnaList;
	private String pageNavi;

	public QnaPageData() {}

	public ArrayList<Qna> getQnaList() {
		return qnaList;
	}

	public void setQnaList(ArrayList<Qna> qnaList) {
		this.qnaList = qnaList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	
	
}
