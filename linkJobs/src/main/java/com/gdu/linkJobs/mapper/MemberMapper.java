package com.gdu.linkJobs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.LoginMember;
import com.gdu.linkJobs.vo.Member;

@Mapper
public interface MemberMapper {
	
	//일반 회원가입
	public int insertMember(Member member);
	//중복체크
	public String memberIdCheck(String memberId);
	//login member
	public String loginMember(LoginMember loginMember);
	//이력서 회원정보 출력
	public Member selectMemberOne(String memberId);
	//회원정보 수정
	public int updateMember(Member member);
}
