package com.gdu.linkJobs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.linkJobs.mapper.MemberMapper;
import com.gdu.linkJobs.vo.LoginMember;
import com.gdu.linkJobs.vo.Member;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	// 이력서 회원정보 출력 
		public Member getMemberOne(String memberId) {
			return memberMapper.selectMemberOne(memberId);
		}
	//일반회원 회원가입
	public int addMember(Member member) {
		return memberMapper.insertMember(member);
	}
	
	//중복확인 (아이디)
	public String memberIdCheck(String memberId) {
		return memberMapper.memberIdCheck(memberId);
	}
	
	//loginMember
	public String loginMember(LoginMember loginMember) {
		return memberMapper.loginMember(loginMember);
	}
	
	//회원정보수정
	public int modifyMember(Member member) {
		return memberMapper.updateMember(member);
	}
}
