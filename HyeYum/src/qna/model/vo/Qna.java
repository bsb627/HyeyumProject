package qna.model.vo;

import java.util.Date;

public class Qna  { // 1:1 문의
	
	private int qnaNo; // 글번호 
	private int family; // 글그룹
	private int step; // 그룹내 순서
	private String category; // 카테고리
	private String title; // 제목 
	private String nick; // 닉네임
	private String questionPwd; //비밀번호
	private String contents; //내용 
	private Date enrollDate; //작성일자
	private int hits; //조회수
	
	public Qna() {
		// TODO Auto-generated constructor stub
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public int getFamily() {
		return family;
	}

	public void setFamily(int family) {
		this.family = family;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getQuestionPwd() {
		return questionPwd;
	}

	public void setQuestionPwd(String questionPwd) {
		this.questionPwd = questionPwd;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	@Override
	public String toString() {
		return "Qna [qnaNo=" + qnaNo + ", family=" + family + ", step=" + step + ", category=" + category + ", title="
				+ title + ", nick=" + nick + ", questionPwd=" + questionPwd + ", contents=" + contents + ", enrollDate="
				+ enrollDate + ", hits=" + hits + "]";
	}

	
	
	
}
