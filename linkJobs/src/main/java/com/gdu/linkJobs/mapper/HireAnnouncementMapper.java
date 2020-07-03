package com.gdu.linkJobs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.CpMember;
import com.gdu.linkJobs.vo.HireAnnouncement;

@Mapper
public interface HireAnnouncementMapper {
	
	//기업회원 상세정보 가져오기
	public CpMember selectCpMemberDetail(String cpMemberId);
	
	//채용공고 상세보기
	public HireAnnouncement selectHireAnnouncementDetail(int hireAnnouncementNo);
	
	//채용공고 등록
	public int insertHireAnnouncement(HireAnnouncement hireAnnouncement);
}
