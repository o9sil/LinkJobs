package com.gdu.linkJobs.vo;

public class AnnouncementList {
	private int hireAnnouncementNo;
	private String title;
	private String company;
	private String endDate;
	private String areaName;
	private String career;
	private String education;
	private String workingFormName;
	private String salary;
	private String mainJob;
	public int getHireAnnouncementNo() {
		return hireAnnouncementNo;
	}
	public void setHireAnnouncementNo(int hireAnnouncementNo) {
		this.hireAnnouncementNo = hireAnnouncementNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getWorkingFormName() {
		return workingFormName;
	}
	public void setWorkingFormName(String workingFormName) {
		this.workingFormName = workingFormName;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getMainJob() {
		return mainJob;
	}
	public void setMainJob(String mainJob) {
		this.mainJob = mainJob;
	}
	@Override
	public String toString() {
		return "AnnouncementList [hireAnnouncementNo=" + hireAnnouncementNo + ", title=" + title + ", company="
				+ company + ", endDate=" + endDate + ", areaName=" + areaName + ", career=" + career + ", education="
				+ education + ", workingFormName=" + workingFormName + ", salary=" + salary + ", mainJob=" + mainJob
				+ "]";
	}
	
	
	
	
}
