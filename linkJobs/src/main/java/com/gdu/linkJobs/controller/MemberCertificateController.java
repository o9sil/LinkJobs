package com.gdu.linkJobs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.linkJobs.service.MemberCertificateService;
import com.gdu.linkJobs.vo.LoginMember;
import com.gdu.linkJobs.vo.MemberCertificate;

@Controller
public class MemberCertificateController {
	@Autowired
	private MemberCertificateService memberCertificateService;
	
	//자격증 등록 폼
	@GetMapping("/addMemberCertificate")
	public String addMemberCertificate(HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/getAnnouncementList";
		}
		return "member/addMemberCertificate";
	}
	//자격증 등록 액션
	@PostMapping("/addMemberCertificate")
	public String addMemberCertificate(MemberCertificate memberCertificate,HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		
		String memberId=(String) session.getAttribute("loginMember");
		System.out.println(memberId);
		memberCertificate.setMemberId(memberId);
		memberCertificateService.addMemberCertificate(memberCertificate);
		
		return "redirect:/getMemberCertificateList";
	}
	
	//자격증 수정 폼
	@GetMapping("/modifyMemberCertificate")
	public String modifyMemberCertificate(@RequestParam("certificateNo") int certificateNo,
									Model model,HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/getAnnouncementList";
		}
		MemberCertificate MC= memberCertificateService.getMemberCertificateOne(certificateNo);
		model.addAttribute("memberCertificate", MC);
		return "member/modifyMemberCertificate";
	}
	//자격증 수정 액션
	@PostMapping("/modifyMemberCertificate")
	public String modifyMemberCertificate(MemberCertificate memberCertificate, HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/getAnnouncementList";
		}
		String memberId=(String) session.getAttribute("loginMember");
		System.out.println(memberId+"<--memberId.memberCertificate");
		memberCertificate.setMemberId(memberId);
		memberCertificateService.modifyMemberCertificate(memberCertificate);
		return "redirect:/getMemberCertificateList";
	}
	
	//자격증 삭제
	@GetMapping("/removeMemberCertificate")
	public String removeMemberCertificate(@RequestParam("certificateNo") int certificateNo,HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/getAnnouncementList";
		}
		
		memberCertificateService.removeMemberCertificate(certificateNo);
		return "redirect:/getMemberCertificateList";
	}
	
	//자격증 회원별 리스트 출력 폼
	@GetMapping("/getMemberCertificateList")
	public String getMemberCertificateList( Model model,HttpSession session) {
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/getAnnouncementList";
		}
		String memberId=(String) session.getAttribute("loginMember");
		System.out.println(memberId+"<--memberId.memberCertificate");
		MemberCertificate memberCertificate=new MemberCertificate();
		memberCertificate.setMemberId(memberId);
		List<MemberCertificate> certificateList=memberCertificateService.getMemberCertificateList(memberId);
		model.addAttribute("certificateList", certificateList);
		return "member/getMemberCertificateList";
	}
	
	
	
	
}
