package com.gdu.linkJobs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.LoginMember;
import com.gdu.linkJobs.vo.Member;

@Mapper
public interface MemberMapper {
	//회원 탈퇴 -> 회원 삭제
	public int deleteMember(Member member);
	//회원 비밀번호 수정
	public int updateMemberPw(Member member);
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
	//비밀번호 찾기
	public int findMemberPw(Member member);
	//아이디 찾기
	public Member findMemberId(Member member);
}
