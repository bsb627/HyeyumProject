package member.model.vo;

import java.sql.Date;

public class Member {

	private String userId;  // 아이디
	private String userPwd; // 비밀번호
	private String userName; // 이름
	private String userNick; // 닉네임
	private String userAddress; // 주소
	private String userPhone; // 전화번호
	private String userEmail; // 이메일
	private Date enrollDate; // 가입일자
	private Date outDate; // 탈퇴일자
	private char outState; // 탈퇴여부
	private String outReason; // 탈퇴사유

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public char getOutState() {
		return outState;
	}

	public void setOutState(char outState) {
		this.outState = outState;
	}

	public String getOutReason() {
		return outReason;
	}

	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", userNick=" + userNick
				+ ", userAddress=" + userAddress + ", userPhone=" + userPhone + ", userEmail=" + userEmail
				+ ", enrollDate=" + enrollDate + ", outDate=" + outDate + ", outState=" + outState + ", outReason="
				+ outReason + "]";
	}

	

}
