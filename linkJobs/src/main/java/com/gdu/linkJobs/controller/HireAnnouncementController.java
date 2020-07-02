package com.gdu.linkJobs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.linkJobs.service.HireAnnouncementService;
import com.gdu.linkJobs.vo.HireAnnouncement;

@Controller
public class HireAnnouncementController {
	@Autowired
	private HireAnnouncementService hireAnnouncementService;
	
	// 채용공고 상세보기
	
	@GetMapping("/aboutAnnouncementOne")
	public String aboutAnnouncementOne(Model model, HttpSession session) {
		// 로그인중이 아닐때
		if(session.getAttribute("loginCpMember") != null) {
			return "redirect:/";
		}
	  
		int hireAnnouncement = ((HireAnnouncement)session.getAttribute("hireAnnouncement")).getHireAnnouncementNo();
		
		System.out.println(hireAnnouncement+"<--HireAnnouncementController : aboutAnnouncementOne-hireAnnouncementNo ");
		
		return ""; 
	  }
	 
	
	// 채용공고 등록 폼
	@GetMapping("/recordAnnouncement")
	public String recordAnnouncement(HttpSession session) {
		// 로그인 중
		if(session.getAttribute("loginCpMember") == null) {
			return "redirect:/";
		}
		return "hireAnnouncement/recordAnnouncement";
	}
	
	//채용공고 등록 액션
	@PostMapping("/recordAnnouncement")
	public String recordAnnouncement(HttpSession session, HireAnnouncement hireAnnouncement) {
		// 로그인 중
		if(session.getAttribute("loginCpMember") == null) {
			return "redirect:/";
		}
		
		System.out.println("채용공고 등록 여부확인");
		
		hireAnnouncementService.addHireAnnouncement(hireAnnouncement);
		
		return "redirect:/";
	}
}
