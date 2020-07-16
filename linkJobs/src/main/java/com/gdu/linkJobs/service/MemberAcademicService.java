package com.gdu.linkJobs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.MemberAcademicMapper;
import com.gdu.linkJobs.vo.MemberAcademic;

@Service
public class MemberAcademicService {
	@Autowired
	private MemberAcademicMapper memberAcademicMapper;

	// 학력정보(이력서)
	public List<MemberAcademic> getMemberAcademic(String memberId) {
		return memberAcademicMapper.selectMemberAcademic(memberId);
	}
	
	
	// 학력정보출력(멤버용)
	public  Map<String, Object> getMemberAcademicList(String memberId, int beginRow, int rowPerPage) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("beginRow",beginRow);
		map.put("rowPerPage", rowPerPage);
		
		int totalRow = memberAcademicMapper.totalAcademic(memberId);
		System.out.println(totalRow +"total");
		
		int lastPage = totalRow/rowPerPage;
		
		
		System.out.println(lastPage+"last");
		
		List<MemberAcademic> academicList = memberAcademicMapper.selectMemberAcademicList(memberId, beginRow, rowPerPage);
		map.put("academicList", academicList);
		map.put("lastPage", lastPage);
		
		return map; 
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
