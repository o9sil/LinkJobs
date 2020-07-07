package com.gdu.linkJobs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.MemberByCpMemberMapper;
import com.gdu.linkJobs.vo.MemberByResume;

@Service
public class MemberByResumeService {
	
	@Autowired MemberByCpMemberMapper memberByCpMemberMapper;
	

	public List<MemberByResume> getMemberListByResume(){
		return memberByCpMemberMapper.selectMemberListByResume();
	}
}
