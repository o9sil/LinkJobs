package com.gdu.linkJobs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.AnnouncementMapper;
import com.gdu.linkJobs.vo.AnnouncementList;

@Service
public class AnnouncementService {

	@Autowired private AnnouncementMapper announcementMapper;
	
	public List<AnnouncementList> getAnnouncementListByCpMember(String cpMemberId){
		return announcementMapper.selectAnnouncementListByCpMember(cpMemberId);
	}
}
