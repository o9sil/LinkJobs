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
	
	
	//이력서 상세보기
	@GetMapping("getDetailResume")
	public String getDetailResume(Resume resume, Model model) {
		List<Resume> resumelist = resumeService.getDetailResume(resume);
		model.addAttribute("resumelist", resumelist);
		
		return "resume/getDetailResume";
	}
	
	
	// 이력서 추가 폼
	@GetMapping("/addResume")
	public String addResume(Model model) {
		List<Area> areaList = areaService.getArea();
		List<AreaAndArea2> area2List = areaService.getResumeArea2();
		model.addAttribute("areaList", areaList);
		model.addAttribute("area2List", area2List);
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
		int count = resumeService.getResumeCount(memberId);
		System.out.println(count+"<--count");
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		return "resume/getResume";
	}
}
