package com.gdu.linkJobs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.AreaMapper;
import com.gdu.linkJobs.mapper.HireAnnouncementMapper;
import com.gdu.linkJobs.vo.AreaAndArea2;
import com.gdu.linkJobs.vo.CpMember;
import com.gdu.linkJobs.vo.HireAnnouncement;

import com.gdu.linkJobs.vo.HireAnnouncementDetail;

@Service
public class HireAnnouncementService extends HttpServlet {
	@Autowired
	private HireAnnouncementMapper hireAnnouncementMapper;
	
	@Autowired
	private AreaMapper areaMapper;
	
	//채용공고 상세보기(실제 채용공고)
	public HireAnnouncementDetail getHireAnnouncementOne(int hireAnnouncementNo) {
		return hireAnnouncementMapper.selectHireAnnouncementOne(hireAnnouncementNo);
	}	
	
	
	//채용공고 마감처리
	public int modifyDeadlineAnnouncement(HireAnnouncement hireAnnouncement) {
		return hireAnnouncementMapper.updateDeadlineAnnouncement(hireAnnouncement);
	}
	
	//채용공고 수정
	public int modifyHireAnnouncementOne(HireAnnouncement hireAnnouncement) {
		return hireAnnouncementMapper.updateHireAnnouncementOne(hireAnnouncement);
	}
	
	
	
	
	//기업회원 상세정보 가져오기
	public Map getCpMemberDetail(String cpMemberId) {
		
		CpMember cpMember = hireAnnouncementMapper.selectCpMemberDetail(cpMemberId);
		
		System.out.println("getCpMemberDetail area2No = " + cpMember.getCpMemberArea2No());
		AreaAndArea2 areaAndArea2 = areaMapper.selectAreaSidoGungu(cpMember.getCpMemberArea2No());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cpMember", cpMember);
		map.put("areaAndArea2", areaAndArea2);
		
		return map;
	}
	
	// 채용공고 상세보기(수정폼)
	public HireAnnouncement getHireAnnouncementDetail(int hireAnnouncementNo) {
		return hireAnnouncementMapper.selectHireAnnouncementDetail(hireAnnouncementNo);
	}
	
	// 채용공고 등록
	public int addHireAnnouncement(HireAnnouncement hireAnnouncement) {		
		int row = hireAnnouncementMapper.insertHireAnnouncement(hireAnnouncement);
		return row;
	}
}