package company.model.vo;

import java.sql.Date;


public class Company { // 기업
	private int companyCode; // 키업코드
	private String companyName;// 기업명
	private int companyNumber;// 사업자번호
	private String email;// 이메일주소
	private String phone;// 전화번호
	private String address;// 주소
	private String contents;// 목적 및 내용
	private Date enrollDate;// 등록일
	private String partnership; //제휴승인여부
	
	public Company() {
		
	}

	public int getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getCompanyNumber() {
		return companyNumber;
	}

	public void setCompanyNumber(int companyNumber) {
		this.companyNumber = companyNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPartnership() {
		return partnership;
	}

	public void setPartnership(String partnership) {
		this.partnership = partnership;
	}

	@Override
	public String toString() {
		return "Company [companyCode=" + companyCode + ", companyName=" + companyName + ", companyNumber="
				+ companyNumber + ", email=" + email + ", phone=" + phone + ", address=" + address + ", contents="
				+ contents + ", enrollDate=" + enrollDate + ", partnership=" + partnership + ", getCompanyCode()="
				+ getCompanyCode() + ", getCompanyName()=" + getCompanyName() + ", getCompanyNumber()="
				+ getCompanyNumber() + ", getEmail()=" + getEmail() + ", getPhone()=" + getPhone() + ", getAddress()="
				+ getAddress() + ", getContents()=" + getContents() + ", getEnrollDate()=" + getEnrollDate()
				+ ", getPartnership()=" + getPartnership() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}

