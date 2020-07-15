package com.gdu.linkJobs.vo;

public class DayAndAnnouncement {
	private int hireAnnouncementNo;
	private String hireAnnouncementTitle;
	private String hireAnnouncementStartDate;
	private String hireAnnouncementEndDate;
	
	
	public int getHireAnnouncementNo() {
		return hireAnnouncementNo;
	}
	public void setHireAnnouncementNo(int hireAnnouncementNo) {
		this.hireAnnouncementNo = hireAnnouncementNo;
	}
	public String getHireAnnouncementTitle() {
		return hireAnnouncementTitle;
	}
	public void setHireAnnouncementTitle(String hireAnnouncementTitle) {
		this.hireAnnouncementTitle = hireAnnouncementTitle;
	}
	public String getHireAnnouncementStartDate() {
		return hireAnnouncementStartDate;
	}
	public void setHireAnnouncementStartDate(String hireAnnouncementStartDate) {
		this.hireAnnouncementStartDate = hireAnnouncementStartDate;
	}
	public String getHireAnnouncementEndDate() {
		return hireAnnouncementEndDate;
	}
	public void setHireAnnouncementEndDate(String hireAnnouncementEndDate) {
		this.hireAnnouncementEndDate = hireAnnouncementEndDate;
	}
	@Override
	public String toString() {
		return "DayAndAnnouncement [hireAnnouncementNo=" + hireAnnouncementNo + ", hireAnnouncementTitle="
				+ hireAnnouncementTitle + ", hireAnnouncementStartDate=" + hireAnnouncementStartDate
				+ ", hireAnnouncementEndDate=" + hireAnnouncementEndDate + "]";
	}
	
	
	
}
