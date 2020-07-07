package com.gdu.linkJobs.vo;

public class MemberWithdrawal {
   private String memberId;
   private String memberWithdrawalDate;
   public String getMemberId() {
      return memberId;
   }
   public void setMemberId(String memberId) {
      this.memberId = memberId;
   }
   public String getMemberWithdrawalDate() {
      return memberWithdrawalDate;
   }
   public void setMemberWithdrawalDate(String memberWithdrawalDate) {
      this.memberWithdrawalDate = memberWithdrawalDate;
   }
   @Override
   public String toString() {
      return "MemberWithdrawal [memberId=" + memberId + ", memberWithdrawalDate=" + memberWithdrawalDate + "]";
   }
   
}