package com.gdu.linkJobs.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.linkJobs.service.AreaService;
import com.gdu.linkJobs.service.ResumeService;
import com.gdu.linkJobs.vo.Resume;
import com.gdu.linkJobs.vo.Area;
import com.gdu.linkJobs.vo.AreaAndArea2;

@Controller
public class ResumeController {
	@Autowired private ResumeService resumeService;
	@Autowired private AreaService areaService;
	

	
	// 이력서 공개/비공개
	@PostMapping("/resumeAvaliability")
	public String updateResumeAvaliability(Resume resume, HttpSession session) {
		System.out.println(resume+"<--resumecontroller");
		
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		
		resume.getMemberId();
		resume.getResumeNo();
		System.out.println(resume.getResumeNo()+"<--resumeNo");
		System.out.println(resume.getMemberId()+"<--memberId");
		resumeService.resumeAvaliability(resume);
		
		return "redirect:/getResume";
	}

	
	//이력서 상세보기
	@GetMapping("getDetailResume")
	public String getDetailResume(Resume resume, Model model, HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		List<Resume> resumelist = resumeService.getDetailResume(resume);
		model.addAttribute("resumelist", resumelist);
		
		return "resume/getDetailResume";
	}
	
	
	// 이력서 추가 폼
	@GetMapping("/addResume")
	public String addResume(Model model, HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		List<Area> areaList = areaService.getArea();
		model.addAttribute("areaList", areaList);
		return "resume/addResume";
	}
	
	// 이력서 추가 액션
	@PostMapping("/addResume")
	public String addResume(Resume resume, HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		
		resume.setMemberId("user"); // 샘플 데이터
		resumeService.addResume(resume);
		return "redirect:/getResume";
	}
	
	
	
	// 이력서 삭제
	@GetMapping("/removeResume")
	public String removeResume(Resume resume, HttpSession session) {
		
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		
		
		resume.getMemberId();
		resume.getResumeNo();
		System.out.println(resume.getMemberId());
		System.out.println(resume.getResumeNo());
		resumeService.removeResume(resume);
		return "redirect:/getResume";
	}
	
	// 이력서 목록
	@GetMapping("/getResume")
	public String selectResume(String memberId, Model model, HttpSession session) {
		
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		
		memberId = "user";
		List<Resume> list = resumeService.getResume(memberId);
		int count = resumeService.getResumeCount(memberId);
		System.out.println(count+"<--count");
		model.addAttribute("list", list);
		model.addAttribute("memberId", memberId);
		model.addAttribute("count", count);
		return "resume/getResume";
	}
}
