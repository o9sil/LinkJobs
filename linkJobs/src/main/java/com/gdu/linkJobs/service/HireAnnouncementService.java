package com.gdu.linkJobs.service;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.HireAnnouncementMapper;
import com.gdu.linkJobs.vo.HireAnnouncement;

@Service
public class HireAnnouncementService extends HttpServlet {
	@Autowired
	private HireAnnouncementMapper hireAnnouncementMapper;
	
	// 채용공고 상세보기
	public HireAnnouncement selectHireAnnouncementDetail(int hireAnnouncementNo) {
		return hireAnnouncementMapper.selectHireAnnouncementDetail(hireAnnouncementNo);
	}
	
	// 채용공고 등록
	public int addHireAnnouncement(HireAnnouncement hireAnnouncement) {		
		int row = hireAnnouncementMapper.insertHireAnnouncement(hireAnnouncement);
		return row;
	}
}