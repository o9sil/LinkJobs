package com.gdu.linkJobs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.ListMapper;
import com.gdu.linkJobs.vo.HireAnnouncementAndCpMember;



@Service
public class ListService {
	@Autowired private ListMapper listMapper;
	//채용공고 리스트 출력
		public List<HireAnnouncementAndCpMember> selectHireAnnouncementList(HireAnnouncementAndCpMember hireAnnouncementAndCpMember){
			List<HireAnnouncementAndCpMember> list = listMapper.selectHireAnnouncementList(hireAnnouncementAndCpMember);
			return list;
		}
}
