package com.gdu.linkJobs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.HireAnnouncementAndCpMember;

@Mapper
public interface ListMapper {
	// 지역별 공고 리스트(조건 없을 때)
	public List<HireAnnouncementAndCpMember> selectHireAnnouncementList(HireAnnouncementAndCpMember hireAnnouncementAndCpMember);
}
