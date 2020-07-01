package com.gdu.linkJobs.vo;

public class Industry {

	private int industryNo;
	private String industryCategory;
	public int getIndustryNo() {
		return industryNo;
	}
	public void setIndustryNo(int industryNo) {
		this.industryNo = industryNo;
	}
	public String getIndustryCategory() {
		return industryCategory;
	}
	public void setIndustryCategory(String industryCategory) {
		this.industryCategory = industryCategory;
	}
	@Override
	public String toString() {
		return "Industry [industryNo=" + industryNo + ", industryCategory=" + industryCategory + "]";
	}
	
	
	
}
