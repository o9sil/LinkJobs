package com.gdu.linkJobs.vo;

public class Job3 {
	private int job3No;
	private String job3Category;
	private int job2No;
	public int getJob3No() {
		return job3No;
	}
	public void setJob3No(int job3No) {
		this.job3No = job3No;
	}
	public String getJob3Category() {
		return job3Category;
	}
	public void setJob3Category(String job3Category) {
		this.job3Category = job3Category;
	}
	public int getJob2No() {
		return job2No;
	}
	public void setJob2No(int job2No) {
		this.job2No = job2No;
	}
	@Override
	public String toString() {
		return "Job3 [job3No=" + job3No + ", job3Category=" + job3Category + ", job2No=" + job2No + "]";
	}
	
}
