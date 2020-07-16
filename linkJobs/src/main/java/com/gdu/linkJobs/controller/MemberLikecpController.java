package com.gdu.linkJobs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.linkJobs.service.LikecpService;
import com.gdu.linkJobs.vo.HireAnnouncementAndCpMemberAndScrapAndLikecp;

@Controller
public class MemberLikecpController {
	@Autowired LikecpService likecpService;
	
	//관심기업 리스트 출력
	@GetMapping("/likecpList")
	public String likecpList(HttpSession session,Model model, String memberId){
		if(session.getAttribute("loginCpMember") != null) {
			return "redirect:/getAnnouncementList";
		}
		memberId = (String)session.getAttribute("loginMember");
		List<HireAnnouncementAndCpMemberAndScrapAndLikecp> list = likecpService.likecpList(memberId);
		model.addAttribute("list", list);
		
		return "member/likecpList";
	}
	
	//관심기업 공고 출력
	@GetMapping("/likecpHireAnnouncement")
	public String likecpHireAnnouncement(HttpSession session,Model model, String memberId){
		if(session.getAttribute("loginCpMember") != null) {
			return "redirect:/getAnnouncementList";
		}
		memberId = (String)session.getAttribute("loginMember");
		List<HireAnnouncementAndCpMemberAndScrapAndLikecp> list = likecpService.likecpList(memberId);
		model.addAttribute("list", list);
		
		return "member/likecpHireAnnouncement";
	}
}
