package com.gdu.linkJobs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.MemberCareerMapper;
import com.gdu.linkJobs.vo.MemberCareer;

@Service
public class MemberCareerService {
	@Autowired  private MemberCareerMapper memberCareerMapper;
	// 이력서 학력 추가
	public MemberCareer getMemberCareerOne(String memberId) {
		return memberCareerMapper.selectMemberCareerOne(memberId);
	}
}
