package com.gdu.linkJobs.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.linkJobs.service.AnnouncementService;
import com.gdu.linkJobs.service.CpMemberService;
import com.gdu.linkJobs.service.HireAnnouncementService;
import com.gdu.linkJobs.service.IndustryService;
import com.gdu.linkJobs.service.JobService;
import com.gdu.linkJobs.vo.AnnouncementList;
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
	
	@Autowired
	private AnnouncementService announcementService;
	
	//채용공고 리스트 보기
	@GetMapping("/getAnnouncementListByCpMember")
	public String getAnnouncementListByCpMember(Model model, HttpSession session) {
		// 로그인중이 아닐때
		if(session.getAttribute("loginCpMember") == null) {
			return "redirect:/";
		}
		
		String cpMemberId = (String) session.getAttribute("loginCpMember");
		
		List<AnnouncementList> list = announcementService.getAnnouncementListByCpMember(cpMemberId);
		
		System.out.println(list);
		model.addAttribute("list", list);
		
		return "hireAnnouncement/getAnnouncementListByCpMember";
	}
	
	//채용공고 수정 액션
	@PostMapping("/modifyAnnouncementOne")
	public String modifyAnnouncementOneAction(HttpSession session, HireAnnouncement hireAnnouncement) {
		// 로그인중이 아닐때
		if(session.getAttribute("loginCpMember") == null) {
			return "redirect:/";
		}
		String cpMemberId = (String) session.getAttribute("loginCpMember");
				
		hireAnnouncement.setCpmemberId(cpMemberId);
		System.out.println(hireAnnouncement);
		hireAnnouncementService.modifyHireAnnouncementOne(hireAnnouncement);
		
		return "redirect:/getAnnouncementListByCpMember";
	}
	
	
	//채용공고 수정 폼
	@GetMapping("/modifyAnnouncementOne")
	public String modifyAnnouncementOne(Model model, HttpSession session, @RequestParam("hireAnnouncementNo") int hireAnnouncementNo) {
		// 로그인중이 아닐때
		if(session.getAttribute("loginCpMember") == null) {
			return "redirect:/";
		}
	  
		System.out.println("공고번호 = " + hireAnnouncementNo);
		
		HireAnnouncement hireAnnouncement = hireAnnouncementService.getHireAnnouncementDetail(hireAnnouncementNo);
		
		
		
		String loginCpMemberID = (String) session.getAttribute("loginCpMember");
		
		@SuppressWarnings("unchecked")
		Map<String, Object> map = cpMemberService.getCpMemberDetail(loginCpMemberID);		
		
		model.addAttribute("cpMember", map.get("cpMember"));
		model.addAttribute("areaAndArea2", map.get("areaAndArea2"));
		
		//System.out.println(("areaAndArea2 = " + map.get("areaAndArea2")));
		
		Map<String, Object> jobMap = jobService.getJobListAll();
		model.addAttribute("job", jobMap.get("job"));
		model.addAttribute("job2", jobMap.get("job2"));
		model.addAttribute("job3", jobMap.get("job3"));
		
		model.addAttribute("industryList", industryService.getIndustryList());
		
		System.out.println(hireAnnouncement);
		model.addAttribute("hireAnnouncement", hireAnnouncement);
		
		return "hireAnnouncement/alterAnnouncement"; 
	  }
	
	
	// 채용공고 상세보기
	
	@GetMapping("/aboutAnnouncementOne")
	public String aboutAnnouncementOne(Model model, HttpSession session, @RequestParam("hireAnnouncementNo") int hireAnnouncementNo) {
		// 로그인중이 아닐때
		if(session.getAttribute("loginCpMember") == null) {
			return "redirect:/";
		}
	  
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
