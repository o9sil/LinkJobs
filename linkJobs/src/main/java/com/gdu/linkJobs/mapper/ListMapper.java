package com.gdu.linkJobs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.HireAnnouncementAndCpMemberAndScrap;

@Mapper
public interface ListMapper {
	//채용공고 리스트 (일반회원)
	public List<HireAnnouncementAndCpMemberAndScrap> selectHireAnnouncementList(HireAnnouncementAndCpMemberAndScrap hireAnnouncementAndCpMemberAndScrap);
	
	// 지역별 공고 리스트(조건 없을 때)
		public List<HireAnnouncementAndCpMemberAndScrap> selectHireAreaAnnouncementList(HireAnnouncementAndCpMemberAndScrap hireAnnouncementAndCpMemberAndScrap);
	}
