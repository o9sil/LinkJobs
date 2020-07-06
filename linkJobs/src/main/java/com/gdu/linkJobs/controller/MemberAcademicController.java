package com.gdu.linkJobs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.linkJobs.service.MemberAcademicService;
import com.gdu.linkJobs.vo.MemberAcademic;

@Controller
public class MemberAcademicController {
	@Autowired
	private MemberAcademicService academicService;
	
	//학력 리스트 출력 폼
	@GetMapping("/getMemberAcademicList")
	public String getMemberAcademic(HttpSession session,Model model) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		String memberId=(String)session.getAttribute("loginMember");
		MemberAcademic MA=new MemberAcademic();
		MA.setMemberId(memberId);
		List<MemberAcademic> academicList = academicService.getMemberAcademicList(memberId);
		model.addAttribute("academicList", academicList);
		
		return "member/getMemberAcademicList";
	}
	
	//학력 추가 폼
	@GetMapping("/addMemberAcademic")
	public String addMemberAcademic(HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		return "member/addMemberAcademic";
	}
	//학력 추가 액션
	@PostMapping("/addMemberAcademic")
	public String addMemberAcademic(HttpSession session,MemberAcademic memberAcademic) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		String memberId=(String)session.getAttribute("loginMember");
		memberAcademic.setMemberId(memberId);
		academicService.addMemberAcademic(memberAcademic);
		return "redirect:/getMemberAcademicList";
	}
	
	//학력 수정 폼
	@GetMapping("/modifyMemberAcademic")
	public String modifyMemberAcademic(HttpSession session,Model model,
			@RequestParam("academicNo") int academicNo) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		MemberAcademic ma=academicService.getMemberAcademicOne(academicNo);
		model.addAttribute("ma", ma);
		return "member/modifyMemberAcademic";
	}
	
	//학력 수정 액션
	@PostMapping("/modifyMemberAcademic")
	public String modifyMemberAcademic(HttpSession session,MemberAcademic memberAcademic) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		
		academicService.modifyMemberAcademic(memberAcademic);
		return "redirect:/getMemberAcademicList";
	}
	
	//학력 삭제 액션
	@GetMapping("/removeMemberAcademic")
	public String removeMemberAcademic(HttpSession session, @RequestParam("academicNo") int academicNo) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		System.out.println(academicNo+"<--academicNo.removeMemberAcademic");
		academicService.removeMemberAcademic(academicNo);
		return "redirect:/getMemberAcademicList";
	}
	
	
}
