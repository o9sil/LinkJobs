package com.gdu.linkJobs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.linkJobs.service.SelfIntroductionService;
import com.gdu.linkJobs.vo.LoginMember;
import com.gdu.linkJobs.vo.SelfIntroduction;

@Controller
public class SelfIntroductionController {
	@Autowired 
	private SelfIntroductionService selfIntroductionService;
	
	//자소서 리스트 출력
	@GetMapping("/getSelfIntroductionList")
	public String getSelfIntroductionList(@RequestParam("memberId") String memberId, Model model,HttpSession session){
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		
		List<SelfIntroduction> selfIntroList = selfIntroductionService.getSelfIntroductionList(memberId);
		System.out.println(selfIntroList);
		model.addAttribute("selfIntroductionList", selfIntroList);
		return "member/getSelfIntroductionList";
	}
	//자소서 상세보기
	@GetMapping("/getSelfIntroductionOne")
	public String getSelfIntroductionOne (@RequestParam("selfIntroductionNo") int selfIntroductionNo, Model model, HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		SelfIntroduction si = selfIntroductionService.getSelfIntroductionOne(selfIntroductionNo);
		model.addAttribute("selfIntroductionOne", si);
		return "member/getSelfIntroductionOne";
	}
	
	//자소서 수정 폼
	@GetMapping("/modifySelfIntroduction")
	public String getSelfIntroductionOne (@RequestParam("selfIntroductionNo") int selfIntroductionNo, Model model, 
									SelfIntroduction selfIntroduction, HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		SelfIntroduction si = selfIntroductionService.getSelfIntroductionOne(selfIntroductionNo);
		model.addAttribute("selfIntroductionOne", si);
		return "member/modifySelfIntroduction";
	}
	
	
	//자소서 수정 액션
	@PostMapping("/modifySelfIntroduction")
	public String modifySelfIntroduction(SelfIntroduction selfIntroduction, HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		selfIntroductionService.modifySelfIntroductio(selfIntroduction);
		return "redirect:/member/getSelfIntroductionList";
	}
	
	
	//자소서 삭제
	@GetMapping("/removeSelfIntroduction")
	public String removeSelfIntroduction(@RequestParam("selfIntroductionNo") int selfIntroductionNo, HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		selfIntroductionService.removeSelfIntroduction(selfIntroductionNo);
		return "redirect:/member/getSelfIntroductionList";
	}
	
	//자소서 추가 폼
	@GetMapping("/addSelfIntroduction")
	public String addSelfIntroduction(HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		return "member/addSelfIntroduction";
	}
	
	//자소서 추가 액션
	@PostMapping("/addSelfIntroduction")
	public String addSelfIntroduction(SelfIntroduction selfIntroduction, HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		selfIntroductionService.addSelfIntroduction(selfIntroduction);
		return "redirect:/member/getSelfIntroductionList";
	}
}
