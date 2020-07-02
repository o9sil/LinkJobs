package com.gdu.linkJobs.vo;

public class SelfIntroduction {
	private int selfIntroductionNo;
	private String memberId;
	private String selfIntroductionTitle;
	private String selfIntroductionContents;
	private String selfIntroductionDate;
	public int getSelfIntroductionNo() {
		return selfIntroductionNo;
	}
	public void setSelfIntroductionNo(int selfIntroductionNo) {
		this.selfIntroductionNo = selfIntroductionNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getSelfIntroductionTitle() {
		return selfIntroductionTitle;
	}
	public void setSelfIntroductionTitle(String selfIntroductionTitle) {
		this.selfIntroductionTitle = selfIntroductionTitle;
	}
	public String getSelfIntroductionContents() {
		return selfIntroductionContents;
	}
	public void setSelfIntroductionContents(String selfIntroductionContents) {
		this.selfIntroductionContents = selfIntroductionContents;
	}
	public String getSelfIntroductionDate() {
		return selfIntroductionDate;
	}
	public void setSelfIntroductionDate(String selfIntroductionDate) {
		this.selfIntroductionDate = selfIntroductionDate;
	}
	@Override
	public String toString() {
		return "SelfIntroduction [selfIntroductionNo=" + selfIntroductionNo + ", memberId=" + memberId
				+ ", selfIntroductionTitle=" + selfIntroductionTitle + ", selfIntroductionContents="
				+ selfIntroductionContents + ", selfIntroductionDate=" + selfIntroductionDate + "]";
	}
	
}
