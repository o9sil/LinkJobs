package com.gdu.linkJobs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.gdu.linkJobs.vo.Resume;

@Mapper
public interface ResumeMapper {
	//이력서 자격증 정보 삭제
	public int delteResumeCertificate(Resume resume);

	//이력서 경력 정보 삭제
	public int deleteResumeCareer(Resume resume);
	
	//이력서 학력 정보 삭제
	public int deleteResumeAcademic(Resume resume);	
	//이력서 학력 정보 추가
	public int addAcademic(Resume resume);
	// 이력서 공개/비공개
	public int updateResumeAvaliability(Resume resume);
	//이력서 상세보기
	public List<Resume> selectDetailResume(Resume resume);
	// 이력서 추가
	public int insertResume(Resume resume);
	// 이력서 현황 개수
	public int selectResumeCount(String memberId);	
	// 이력서 삭제
	public int deleteResume(Resume resume);
	// 이력서 목록
	public List<Resume> selectResume(String memberId); 
}
