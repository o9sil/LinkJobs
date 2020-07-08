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
		scrap.setScrapBoolean(scrapBoolean);
		scrap.setHireAnnouncementNo(hireAnnouncementNo);
		System.out.println(memberId+"<--memberId");
		System.out.println(hireAnnouncementNo+"<--hireAnnouncementNo");

	
		return scrapService.insertScrap(scrap);
	}
	
	
	
	@PostMapping("/modifyScrap")
	public int modifyScrap(@RequestParam("scrapNo") int scrapNo, @RequestParam("scrapBoolean") String scrapBoolean) {
		String memberId = "user";	
		Scrap scrap = new Scrap();
		scrap.setMemberId(memberId);
		System.out.println(memberId+"<--memberId");
		scrap.setScrapNo(scrapNo);
		scrap.setScrapBoolean(scrapBoolean);
		
		return scrapService.modifyScrap(scrap);
	}
}
