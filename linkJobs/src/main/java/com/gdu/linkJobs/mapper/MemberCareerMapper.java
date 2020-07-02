package com.gdu.linkJobs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.MemberCareer;

@Mapper
public interface MemberCareerMapper {
	// 이력서 학력 추가
	public MemberCareer selectmemberCareerOne(String memberId);
}
