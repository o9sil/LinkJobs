package com.gdu.linkJobs.vo;

public class Job2 {
	private int job2No;
	private String job2Category;
	private int jobNo;
	public int getJob2No() {
		return job2No;
	}
	public void setJob2No(int job2No) {
		this.job2No = job2No;
	}
	public String getJob2Category() {
		return job2Category;
	}
	public void setJob2Category(String job2Category) {
		this.job2Category = job2Category;
	}
	public int getJobNo() {
		return jobNo;
	}
	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}
	@Override
	public String toString() {
		return "Job2 [job2No=" + job2No + ", job2Category=" + job2Category + ", jobNo=" + jobNo + "]";
	}
	
}
