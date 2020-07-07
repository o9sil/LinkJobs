package com.gdu.linkJobs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.MemberWithdrawal;

@Mapper
public interface MemberWithdrawalMapper {
   
   //탈퇴한 회원추가
   public void addMemberWithdrawal(String memberId);
}