package com.gdu.linkJobs.vo;

public class MemberAcademic {
   private int academicNo;
   private String memberId;
   private String academicGrade;
   private String academicName;
   private String academicMajor;
   private String academicMajorDetail;
   private String academicFromDate;
   private String academicToDate;
   private String academicScore;
   public int getAcademicNo() {
      return academicNo;
   }
   public void setAcademicNo(int academicNo) {
      this.academicNo = academicNo;
   }
   public String getMemberId() {
      return memberId;
   }
   public void setMemberId(String memberId) {
      this.memberId = memberId;
   }
   public String getAcademicGrade() {
      return academicGrade;
   }
   public void setAcademicGrade(String academicGrade) {
      this.academicGrade = academicGrade;
   }
   public String getAcademicName() {
      return academicName;
   }
   public void setAcademicName(String academicName) {
      this.academicName = academicName;
   }
   public String getAcademicMajor() {
      return academicMajor;
   }
   public void setAcademicMajor(String academicMajor) {
      this.academicMajor = academicMajor;
   }
   public String getAcademicMajorDetail() {
      return academicMajorDetail;
   }
   public void setAcademicMajorDetail(String academicMajorDetail) {
      this.academicMajorDetail = academicMajorDetail;
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
   public String getAcademicScore() {
      return academicScore;
   }
   public void setAcademicScore(String academicScore) {
      this.academicScore = academicScore;
   }
   @Override
   public String toString() {
      return "MemberAcademic [academicNo=" + academicNo + ", memberId=" + memberId + ", academicGrade="
            + academicGrade + ", academicName=" + academicName + ", academicMajor=" + academicMajor
            + ", academicMajorDetail=" + academicMajorDetail + ", academicFromDate=" + academicFromDate
            + ", academicToDate=" + academicToDate + ", academicScore=" + academicScore + "]";
   }
}