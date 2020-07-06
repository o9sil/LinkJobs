package com.gdu.linkJobs.vo;

public class Scrap {
	private int scrapNo;
	private String scrapBoolean;
	private String memberId;
	private int hireAnnouncementNo;
	private String scrapDate;
	public int getScrapNo() {
		return scrapNo;
	}
	public void setScrapNo(int scrapNo) {
		this.scrapNo = scrapNo;
	}
	public String getScrapBoolean() {
		return scrapBoolean;
	}
	public void setScrapBoolean(String scrapBoolean) {
		this.scrapBoolean = scrapBoolean;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getHireAnnouncementNo() {
		return hireAnnouncementNo;
	}
	public void setHireAnnouncementNo(int hireAnnouncementNo) {
		this.hireAnnouncementNo = hireAnnouncementNo;
	}
	public String getScrapDate() {
		return scrapDate;
	}
	public void setScrapDate(String scrapDate) {
		this.scrapDate = scrapDate;
	}
	@Override
	public String toString() {
		return "Scrap [scrapNo=" + scrapNo + ", scrapBoolean=" + scrapBoolean + ", memberId=" + memberId
				+ ", hireAnnouncementNo=" + hireAnnouncementNo + ", scrapDate=" + scrapDate + "]";
	}
}
