package com.gdu.linkJobs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.linkJobs.service.ResumeApplyService;
import com.gdu.linkJobs.vo.ResumeApply;

@Controller
public class ResumeApplyController {
	@Autowired
	private ResumeApplyService resumeApplyService;
	
	
	@PostMapping("/resumeApply")
	public String resumeApply(HttpSession session,ResumeApply resumeApply) {
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/getAnnouncementList";
		}
		resumeApplyService.addResumeApply(resumeApply);
		return "redirect:/getAnnouncementList";
	}
}
