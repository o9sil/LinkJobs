package com.gdu.linkJobs.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberResumeCareerMapper {
	//경력사항 삭제 트렌젝션
	public int deleteResumeCareer(int resumeNo, int careerNo);
}
