package com.gdu.linkJobs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.ListMapper;
import com.gdu.linkJobs.vo.HireAnnouncementAndCpMemberAndScrap;



@Service
public class ListService {
	@Autowired private ListMapper listMapper;
	
	//메인페이지 채용공고 리스트 출력
		public List<HireAnnouncementAndCpMemberAndScrap> selectHireAnnouncementList(HireAnnouncementAndCpMemberAndScrap hireAnnouncementAndCpMemberAndScrap){
			List<HireAnnouncementAndCpMemberAndScrap> list = listMapper.selectHireAnnouncementList(hireAnnouncementAndCpMemberAndScrap);
			return list;
		}
	
	
	//채용공고 리스트 출력
		public List<HireAnnouncementAndCpMemberAndScrap> selectHireAreaAnnouncementList(HireAnnouncementAndCpMemberAndScrap hireAnnouncementAndCpMemberAndScrap){
			List<HireAnnouncementAndCpMemberAndScrap> list = listMapper.selectHireAnnouncementList(hireAnnouncementAndCpMemberAndScrap);
			return list;
		}
}
