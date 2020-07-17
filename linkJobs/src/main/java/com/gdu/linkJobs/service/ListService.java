package com.gdu.linkJobs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.ListMapper;
import com.gdu.linkJobs.vo.HireAnnouncementAndCpMemberAndScrapAndLikecp;



@Service
public class ListService {
	@Autowired private ListMapper listMapper;
	
	//메인페이지 채용공고 리스트 출력
		public List<HireAnnouncementAndCpMemberAndScrapAndLikecp> selectHireAnnouncementList(HireAnnouncementAndCpMemberAndScrapAndLikecp hireAnnouncementAndCpMemberAndScrapAndLikecp){
			List<HireAnnouncementAndCpMemberAndScrapAndLikecp> list = listMapper.selectHireAnnouncementList(hireAnnouncementAndCpMemberAndScrapAndLikecp);
			return list;
		}
		
	//메인페이지 채용공고 검색 리스트 출력
		public List<HireAnnouncementAndCpMemberAndScrapAndLikecp> selectSearchHireAnnouncementList(String wordSearch, String areaSearch, String jobSearch){
			System.out.println(jobSearch+"<<<<<<잡");
			List<HireAnnouncementAndCpMemberAndScrapAndLikecp> list = listMapper.selectSearchHireAnnouncementList(wordSearch, areaSearch, jobSearch);
			return list;
		}

	
	//채용공고 리스트 출력
		public List<HireAnnouncementAndCpMemberAndScrapAndLikecp> selectHireAreaAnnouncementList(HireAnnouncementAndCpMemberAndScrapAndLikecp hireAnnouncementAndCpMemberAndScrapAndLikecp){
			List<HireAnnouncementAndCpMemberAndScrapAndLikecp> list = listMapper.selectHireAreaAnnouncementList(hireAnnouncementAndCpMemberAndScrapAndLikecp);
			return list;
		}
}
