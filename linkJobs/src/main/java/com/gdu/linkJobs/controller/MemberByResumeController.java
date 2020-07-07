package com.gdu.linkJobs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.linkJobs.service.MemberByResumeService;

@Controller
public class MemberByResumeController {

	@Autowired MemberByResumeService memberByResumeService;
	
	@GetMapping("/getResumeList")
	public String getResumeList(HttpSession session, Model model) {
		if(session.getAttribute("loginCpMember") == null) {
			return "redirect:/";
		}
		
		model.addAttribute("memberList", memberByResumeService.getMemberListByResume());
		System.out.println(memberByResumeService.getMemberListByResume());
		
		return "memberByResume/memberByResumeList";
	}
}
