package com.gdu.linkJobs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.HireAnnouncement;

@Mapper
public interface HireAnnouncementMapper {
	
	
	//채용공고 상세보기
	public HireAnnouncement selectHireAnnouncementDetail(int hireAnnouncementNo);
	
	//채용공고 등록
	public int insertHireAnnouncement(HireAnnouncement hireAnnouncement);
}
