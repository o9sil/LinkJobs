package com.gdu.linkJobs.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.linkJobs.mapper.MemberMapper;
import com.gdu.linkJobs.mapper.MemberPicMapper;
import com.gdu.linkJobs.vo.LoginMember;
import com.gdu.linkJobs.vo.Member;
import com.gdu.linkJobs.vo.MemberPic;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private MemberPicMapper memberPicMapper;

	// 이력서 회원정보 출력
	public Member getMemberOne(String memberId) {
		return memberMapper.selectMemberOne(memberId);
	}

	// 일반회원 회원가입
	public void addMember(Member member) {
		memberMapper.insertMember(member);
		memberPicMapper.insertMemberPic(member.getMemberId());

	}

	// 중복확인 (아이디)
	public String memberIdCheck(String memberId) {
		return memberMapper.memberIdCheck(memberId);
	}

	// loginMember
	public String loginMember(LoginMember loginMember) {
		return memberMapper.loginMember(loginMember);
	}

	// 회원정보수정
	public int modifyMember(Member member) {
		return memberMapper.updateMember(member);
	}

	// 사진 수정
	public void modifyMemberPic(MemberPic memberPic) {

		memberPicMapper.updateMemberPic(memberPic);
	}

	// 사진 수정 폼
	public MemberPic getMemberPic(String memberId) {
		return memberPicMapper.selectMeberPic(memberId);
	}

	// 회원 탈퇴

}
