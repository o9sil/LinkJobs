package com.gdu.linkJobs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.gdu.linkJobs.mapper.ResumeMapper;

import com.gdu.linkJobs.vo.Resume;

@Service
public class ResumeService {
	@Autowired private ResumeMapper resumeMapper;
	
	//이력서 자격증정보 삭제
	public int deleteResumeCertificate(Resume resume) {
		//System.out.println("자격증정보---->>>>>"+resume);
		return resumeMapper.delteResumeCertificate(resume);
	}
	
	//이력서 경력정보 삭제
	public int deleteResumeCareer(Resume resume) {
		return resumeMapper.deleteResumeCareer(resume);
	}
	
	
	//이력서 학력정보 삭제
	public int deleteResumeAcademic(Resume resume) {
		return resumeMapper.deleteResumeAcademic(resume);
	}
	
	
	
	//이력서 공개/비공개
	public int modifyResumeAvaliability(Resume resume) {
		System.out.println(resume+"<--resumeService");
		return resumeMapper.updateResumeAvaliability(resume);
	}
	
	
	//이력서 상세보기
	public List<Resume> getDetailResume(Resume resume){
		List<Resume> list = resumeMapper.selectDetailResume(resume);
		return list;
	}
	
	
	// 이력서 추가
	public int addResume(Resume resume) {		
		resumeMapper.insertResume(resume);
		System.out.println("이력서no--->"+resume.getResumeNo());
		resume.getResumeNo();
		resumeMapper.addAcademic(resume);
		return 0;
	}
	
	// 이력서 현황 카운트
	public int getResumeCount(String memberId) {
		return resumeMapper.selectResumeCount(memberId);
	}
	
	// 이력서 삭제
	public int removeResume(Resume resume) {
		return resumeMapper.deleteResume(resume);
	}
	
	// 이력서 목록
	public List<Resume> getResume(String memberId) {
		List<Resume> list = resumeMapper.selectResume(memberId);
		System.out.println(list+"<-- service.getResume");
		return list;
	}
}
