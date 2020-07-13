package com.gdu.linkJobs.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.AnnouncementMapper;
import com.gdu.linkJobs.vo.AnnouncementList;
import com.gdu.linkJobs.vo.ResumeApplyByAnnouncement;

@Service
public class AnnouncementService {

	@Autowired private AnnouncementMapper announcementMapper;
	
	//채용공고에 지원한 지원자 조회
	public List<ResumeApplyByAnnouncement> getResumeApplyByAnnouncement(Map<String, Object> map){		
		
		return announcementMapper.selectResumeApplyByAnnouncement(map);
	}
	
	public List<AnnouncementList> getAnnouncementListByCpMember(String cpMemberId){
		return announcementMapper.selectAnnouncementListByCpMember(cpMemberId);
	}
}
