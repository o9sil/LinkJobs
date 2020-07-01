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
}
