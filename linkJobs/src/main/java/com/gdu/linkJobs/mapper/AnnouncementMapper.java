package com.gdu.linkJobs.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.AnnouncementList;
import com.gdu.linkJobs.vo.ResumeApplyByAnnouncement;

@Mapper
public interface AnnouncementMapper {
	
	//채용공고에 지원한 지원자 조회
	public List<ResumeApplyByAnnouncement> selectResumeApplyByAnnouncement(Map<String, Object> map);
	
	//기업회원별 등록한 채용공고 리스트 조회
	public List<AnnouncementList> selectAnnouncementListByCpMember(String cpMemberId);
}
