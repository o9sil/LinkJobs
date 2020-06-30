package com.gdu.linkJobs.vo;

public class CpMemberForm {
	private String cpmemberId;
	private String cpmemberPw;
	private String cpmemberLicenseNo;
	private String cpmemberManager;
	private String cpmemberCompany;
	private String cpmemberCeo;
	private String cpmemberPhonenum;
	private String cpmemberDate;
	
	@Override
	public String toString() {
		return "CpMemberForm [cpmemberId=" + cpmemberId + ", cpmemberPw=" + cpmemberPw + ", cpmemberLicenseNo="
				+ cpmemberLicenseNo + ", cpmemberManager=" + cpmemberManager + ", cpmemberCompany=" + cpmemberCompany
				+ ", cpmemberCeo=" + cpmemberCeo + ", cpmemberPhonenum=" + cpmemberPhonenum + ", cpmemberDate="
				+ cpmemberDate + "]";
	}
	
	
	public String getCpmemberId() {
		return cpmemberId;
	}
	public void setCpmemberId(String cpmemberId) {
		this.cpmemberId = cpmemberId;
	}
	public String getCpmemberPw() {
		return cpmemberPw;
	}
	public void setCpmemberPw(String cpmemberPw) {
		this.cpmemberPw = cpmemberPw;
	}
	public String getCpmemberLicenseNo() {
		return cpmemberLicenseNo;
	}
	public void setCpmemberLicenseNo(String cpmemberLicenseNo) {
		this.cpmemberLicenseNo = cpmemberLicenseNo;
	}
	public String getCpmemberManager() {
		return cpmemberManager;
	}
	public void setCpmemberManager(String cpmemberManager) {
		this.cpmemberManager = cpmemberManager;
	}
	public String getCpmemberCompany() {
		return cpmemberCompany;
	}
	public void setCpmemberCompany(String cpmemberCompany) {
		this.cpmemberCompany = cpmemberCompany;
	}
	public String getCpmemberCeo() {
		return cpmemberCeo;
	}
	public void setCpmemberCeo(String cpmemberCeo) {
		this.cpmemberCeo = cpmemberCeo;
	}
	public String getCpmemberPhonenum() {
		return cpmemberPhonenum;
	}
	public void setCpmemberPhonenum(String cpmemberPhonenum) {
		this.cpmemberPhonenum = cpmemberPhonenum;
	}
	public String getCpmemberDate() {
		return cpmemberDate;
	}
	public void setCpmemberDate(String cpmemberDate) {
		this.cpmemberDate = cpmemberDate;
	}
	
}
