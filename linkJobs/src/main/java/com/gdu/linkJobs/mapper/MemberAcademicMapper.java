package com.gdu.linkJobs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.MemberAcademic;

@Mapper
public interface MemberAcademicMapper {
	//학력 정보 (이력서)
	public List<MemberAcademic> selectMemberAcademic(String memberId);
	
	// 멤버용 학력
	public List<MemberAcademic> selectMemberAcademicList(String memberId);
	
	// 학력정보 하나만
	public MemberAcademic selectMemberAcademicOne(int academicNo);
	
	// 학력 추가
	public int insertMemberAcademic(MemberAcademic memberAcademic);
	
	// 학력 수정
	public int updateMemberAcademic(MemberAcademic memberAcademic);
	
	// 학력 삭제
	public int deleteMemberAcademic(int academicNo);
	
	//회원 탈퇴용 학력 삭제
	public int removeMemberAcademic(String memberId);
}
