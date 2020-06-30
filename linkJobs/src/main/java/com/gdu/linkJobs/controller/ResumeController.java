package com.gdu.linkJobs.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.linkJobs.service.ResumeService;
import com.gdu.linkJobs.vo.Resume;

@Controller
public class ResumeController {
	@Autowired private ResumeService resumeService;
	
	// 이력서 추가 폼
	@GetMapping("/addResume")
	public String addResume() {
		return "resume/addResume";
	}
	
	// 이력서 추가 액션
	@PostMapping("/addResume")
	public String addResume(Resume resume) {
		
		resume.setMemberId("user"); // 샘플 데이터
		resumeService.addResume(resume);
		return "redirect:/getResume";
	}
	
	// 이력서 삭제
	@GetMapping("/removeResume")
	public String removeResume(Resume resume) {
		/*
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		*/
		
		resume.getMemberId();
		resume.getResumeNo();
		System.out.println(resume.getMemberId());
		System.out.println(resume.getResumeNo());
		resumeService.removeResume(resume);
		return "redirect:/getResume";
	}
	
	// 이력서 목록
	@GetMapping("/getResume")
	public String selectResume(String memberId, Model model) {
		/*
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		*/
		memberId = "user";
		List<Resume> list = resumeService.getResume(memberId);
		model.addAttribute("list", list);
		return "resume/getResume";
	}
}
