package com.gdu.linkJobs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.linkJobs.service.ScrapService;
import com.gdu.linkJobs.vo.HireAnnouncement;

@Controller
public class ScrapController {
	@Autowired
	private ScrapService scrapService;
	
	@GetMapping("/scrapList")
	public String scrapList(HttpSession session, Model model) {
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/getAnnouncementList";
		}
		
		String memberId=(String) (session.getAttribute("loginMember"));
		System.out.println(memberId);
		List<HireAnnouncement> list=scrapService.getMemberScrapList(memberId);
		System.out.println(list+"<--list");
		model.addAttribute("list", list);
		
		return "/member/scrapList";
	}
	
}
