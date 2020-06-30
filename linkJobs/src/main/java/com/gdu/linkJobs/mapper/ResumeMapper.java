package com.gdu.linkJobs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.Resume;

@Mapper
public interface ResumeMapper {
	// 이력서 추가
	public int insertResume(Resume resume);
	// 이력서 삭제
	public int deleteResume(Resume resume);
	// 이력서 목록
	public List<Resume> selectResume(String memberId); 
}
