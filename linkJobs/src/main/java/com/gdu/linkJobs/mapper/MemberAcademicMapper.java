package com.gdu.linkJobs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.MemberAcademic;

@Mapper
public interface MemberAcademicMapper {
	//학력정보 불러오기
	   public MemberAcademic selectMemberAcademic(String memberId); 
}
