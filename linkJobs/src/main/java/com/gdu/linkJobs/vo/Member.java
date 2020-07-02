package com.gdu.linkJobs.vo;

public class Member {
   private String memberId;
   private String memberPw;
   private String memberName;
   private String areaSido;
   private String area2Gungu;
   private String memberDetailedAddress;
   private String memberPhone;
   private String memberEmail;
   private String memberBirthdate;
   private String memberGender;
   private String memberSocialLogin;
   public String getMemberId() {
      return memberId;
   }
   public void setMemberId(String memberId) {
      this.memberId = memberId;
   }
   @Override
   public String toString() {
      return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName + ", areaSido="
            + areaSido + ", area2Gungu=" + area2Gungu + ", memberDetailedAddress=" + memberDetailedAddress
            + ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail + ", memberBirthdate="
            + memberBirthdate + ", memberGender=" + memberGender + ", memberSocialLogin=" + memberSocialLogin + "]";
   }
   public String getMemberPw() {
      return memberPw;
   }
   public void setMemberPw(String memberPw) {
      this.memberPw = memberPw;
   }
   public String getMemberName() {
      return memberName;
   }
   public void setMemberName(String memberName) {
      this.memberName = memberName;
   }
   public String getAreaSido() {
      return areaSido;
   }
   public void setAreaSido(String areaSido) {
      this.areaSido = areaSido;
   }
   public String getArea2Gungu() {
      return area2Gungu;
   }
   public void setArea2Gungu(String area2Gungu) {
      this.area2Gungu = area2Gungu;
   }
   public String getMemberDetailedAddress() {
      return memberDetailedAddress;
   }
   public void setMemberDetailedAddress(String memberDetailedAddress) {
      this.memberDetailedAddress = memberDetailedAddress;
   }
   public String getMemberPhone() {
      return memberPhone;
   }
   public void setMemberPhone(String memberPhone) {
      this.memberPhone = memberPhone;
   }
   public String getMemberEmail() {
      return memberEmail;
   }
   public void setMemberEmail(String memberEmail) {
      this.memberEmail = memberEmail;
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
   public String getMemberSocialLogin() {
      return memberSocialLogin;
   }
   public void setMemberSocialLogin(String memberSocialLogin) {
      this.memberSocialLogin = memberSocialLogin;
   }
   
}