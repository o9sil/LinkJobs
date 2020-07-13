package com.gdu.linkJobs.vo;

public class ResumeApplyByAnnouncement {
	private int applyNo;
	private String memberName;
	private String memberBirthdate;
	private String memberGender;
	private String careerStartDate;
	private String careerEndDate;
	private String academicFromDate;
	private String academicToDate;
	private String salary;
	private String applyDate;
	private String pic;
	public int getApplyNo() {
		return applyNo;
	}
	public void setApplyNo(int applyNo) {
		this.applyNo = applyNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberBirthdate() {
		return memberBirthdate;
	}
	public void setMemberBirthdate(String memberBirthdate) {
		this.memberBirthdate = memberBirthdate;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
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
	public String getAcademicFromDate() {
		return academicFromDate;
	}
	public void setAcademicFromDate(String academicFromDate) {
		this.academicFromDate = academicFromDate;
	}
	public String getAcademicToDate() {
		return academicToDate;
	}
	public void setAcademicToDate(String academicToDate) {
		this.academicToDate = academicToDate;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		return "ResumeApplyByAnnouncement [applyNo=" + applyNo + ", memberName=" + memberName + ", memberBirthdate="
				+ memberBirthdate + ", memberGender=" + memberGender + ", careerStartDate=" + careerStartDate
				+ ", careerEndDate=" + careerEndDate + ", academicFromDate=" + academicFromDate + ", academicToDate="
				+ academicToDate + ", salary=" + salary + ", applyDate=" + applyDate + ", pic=" + pic + "]";
	}
	
	
	
}
