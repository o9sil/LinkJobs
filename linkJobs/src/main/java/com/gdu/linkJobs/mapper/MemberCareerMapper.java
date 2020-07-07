package com.gdu.linkJobs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.MemberCareer;
import com.gdu.linkJobs.vo.MemberCareerAndJobAndArea;

@Mapper
public interface MemberCareerMapper {
	// 이력서 학력리스트 출력
	public MemberCareerAndJobAndArea selectMemberCareerOne(String memberId);
}
