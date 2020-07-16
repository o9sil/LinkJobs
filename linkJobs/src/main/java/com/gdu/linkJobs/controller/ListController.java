package com.gdu.linkJobs.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.linkJobs.service.JobService;
import com.gdu.linkJobs.service.ListService;
import com.gdu.linkJobs.service.ScrapService;
import com.gdu.linkJobs.vo.HireAnnouncementAndCpMemberAndScrapAndLikecp;
import com.gdu.linkJobs.vo.Job;
import com.gdu.linkJobs.vo.Scrap;

@Controller
public class ListController {
	@Autowired private ListService listService;
	@Autowired private ScrapService scrapService; 
	@Autowired private JobService jobService;
	
	// 메인페이지 채용공고 리스트(일반회원)
	@GetMapping("/getAnnouncementList")
	public String getHireAnnouncementList(HttpSession session, Model model, HireAnnouncementAndCpMemberAndScrapAndLikecp hireAnnouncementAndCpMemberAndScrapAndLikecp) {
		// 로그인 중
		//if (session.getAttribute("loginMember") != null) {
		//		return "hireAnnouncement/getLoginAnnouncementList";
		//} 
		
		
		List<HireAnnouncementAndCpMemberAndScrapAndLikecp> list = listService.selectHireAnnouncementList(hireAnnouncementAndCpMemberAndScrapAndLikecp);
		List<Scrap> scrapList = scrapService.selectBoolean();
		Map<String, Object> jobMap = jobService.getJobListAll();
		model.addAttribute("job", jobMap.get("jobList"));
		model.addAttribute("job2", jobMap.get("job2List"));
		model.addAttribute("job3", jobMap.get("job3List"));
		Job job = (Job)jobMap.get("job");
		System.out.println(job+"<<<<<<");
		
		model.addAttribute("scrapList", scrapList);
		model.addAttribute("list", list);
		System.out.println(list + "<--list");
		return "hireAnnouncement/getAnnouncementList";
		
	}
	// 메인페이지 채용공고 검색
	@PostMapping("/searchAnnouncementList")
	public String searchAnnouncementList(HttpSession session, Model model, String wordSearch, String areaSearch, String jobSearch,  HireAnnouncementAndCpMemberAndScrapAndLikecp hireAnnouncementAndCpMemberAndScrapAndLikecp) {
		// 로그인 중
		//if (session.getAttribute("loginMember") != null) {
		//		return "hireAnnouncement/getLoginAnnouncementList";
		//} 
		System.out.println(wordSearch + "<--searchAnnouncementList.wordSearch");
		System.out.println(areaSearch + "<--searchAnnouncementList.areaSearch");
		System.out.println(jobSearch + "<--searchAnnouncementList.jobSearch");
		// 검색기능 추가
		if((wordSearch == null || wordSearch == "") && (areaSearch == null || areaSearch == "") && (jobSearch == null || jobSearch == "")) {
			Map<String, Object> jobMap = jobService.getJobListAll();
			model.addAttribute("job", jobMap.get("job"));
			model.addAttribute("job2", jobMap.get("job2"));
			model.addAttribute("job3", jobMap.get("job3"));
			List<HireAnnouncementAndCpMemberAndScrapAndLikecp> list = listService.selectHireAnnouncementList(hireAnnouncementAndCpMemberAndScrapAndLikecp);
			model.addAttribute("list", list);
			model.addAttribute("msg", "검색 결과가 존재하지 않습니다.");
			return "hireAnnouncement/getAnnouncementList";
			
		} else {
			List<HireAnnouncementAndCpMemberAndScrapAndLikecp> list = listService.selectSearchHireAnnouncementList(wordSearch, areaSearch, jobSearch);
			model.addAttribute("list", list);
		}

		return "hireAnnouncement/searchAnnouncementList";
		
	}
	
	
	// 로그인시 메인페이지
	@GetMapping("/getLoginAnnouncementList")
	public String getLoginAnnouncementList(HttpSession session, Model model, HireAnnouncementAndCpMemberAndScrapAndLikecp hireAnnouncementAndCpMemberAndScrapAndLikecp) {
		
		
		// 로그인 안됬을 경우 스크랩 안되는거 해야함
		//String memberId = (String)session.getAttribute("loginMember");
		
		List<HireAnnouncementAndCpMemberAndScrapAndLikecp> list = listService.selectHireAnnouncementList(hireAnnouncementAndCpMemberAndScrapAndLikecp);
		// hireAnnouncementAndCpMemberAndScrap.setHireAnnouncementNo(hireAnnouncementNo);
		
		
		List<Scrap> scrapList = scrapService.selectBoolean();
		// model.addAttribute("memberId", memberId);
		model.addAttribute("scrapList", scrapList);
		model.addAttribute("list", list);
		System.out.println(list + "<--list");
		return "hireAnnouncement/getLoginAnnouncementList";
	}

	// 채용공고 리스트(지역별) 조건 없을경우

	@GetMapping("/getAreaAnnouncementList")
	public String getAreaAnnouncementList(Model model, HireAnnouncementAndCpMemberAndScrapAndLikecp hireAnnouncementAndCpMemberAndScrapAndLikecp) {
		List<HireAnnouncementAndCpMemberAndScrapAndLikecp> list = listService.selectHireAreaAnnouncementList(hireAnnouncementAndCpMemberAndScrapAndLikecp);
		
		model.addAttribute("list", list);
		return "hireAnnouncement/getAreaAnnouncementList";
	}

	// 채용공고 리스트(직업별) 조건 없을경우

	@GetMapping("/getJobAnnouncementList")
	public String getJobAnnouncementList(Model model, HireAnnouncementAndCpMemberAndScrapAndLikecp hireAnnouncementAndCpMemberAndScrapAndLikecp) {
		List<HireAnnouncementAndCpMemberAndScrapAndLikecp> list = listService
				.selectHireAnnouncementList(hireAnnouncementAndCpMemberAndScrapAndLikecp);
		model.addAttribute("list", list);
		return "hireAnnouncement/getJobAnnouncementList";
	}

	

}