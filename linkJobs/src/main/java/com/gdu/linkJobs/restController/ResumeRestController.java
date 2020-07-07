package com.gdu.linkJobs.restController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gdu.linkJobs.service.MemberCertificateService;
import com.gdu.linkJobs.service.ResumeService;
import com.gdu.linkJobs.vo.MemberCertificate;
import com.gdu.linkJobs.vo.Resume;

@RestController
public class ResumeRestController {

	@Autowired private ResumeService resumeService;
	@Autowired private MemberCertificateService memberCertificateService;
	
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
	
	@PostMapping("/addCertificate")
	 public int modifyResumeAvaliability(@RequestParam("certificateName") String certificateName, @RequestParam("certificateDate") String certificateDate) {
	      System.out.println(certificateName+"<--certificateName");
	      System.out.println(certificateDate+"<--certificateDate");
	      String memberId = "user";
	      MemberCertificate memberCertificate = new MemberCertificate();
	      memberCertificate.setMemberId(memberId);
	      memberCertificate.setCertificateName(certificateName);
	      memberCertificate.setCertificateDate(certificateDate);
	      
	      return memberCertificateService.addMemberCertificate(memberCertificate);
	   }
	
}
