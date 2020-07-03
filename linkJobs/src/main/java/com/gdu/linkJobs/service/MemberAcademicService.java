package com.gdu.linkJobs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.MemberAcademicMapper;
import com.gdu.linkJobs.vo.MemberAcademic;

@Service
public class MemberAcademicService {
	@Autowired
	private MemberAcademicMapper memberAcademicMapper;

	// 학력정보(이력서)
	public MemberAcademic getMemberAcademic(String memberId) {
		return memberAcademicMapper.selectMemberAcademic(memberId);
	}
	
	
	// 학력정보출력(멤버용)
	public List<MemberAcademic> getMemberAcademicList(String memberId) {
		return memberAcademicMapper.selectMemberAcademicList(memberId);
	}

	// 학력정보 하나만
	public MemberAcademic getMemberAcademicOne(int academicNo) {
		return memberAcademicMapper.selectMemberAcademicOne(academicNo);
	}

	// 학력 추가
	public int addMemberAcademic(MemberAcademic memberAcademic) {
		return memberAcademicMapper.insertMemberAcademic(memberAcademic);
	}

	// 학력 수정
	public int modifyMemberAcademic(MemberAcademic memberAcademic) {
		return memberAcademicMapper.updateMemberAcademic(memberAcademic);
	}

	// 학력 삭제
	public int removeMemberAcademic(int academicNo) {
		return memberAcademicMapper.deleteMemberAcademic(academicNo);
	}
}
