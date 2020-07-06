package com.gdu.linkJobs.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.linkJobs.service.CpMemberService;
import com.gdu.linkJobs.service.HireAnnouncementService;
import com.gdu.linkJobs.service.IndustryService;
import com.gdu.linkJobs.service.JobService;
import com.gdu.linkJobs.vo.CpMember;
import com.gdu.linkJobs.vo.HireAnnouncement;

@Controller
public class HireAnnouncementController {
	@Autowired
	private HireAnnouncementService hireAnnouncementService;
	
	@Autowired
	private CpMemberService cpMemberService;
	
	@Autowired
	private IndustryService industryService;
	
	@Autowired
	private JobService jobService;
	
	// 채용공고 상세보기
	
	@GetMapping("/aboutAnnouncementOne")
	public String aboutAnnouncementOne(Model model, HttpSession session) {
		// 로그인중이 아닐때
		if(session.getAttribute("loginCpMember") != null) {
			return "redirect:/";
		}
	  
		int hireAnnouncement = ((HireAnnouncement)session.getAttribute("hireAnnouncement")).getHireAnnouncementNo();
		
		System.out.println(hireAnnouncement+"<--HireAnnouncementController : aboutAnnouncementOne-hireAnnouncementNo ");
		
		return ""; 
	  }
	 
	
	// 채용공고 등록 폼
	@GetMapping("/recordAnnouncement")
	public String recordAnnouncement(HttpSession session, Model model) {
		// 로그인 중
		if(session.getAttribute("loginCpMember") == null) {
			return "redirect:/";
		}
		String loginCpMemberID = (String) session.getAttribute("loginCpMember");
		
		
		
		@SuppressWarnings("unchecked")
		Map<String, Object> map = cpMemberService.getCpMemberDetail(loginCpMemberID);		
		
		model.addAttribute("cpMember", map.get("cpMember"));
		model.addAttribute("areaAndArea2", map.get("areaAndArea2"));
		
		System.out.println(("areaAndArea2 = " + map.get("areaAndArea2")));
		
		Map<String, Object> jobMap = jobService.getJobListAll();
		model.addAttribute("job", jobMap.get("job"));
		model.addAttribute("job2", jobMap.get("job2"));
		model.addAttribute("job3", jobMap.get("job3"));
		
		model.addAttribute("industryList", industryService.getIndustryList());
		return "hireAnnouncement/recordAnnouncement";
	}
	
	//채용공고 등록 액션
	@PostMapping("/recordAnnouncement")
	public String recordAnnouncement(HttpSession session, HireAnnouncement hireAnnouncement, CpMember cpMember, @RequestParam(value="address") String address, 
			@RequestParam(value="areaSido") String areaSido, @RequestParam(value="areaGungu") String areaGungu) {
		// 로그인 중
		if(session.getAttribute("loginCpMember") == null) {
			return "redirect:/";
		}
		
		String loginCpMemberId = (String) session.getAttribute("loginCpMember");
		
//		System.out.println("채용공고 등록 여부확인");
//		
//		System.out.println(hireAnnouncement);
//		System.out.println(cpMember);
//		System.out.println(address);
		
		hireAnnouncement.setCpmemberId(loginCpMemberId);
		hireAnnouncement.setHireAnnouncementManager(cpMember.getCpMemberManager());
		
		hireAnnouncementService.addHireAnnouncement(hireAnnouncement);
		
		return "redirect:/";
	}
}
