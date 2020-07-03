package com.gdu.linkJobs.vo;

public class Job {
	private int jobNo;
	private String jobCategory;
	public int getJobNo() {
		return jobNo;
	}
	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}
	public String getJobCategory() {
		return jobCategory;
	}
	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}
	@Override
	public String toString() {
		return "Job [jobNo=" + jobNo + ", jobCategory=" + jobCategory + "]";
	}
	
}
