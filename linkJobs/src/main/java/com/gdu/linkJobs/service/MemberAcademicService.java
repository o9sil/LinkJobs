package com.gdu.linkJobs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.MemberAcademicMapper;
import com.gdu.linkJobs.vo.MemberAcademic;

@Service
public class MemberAcademicService {
		@Autowired private MemberAcademicMapper memberAcademicMapper;
	   //학력정보출력
	   public MemberAcademic getMemberAcademic(String memberId) {
	      return memberAcademicMapper.selectMemberAcademic(memberId);
	   }
}
