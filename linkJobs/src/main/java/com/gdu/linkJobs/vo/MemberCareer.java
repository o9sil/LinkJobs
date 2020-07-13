package com.gdu.linkJobs.vo;

public class MemberCareer {
	private int careerNo;
	private String memberId;
	private String careerCompanyName;
	private String careerStartDate;
	private String careerEndDate;
	private String careerLeaving;
	private String careerReasonForLeaving;
	private String careerJobgradeJobposition;
	private int careerJobgradeJobpositionYear;
	private int job2No;
	private int areaNo;
	private String careerDepartment;
	private int careerSalary; 
	private String careerResponsibilities; 
	private String careerProjectContents;
	public int getCareerNo() {
		return careerNo;
	}
	public void setCareerNo(int careerNo) {
		this.careerNo = careerNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getCareerCompanyName() {
		return careerCompanyName;
	}
	public void setCareerCompanyName(String careerCompanyName) {
		this.careerCompanyName = careerCompanyName;
	}
	public String getCareerStartDate() {
		return careerStartDate;
	}
	public void setCareerStartDate(String careerStartDate) {
		this.careerStartDate = careerStartDate;
	}
	public String getCareerEndDate() {
		return careerEndDate;
	}
	public void setCareerEndDate(String careerEndDate) {
		this.careerEndDate = careerEndDate;
	}
	public String getCareerLeaving() {
		return careerLeaving;
	}
	public void setCareerLeaving(String careerLeaving) {
		this.careerLeaving = careerLeaving;
	}
	public String getCareerReasonForLeaving() {
		return careerReasonForLeaving;
	}
	public void setCareerReasonForLeaving(String careerReasonForLeaving) {
		this.careerReasonForLeaving = careerReasonForLeaving;
	}
	public String getCareerJobgradeJobposition() {
		return careerJobgradeJobposition;
	}
	public void setCareerJobgradeJobposition(String careerJobgradeJobposition) {
		this.careerJobgradeJobposition = careerJobgradeJobposition;
	}
	public int getCareerJobgradeJobpositionYear() {
		return careerJobgradeJobpositionYear;
	}
	public void setCareerJobgradeJobpositionYear(int careerJobgradeJobpositionYear) {
		this.careerJobgradeJobpositionYear = careerJobgradeJobpositionYear;
	}
	public int getJob2No() {
		return job2No;
	}
	public void setJob2No(int job2No) {
		this.job2No = job2No;
	}
	public int getAreaNo() {
		return areaNo;
	}
	public void setAreaNo(int areaNo) {
		this.areaNo = areaNo;
	}
	public String getCareerDepartment() {
		return careerDepartment;
	}
	public void setCareerDepartment(String careerDepartment) {
		this.careerDepartment = careerDepartment;
	}
	public int getCareerSalary() {
		return careerSalary;
	}
	public void setCareerSalary(int careerSalary) {
		this.careerSalary = careerSalary;
	}
	public String getCareerResponsibilities() {
		return careerResponsibilities;
	}
	public void setCareerResponsibilities(String careerResponsibilities) {
		this.careerResponsibilities = careerResponsibilities;
	}
	public String getCareerProjectContents() {
		return careerProjectContents;
	}
	public void setCareerProjectContents(String careerProjectContents) {
		this.careerProjectContents = careerProjectContents;
	}
	@Override
	public String toString() {
		return "MemberCareer [careerNo=" + careerNo + ", memberId=" + memberId + ", careerCompanyName="
				+ careerCompanyName + ", careerStartDate=" + careerStartDate + ", careerEndDate=" + careerEndDate
				+ ", careerLeaving=" + careerLeaving + ", careerReasonForLeaving=" + careerReasonForLeaving
				+ ", careerJobgradeJobposition=" + careerJobgradeJobposition + ", careerJobgradeJobpositionYear="
				+ careerJobgradeJobpositionYear + ", job2No=" + job2No + ", areaNo=" + areaNo + ", careerDepartment="
				+ careerDepartment + ", careerSalary=" + careerSalary + ", careerResponsibilities="
				+ careerResponsibilities + ", careerProjectContents=" + careerProjectContents + "]";
	}
	
}
