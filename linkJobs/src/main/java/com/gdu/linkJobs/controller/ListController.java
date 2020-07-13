package com.gdu.linkJobs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.linkJobs.service.ListService;
import com.gdu.linkJobs.service.ScrapService;
import com.gdu.linkJobs.vo.HireAnnouncementAndCpMemberAndScrap;
import com.gdu.linkJobs.vo.Scrap;

@Controller
public class ListController {
	@Autowired private ListService listService;
	@Autowired private ScrapService scrapService; 
	
	// 메인페이지 채용공고 리스트(일반회원)
	@GetMapping("/getAnnouncementList")
	public String getHireAnnouncementList(Model model, HireAnnouncementAndCpMemberAndScrap hireAnnouncementAndCpMemberAndScrap) {
		List<HireAnnouncementAndCpMemberAndScrap> list = listService.selectHireAnnouncementList(hireAnnouncementAndCpMemberAndScrap);
		// hireAnnouncementAndCpMemberAndScrap.setHireAnnouncementNo(hireAnnouncementNo);
		
		List<Scrap> scrapList = scrapService.selectBoolean();
		model.addAttribute("scrapList", scrapList);
		model.addAttribute("list", list);
		System.out.println(list + "<--list");
		return "hireAnnouncement/getAnnouncementList";
	}

	// 채용공고 리스트(지역별) 조건 없을경우

	@GetMapping("/getAreaAnnouncementList")
	public String getAreaAnnouncementList(Model model, HireAnnouncementAndCpMemberAndScrap hireAnnouncementAndCpMember) {
		List<HireAnnouncementAndCpMemberAndScrap> list = listService.selectHireAreaAnnouncementList(hireAnnouncementAndCpMember);
		
		model.addAttribute("list", list);
		return "hireAnnouncement/getAreaAnnouncementList";
	}

	// 채용공고 리스트(직업별) 조건 없을경우

	@GetMapping("/getJobAnnouncementList")
	public String getJobAnnouncementList(Model model, HireAnnouncementAndCpMemberAndScrap hireAnnouncementAndCpMember) {
		List<HireAnnouncementAndCpMemberAndScrap> list = listService.selectHireAnnouncementList(hireAnnouncementAndCpMember);
		model.addAttribute("list", list);
		return "hireAnnouncement/getJobAnnouncementList";
	}

	

}