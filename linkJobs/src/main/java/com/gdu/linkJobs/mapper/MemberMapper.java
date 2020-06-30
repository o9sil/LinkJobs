package com.gdu.linkJobs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.Member;

@Mapper
public interface MemberMapper {
	
	//일반 회원가입
	public int insertMember(Member member);
	//중복체크
	public String memberIdCheck(String memberId);
	
}
