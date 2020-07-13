package com.gdu.linkJobs.vo;

public class MemberResumeCareer {
	private int resumeCareerNo;
	private int resumeNo;
	private int careerNo;
	@Override
	public String toString() {
		return "MemberResumeCareer [resumeCareerNo=" + resumeCareerNo + ", resumeNo=" + resumeNo + ", careerNo="
				+ careerNo + "]";
	}
	public int getResumeCareerNo() {
		return resumeCareerNo;
	}
	public void setResumeCareerNo(int resumeCareerNo) {
		this.resumeCareerNo = resumeCareerNo;
	}
	public int getResumeNo() {
		return resumeNo;
	}
	public void setResumeNo(int resumeNo) {
		this.resumeNo = resumeNo;
	}
	public int getCareerNo() {
		return careerNo;
	}
	public void setCareerNo(int careerNo) {
		this.careerNo = careerNo;
	}
	
	
}
