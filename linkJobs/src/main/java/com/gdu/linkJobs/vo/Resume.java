package com.gdu.linkJobs.vo;

public class Resume {
	private int resumeNo;
	private String resumeTitle;
	private String memberId;
	private String resumeWorkingForm;
	private String resumeSalary;
	private String resumeWishArea;
	private String resumeWishJob;
	private String resumeWishIndustry;
	private String resumeAvaliability;
	private String resumeSelfIntroductionTitle;
	private String resumeSelfIntroductionContents;
	private String resumeDate;
	private String resumeCareer;
	
	public String getResumeCareer() {
		return resumeCareer;
	}
	public void setResumeCareer(String resumeCareer) {
		this.resumeCareer = resumeCareer;
	}
	public int getResumeNo() {
		return resumeNo;
	}
	public void setResumeNo(int resumeNo) {
		this.resumeNo = resumeNo;
	}
	public String getResumeTitle() {
		return resumeTitle;
	}
	public void setResumeTitle(String resumeTitle) {
		this.resumeTitle = resumeTitle;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getResumeWorkingForm() {
		return resumeWorkingForm;
	}
	public void setResumeWorkingForm(String resumeWorkingForm) {
		this.resumeWorkingForm = resumeWorkingForm;
	}
	public String getResumeSalary() {
		return resumeSalary;
	}
	public void setResumeSalary(String resumeSalary) {
		this.resumeSalary = resumeSalary;
	}
	public String getResumeWishArea() {
		return resumeWishArea;
	}
	public void setResumeWishArea(String resumeWishArea) {
		this.resumeWishArea = resumeWishArea;
	}
	public String getResumeWishJob() {
		return resumeWishJob;
	}
	public void setResumeWishJob(String resumeWishJob) {
		this.resumeWishJob = resumeWishJob;
	}
	public String getResumeWishIndustry() {
		return resumeWishIndustry;
	}
	public void setResumeWishIndustry(String resumeWishIndustry) {
		this.resumeWishIndustry = resumeWishIndustry;
	}
	public String getResumeAvaliability() {
		return resumeAvaliability;
	}
	public void setResumeAvaliability(String resumeAvaliability) {
		this.resumeAvaliability = resumeAvaliability;
	}
	public String getResumeSelfIntroductionTitle() {
		return resumeSelfIntroductionTitle;
	}
	public void setResumeSelfIntroductionTitle(String resumeSelfIntroductionTitle) {
		this.resumeSelfIntroductionTitle = resumeSelfIntroductionTitle;
	}
	public String getResumeSelfIntroductionContents() {
		return resumeSelfIntroductionContents;
	}
	public void setResumeSelfIntroductionContents(String resumeSelfIntroductionContents) {
		this.resumeSelfIntroductionContents = resumeSelfIntroductionContents;
	}
	public String getResumeDate() {
		return resumeDate;
	}
	public void setResumeDate(String resumeDate) {
		this.resumeDate = resumeDate;
	}
	@Override
	public String toString() {
		return "Resume [resumeNo=" + resumeNo + ", resumeTitle=" + resumeTitle + ", memberId=" + memberId
				+ ", resumeWorkingForm=" + resumeWorkingForm + ", resumeSalary=" + resumeSalary + ", resumeWishArea="
				+ resumeWishArea + ", resumeWishJob=" + resumeWishJob + ", resumeWishIndustry=" + resumeWishIndustry
				+ ", resumeAvaliability=" + resumeAvaliability + ", resumeSelfIntroductionTitle="
				+ resumeSelfIntroductionTitle + ", resumeSelfIntroductionContents=" + resumeSelfIntroductionContents
				+ ", resumeDate=" + resumeDate + ", resumeCareer=" + resumeCareer + "]";
	}
	
	
}
