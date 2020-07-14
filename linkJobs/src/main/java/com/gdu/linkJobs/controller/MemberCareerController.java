package com.gdu.linkJobs.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.linkJobs.service.AreaService;
import com.gdu.linkJobs.service.JobService;
import com.gdu.linkJobs.service.MemberCareerService;
import com.gdu.linkJobs.vo.Area;
import com.gdu.linkJobs.vo.MemberCareer;
import com.gdu.linkJobs.vo.MemberCareerAndJobAndArea;

@Controller
public class MemberCareerController {
	@Autowired MemberCareerService memberCareerService;
	@Autowired JobService jobService;
	@Autowired AreaService areaService;
	
	//경력사항 리스트 출력
	@GetMapping("/getMemberCareerList")
	public String getMemberCareerList(HttpSession session, Model model) {
		//로그인 되지 않은 상태면 redirect
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/getAnnouncementList";
		}
		String memberId = (String)session.getAttribute("loginMember");
		
		List<MemberCareerAndJobAndArea> list = memberCareerService.getMemberCareerList(memberId);
		model.addAttribute("list", list);
		
		return "member/getMemberCareerList";
	}
	
	//경력사항 리스트 상체보기
	@GetMapping("/getMemberCareerOne")
	public String getMemberCareerOne(HttpSession session, Model model, int careerNo) {
		//로그인 되지 않은 상태면 redirect
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/getAnnouncementList";
		}
		
		MemberCareerAndJobAndArea mc = memberCareerService.getMemberCareerOne(careerNo);
		model.addAttribute("mc", mc);
		
		return "member/getMemberCareerOne";
	}
	
	//경력사항 추가하기 Form
	@GetMapping("/addMemberCareer")
	public String addMemberCareer(HttpSession session,Model model) {
		//로그인 되지 않은 상태면 redirect
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/getAnnouncementList";
		}
		
		List<Area> areaList = areaService.getArea();
		model.addAttribute("areaList", areaList);
		
		Map<String, Object> map = jobService.getJobListAll();
		System.out.println(map.get("jobList")+"<--map.get(\"jobList\")");
		model.addAttribute("jobList",map.get("jobList"));
		
		model.addAttribute("job2List",map.get("job2List"));
		model.addAttribute("job3List",map.get("job3List"));
		
		return "member/addMemberCareer";
	}
	 
	//경력사항 추가하기 Action
	@PostMapping("/addMemberCareer")
	public String addMemberCareer(HttpSession session, MemberCareer memberCareer) {
		//로그인 되지 않은 상태면 redirect
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/getAnnouncementList";
		}
		
		memberCareerService.addMemberCareer(memberCareer);
		
		return "redirect:/getMemberCareerList";
	}
	
	
	//경력사항 수정 폼
	@GetMapping("/modifyMemberCareer")
	public String modifyMemberCareer(HttpSession session, Model model, int careerNo) {
		//로그인 되지 않은 상태면 redirect
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/getAnnouncementList";
		}
		
		MemberCareerAndJobAndArea mc = memberCareerService.getMemberCareerOne(careerNo);
		model.addAttribute("mc", mc);
		
		List<Area> areaList = areaService.getArea();
		model.addAttribute("areaList", areaList);
		
		Map<String, Object> map = jobService.getJobListAll();
		model.addAttribute("jobList",map.get("jobList"));
		model.addAttribute("job2List",map.get("job2List"));
		model.addAttribute("job3List",map.get("job3List"));
		
		return "member/modifyMemberCareer";
	}
	
	//경력사항 수정 액션
	@PostMapping("/modifyMemberCareer")
	public String modifyMemberCareer(HttpSession session, MemberCareer memberCareer) {
		memberCareerService.modifyMemberCareer(memberCareer);
		
		return "redirect:/getMemberCareerOne";
	}
	
	
	//경력사항 삭제
	@GetMapping("/removeMemberCareer")
	public String removeMemberCareer(HttpSession session, int careerNo) {
		memberCareerService.removeMemberCareer(careerNo);
		
		return "redirect:/getMemberCareerList";
	}
	
}
