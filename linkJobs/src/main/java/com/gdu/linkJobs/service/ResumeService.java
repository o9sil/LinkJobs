package com.gdu.linkJobs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.linkJobs.mapper.ResumeMapper;
import com.gdu.linkJobs.vo.Resume;

@Service
public class ResumeService {
	@Autowired private ResumeMapper resumeMapper;
	
	
	//이력서 공개/비공개
	public int resumeAvaliability(Resume resume) {
		System.out.println(resume+"<--resumeService");
		return resumeMapper.resumeAvaliability(resume);
	}
	
	
	//이력서 상세보기
	public List<Resume> getDetailResume(Resume resume){
		List<Resume> list = resumeMapper.selectDetailResume(resume);
		return list;
	}
	
	
	// 이력서 추가
	public int addResume(Resume resume) {
		return resumeMapper.insertResume(resume);
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
		return list;
	}
}
