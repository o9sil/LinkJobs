package com.gdu.linkJobs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.ResumeApply;

@Mapper
public interface ResumeApplyMapper { 
	
	//이력서 지원
	public int insertResumeApply(ResumeApply resumeApply);
}
