package company.model.vo;

import java.sql.Date;


public class Company { // 기업
	private int companyCode; // 키업코드
	private String companyName;// 기업명
	private String companyNumber;// 사업자번호
	private String email;// 이메일주소
	private String phone;// 전화번호
	private String address;// 주소
	private String contents;// 목적 및 내용
	private Date enrollDate;// 등록일
	private String partnership; //제휴승인여부
	
	public Company() {
		// TODO Auto-generated constructor stub
	}
}

