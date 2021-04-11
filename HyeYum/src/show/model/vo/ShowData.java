package show.model.vo;

public class ShowData {
	private int showNo;
	private int totalCount;
	private int likesCount;
	
	public ShowData() {
		// TODO Auto-generated constructor stub
	}

	public int getShowNo() {
		return showNo;
	}

	public void setShowNo(int showNo) {
		this.showNo = showNo;
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
		return "ShowData [showNo=" + showNo + ", totalCount=" + totalCount + ", likesCount=" + likesCount + "]";
	}
	
	
}
