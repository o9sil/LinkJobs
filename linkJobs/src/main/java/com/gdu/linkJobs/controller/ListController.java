package com.gdu.linkJobs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.linkJobs.service.ListService;
import com.gdu.linkJobs.vo.HireAnnouncementAndCpMember;

@Controller
public class ListController {
	@Autowired private ListService listService;
		// 채용공고 리스트(지역별) 조건 없을경우
		@GetMapping("/getAreaAnnouncementList")
		public String getAreaAnnouncementList(Model model, HireAnnouncementAndCpMember hireAnnouncementAndCpMember) {
		   List<HireAnnouncementAndCpMember> list = listService.selectHireAnnouncementList(hireAnnouncementAndCpMember);
		   model.addAttribute("list", list);
		   return "hireAnnouncement/getAreaAnnouncementList";
		}
		
		// 채용공고 리스트(직업별) 조건 없을경우
		@GetMapping("/getJobAnnouncementList")
		public String getJobAnnouncementList(Model model, HireAnnouncementAndCpMember hireAnnouncementAndCpMember) {
		   List<HireAnnouncementAndCpMember> list = listService.selectHireAnnouncementList(hireAnnouncementAndCpMember);
		   model.addAttribute("list", list);
		   return "hireAnnouncement/getJobAnnouncementList";
		}
}
