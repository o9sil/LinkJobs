package com.gdu.linkJobs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.ResumeApplyMapper;
import com.gdu.linkJobs.vo.ResumeApply;

@Service
public class ResumeApplyService {

	@Autowired private ResumeApplyMapper resumeApplyMapper;
	
	//이력서 지원 
	public int addResumeApply(ResumeApply resumeApply) {
		return resumeApplyMapper.insertResumeApply(resumeApply);
	}
}
