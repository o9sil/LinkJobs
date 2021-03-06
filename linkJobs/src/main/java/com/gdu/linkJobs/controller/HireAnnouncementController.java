package com.gdu.linkJobs.controller;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.linkJobs.service.AnnouncementService;
import com.gdu.linkJobs.service.CpMemberService;
import com.gdu.linkJobs.service.HireAnnouncementService;
import com.gdu.linkJobs.service.IndustryService;
import com.gdu.linkJobs.service.JobService;
import com.gdu.linkJobs.vo.AnnouncementList;
import com.gdu.linkJobs.vo.CpMember;
import com.gdu.linkJobs.vo.DayAndAnnouncement;
import com.gdu.linkJobs.vo.HireAnnouncement;
import com.gdu.linkJobs.vo.ResumeApplyByAnnouncement;


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
	
	//채용공고에 지원한 지원자들 리스트 출력 페이지
	@GetMapping("/getResumeApplyByAnnouncement")
	public String getResumeApplyByAnnouncement(Model model, HttpSession session, @RequestParam(value="hireAnnouncementNo") int hireAnnouncementNo) {
		if (session.getAttribute("loginCpMember") == null) {
			return "redirect:/getAnnouncementList";
		}
		
		String loginCpMember = (String) session.getAttribute("loginCpMember");		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginCpMember", loginCpMember);
		map.put("hireAnnouncementNo", hireAnnouncementNo);
		
		List<ResumeApplyByAnnouncement> list = announcementService.getResumeApplyByAnnouncement(map);
		for(ResumeApplyByAnnouncement r : list) {
			System.out.println(r);
		}
		
		model.addAttribute("list", list);
		
		
		return "hireAnnouncement/getAnnouncementByApply";
	}
	
	// 월별 채용공고 페이지 요청
	   @GetMapping("/getPlan")
	   public String getPlan(Model model, HttpSession session, @RequestParam(value="day", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate day) {
	      // 로그인이 되어있지 않으면
	      if(session.getAttribute("loginCpMember") == null) {
	         return "redirect:/getPlan";
	      }
	     Calendar cDay = Calendar.getInstance();
	     if(day == null) {
	        day = LocalDate.now();
	     } else {
	        // day -- cDay 변환
	        // LocalDate -> Calendar
	        // 오늘 날짜에서 day값과 동일하게 변경
	        cDay.set(day.getYear(), day.getMonthValue()-1, day.getDayOfMonth());
	     }
	     String loginCpMember = (String) session.getAttribute("loginCpMember");
	     int year = cDay.get(Calendar.YEAR);
	     System.out.println(year);
	     int month = cDay.get(Calendar.MONTH)+1;
	     
	     Map<String, Object> map = new HashMap<String, Object>();
	     
	     
	     String cpMemberId = (String) session.getAttribute("loginCpMember");
	     map.put("cpmemberId", cpMemberId);	     
	     map.put("hireAnnouncementStartDate", cDay.get(Calendar.YEAR) + "-" + (cDay.get(Calendar.MONTH)+1) + "-" + cDay.getActualMaximum(Calendar.DATE));
	     map.put("hireAnnouncementEndDate", cDay.get(Calendar.YEAR) + "-" + (cDay.get(Calendar.MONTH)+1) + "-" + cDay.getActualMinimum(Calendar.DATE));
	     
	     
	     
	     System.out.println(cDay.get(Calendar.YEAR) + "-" + (cDay.get(Calendar.MONTH)+1) + "-" + cDay.getActualMaximum(Calendar.DATE));
	     System.out.println(cDay.get(Calendar.YEAR) + "-" + (cDay.get(Calendar.MONTH)+1) + "-" + cDay.getActualMinimum(Calendar.DATE));
	     
	     List<DayAndAnnouncement> list = hireAnnouncementService.getHireAnnouncementPlan(map);
	     
	     List<String> listStartDay = new ArrayList<String>();
	     List<String> listEndDay = new ArrayList<String>();
	     
	     for(DayAndAnnouncement j : list) {
	    	 listStartDay.add(j.getHireAnnouncementStartDate().substring(0, 10));
	    	 listEndDay.add(j.getHireAnnouncementEndDate().substring(0, 10));
	     }
	     
	     model.addAttribute("day", day);
	     model.addAttribute("year", cDay.get(Calendar.YEAR));
	     model.addAttribute("month", cDay.get(Calendar.MONTH)+1);
	     model.addAttribute("lastDay", cDay.getActualMaximum(Calendar.DATE));
	     model.addAttribute("list", list);
	     model.addAttribute("listStartDay", listStartDay);
	     model.addAttribute("listEndDay", listEndDay);
	     Calendar firstDay = cDay;
	     firstDay.set(Calendar.DATE, 1);
	     
	     model.addAttribute("firstDayOfWeek", firstDay.get(Calendar.DAY_OF_WEEK));
	     
	     return "hireAnnouncement/getPlan";
	 }
	
	
	// 마감처리
	@GetMapping("/modifyDeadlineAnnouncement")
	public String modifyDeadlineAnnouncement(HttpSession session, @RequestParam("hireAnnouncementNo") int hireAnnouncementNo) {
		// 로그인중이 아닐때
		if(session.getAttribute("loginCpMember") == null) {
			return "redirect:/getAnnouncementList";
		}
		
		String loginCpMember = (String) session.getAttribute("loginCpMember");
		
		HireAnnouncement hireAnnouncement = new HireAnnouncement();
		hireAnnouncement.setHireAnnouncementNo(hireAnnouncementNo);
		hireAnnouncement.setCpmemberId(loginCpMember);
		
		hireAnnouncementService.modifyDeadlineAnnouncement(hireAnnouncement);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/getAnnouncementListByCpMember";
	}
	
	
		    
	
	//채용공고 리스트 액션
	@PostMapping("/getAnnouncementListByCpMember")
	public String getAnnouncementListByCpMemberAction(HttpSession session) {
		// 로그인중이 아닐때
		if(session.getAttribute("loginCpMember") == null) {
			return "redirect:/getAnnouncementList";
		}	
		
		return "redirect:/getAnnouncementList";
	}
	
	//채용공고 리스트 보기
	@GetMapping("/getAnnouncementListByCpMember")
	public String getAnnouncementListByCpMember(Model model, HttpSession session) {
		// 로그인중이 아닐때
		if(session.getAttribute("loginCpMember") == null) {
			return "redirect:/getAnnouncementList";
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
			return "redirect:/getAnnouncementList";
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
			return "redirect:/getAnnouncementList";
		}
	  
		System.out.println("공고번호 = " + hireAnnouncementNo);
		
		HireAnnouncement hireAnnouncement = hireAnnouncementService.getHireAnnouncementDetail(hireAnnouncementNo);
		
		
		
		String loginCpMemberID = (String) session.getAttribute("loginCpMember");
				
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
		
		System.out.println(hireAnnouncementService.getHireAnnouncementOne(hireAnnouncementNo));
		
		model.addAttribute("hireAnnouncement", hireAnnouncementService.getHireAnnouncementOne(hireAnnouncementNo));
	  
		return "hireAnnouncement/getAnnouncementOne";
	  }
	 
	
	// 채용공고 등록 폼
	@GetMapping("/recordAnnouncement")
	public String recordAnnouncement(HttpSession session, Model model) {
		// 로그인 중
		if(session.getAttribute("loginCpMember") == null) {
			return "redirect:/getAnnouncementList";
		}
		String loginCpMemberID = (String) session.getAttribute("loginCpMember");
		
		
		Map<String, Object> map = cpMemberService.getCpMemberDetail(loginCpMemberID);		
		
		model.addAttribute("cpMember", map.get("cpMember"));
		model.addAttribute("areaAndArea2", map.get("areaAndArea2"));
		
		System.out.println(("areaAndArea2 = " + map.get("areaAndArea2")));
		
		Map<String, Object> jobMap = jobService.getJobListAll();
		
		model.addAttribute("job", jobMap.get("jobList"));
		model.addAttribute("job2", jobMap.get("job2List"));
		model.addAttribute("job3", jobMap.get("job3List"));
		
		model.addAttribute("industryList", industryService.getIndustryList());
		return "hireAnnouncement/recordAnnouncement";
	}
	
	//채용공고 등록 액션
	@PostMapping("/recordAnnouncement")
	public String recordAnnouncement(HttpSession session, HireAnnouncement hireAnnouncement, CpMember cpMember, @RequestParam(value="address") String address, 
			@RequestParam(value="areaSido") String areaSido, @RequestParam(value="areaGungu") String areaGungu) {
		// 로그인 중
		if(session.getAttribute("loginCpMember") == null) {
			return "redirect:/getAnnouncementList";
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
		
		return "redirect:/getAnnouncementList";
	}
}
