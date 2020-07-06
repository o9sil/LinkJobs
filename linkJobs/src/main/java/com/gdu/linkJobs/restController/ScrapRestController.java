package com.gdu.linkJobs.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gdu.linkJobs.service.ScrapService;
import com.gdu.linkJobs.vo.Scrap;

@RestController
public class ScrapRestController {
	@Autowired private ScrapService scrapService;
	
	
	@PostMapping("/insertScrap")
	public int insertScrap(@RequestParam("hireAnnouncementNo") int hireAnnouncementNo, @RequestParam("scrapBoolean") String scrapBoolean) {
		String memberId = "user";	
		Scrap scrap = new Scrap();
		scrap.setMemberId(memberId);
		scrap.setHireAnnouncementNo(hireAnnouncementNo);
		scrap.setScrapBoolean(scrapBoolean);
		System.out.println(memberId+"<--memberId");
		System.out.println(hireAnnouncementNo+"<--hireAnnouncementNo");
		System.out.println(scrapBoolean+"<--scrapBoolean");
	
		return scrapService.insertScrap(scrap);
	}
	
	
	
	@PostMapping("/modifyScrap")
	public int modifyScrap(@RequestParam("hireAnnouncementNo") int hireAnnouncementNo, @RequestParam("scrapBoolean") String scrapBoolean) {
		String memberId = "user";	
		Scrap scrap = new Scrap();
		scrap.setMemberId(memberId);
		System.out.println(memberId+"<--memberId");
		scrap.setHireAnnouncementNo(hireAnnouncementNo);
		System.out.println(hireAnnouncementNo+"<--hireAnnouncementNo");
		scrap.setScrapBoolean(scrapBoolean);
		System.out.println(scrapBoolean+"<--scrapBoolean");
		return scrapService.modifyScrap(scrap);
	}
}
