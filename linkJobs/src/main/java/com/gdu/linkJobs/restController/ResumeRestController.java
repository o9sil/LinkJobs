package com.gdu.linkJobs.restController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gdu.linkJobs.service.ResumeService;
import com.gdu.linkJobs.vo.Resume;

@RestController
public class ResumeRestController {

	@Autowired private ResumeService resumeService;
	
	@PostMapping("/modifyResumeAvaliability")
	 public int modifyResumeAvaliability(@RequestParam("resumeNo") int resumeNo, @RequestParam("resumeAvaliability") String resumeAvaliability) {
	      System.out.println(resumeNo+"<--resumeNo");
	      String memberId = "user";
	      Resume resume = new Resume();
	      resume.setMemberId(memberId);
	      resume.setResumeNo(resumeNo);
	      resume.setResumeAvaliability(resumeAvaliability);
	      return resumeService.modifyResumeAvaliability(resume);
	   }
	
}
