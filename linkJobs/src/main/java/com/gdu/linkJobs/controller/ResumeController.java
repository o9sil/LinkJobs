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


import com.gdu.linkJobs.service.AreaService;
import com.gdu.linkJobs.service.IndustryService;
import com.gdu.linkJobs.service.JobService;
import com.gdu.linkJobs.service.MemberCareerService;
import com.gdu.linkJobs.service.MemberCertificateService;
import com.gdu.linkJobs.service.MemberService;
import com.gdu.linkJobs.service.ResumeService;
import com.gdu.linkJobs.service.MemberAcademicService;
import com.gdu.linkJobs.vo.Resume;
import com.gdu.linkJobs.vo.Area;

import com.gdu.linkJobs.vo.Member;
import com.gdu.linkJobs.vo.MemberAcademic;
import com.gdu.linkJobs.vo.MemberCareerAndJobAndArea;
import com.gdu.linkJobs.vo.MemberCertificate;

@Controller
public class ResumeController {
   @Autowired private ResumeService resumeService;
   @Autowired private AreaService areaService;
   @Autowired private MemberService memberService;
   
   @Autowired private MemberAcademicService memberAcademicService;
   @Autowired private MemberCareerService memberCareerService;
   @Autowired private MemberCertificateService memberCertificateService;
   @Autowired private JobService jobService;
   @Autowired private IndustryService industryService;
   
   
   
   // 이력서 공개/비공개
   @PostMapping("/resumeAvaliability")
   public String updateResumeAvaliability(Resume resume) {
      System.out.println(resume+"<--resumecontroller");
      
      resume.getMemberId();
      resume.getResumeNo();
      System.out.println(resume.getResumeNo()+"<--resumeNo");
      System.out.println(resume.getMemberId()+"<--memberId");
      resumeService.modifyResumeAvaliability(resume);
      
      return "redirect:/getResume";
   }
   
   
   
   
   
   //이력서 상세보기
   @GetMapping("getDetailResume")
   public String getDetailResume(Resume resume, Model model) {
      List<Resume> resumelist = resumeService.getDetailResume(resume);
      model.addAttribute("resumelist", resumelist);
      
      return "resume/getDetailResume";
   }
   
   
   // 이력서 추가 폼
   @GetMapping("/addResume")
   public String addResume(HttpSession session, Model model) {
	   if(session.getAttribute("loginMember") == null) {
	         return "redirect:/";
	   }

	  String memberId = (String) session.getAttribute("loginMember");
	   
      
	  
	  
	  @SuppressWarnings("unchecked")
	  Member memberInfo = memberService.getMemberOne(memberId);													//회원정보
      List<MemberCareerAndJobAndArea> memberCareer = memberCareerService.getMemberCareerList(memberId);			//경력사항
      List<Area> areaList = areaService.getArea();																//지역선택	
      List<MemberAcademic> memberAcademic = memberAcademicService.getMemberAcademic(memberId);					//학력사항
      List<MemberCertificate> certificateList = memberCertificateService.getMemberCertificateList(memberId);	// 자격증정보
      Map<String, Object> jobMap = jobService.getJobListAll();
      model.addAttribute("job", jobMap.get("job"));
      model.addAttribute("job2", jobMap.get("job2"));
      model.addAttribute("job3", jobMap.get("job3"));
		
      model.addAttribute("memberCareer", memberCareer);
      model.addAttribute("memberInfo", memberInfo);
      model.addAttribute("memberAcademic", memberAcademic);
      model.addAttribute("certificateList", certificateList);
      model.addAttribute("areaList", areaList);
      model.addAttribute("industryList", industryService.getIndustryList());
      
      
      System.out.println("회원정보>>>>>>"+memberInfo);
      System.out.println("경력사항>>>>>>"+memberCareer);
      System.out.println("지역선택>>>>>>"+areaList);
      System.out.println("학력사항>>>>>>"+memberAcademic);
      System.out.println("자격증>>>>>>"+certificateList);
      System.out.println("산업별-->>"+industryService.getIndustryList());
      
      return "resume/addResume";
   }
   
   // 이력서 추가 액션
   @PostMapping("/addResume")
   public String addResume(Resume resume, @RequestParam("resumeWishArea2") String[] resumeWishArea2) {
      System.out.println(resumeWishArea2.length +"addResume.resumeWishArea2.count");
      System.out.println(resume.getResumeWishArea()+ "addResume.getResumeWishArea");
      for(int i=0; i<resumeWishArea2.length; i++) {
         System.out.println(resumeWishArea2[i]);
      }
      resume.setMemberId("user"); // 샘플 데이터
      resumeService.addResume(resume);
      return "redirect:/getResume";
   }
   
   
   
   // 이력서 삭제
   @GetMapping("/removeResume")
   public String removeResume(Resume resume) {
      /*
      if(session.getAttribute("loginMember") == null) {
         return "redirect:/";
      }
      */
      
      resume.getMemberId();
      resume.getResumeNo();
      System.out.println(resume.getMemberId());
      System.out.println(resume.getResumeNo());
      resumeService.removeResume(resume);
      return "redirect:/getResume";
   }
   
   // 이력서 목록
   @GetMapping("/getResume")
   public String selectResume(String memberId, Model model) {
      /*
      if(session.getAttribute("loginMember") == null) {
         return "redirect:/";
      }
      */
      memberId = "user";
      List<Resume> list = resumeService.getResume(memberId);
      int count = resumeService.getResumeCount(memberId);
      System.out.println(count+"<--count");
      model.addAttribute("list", list);
      model.addAttribute("memberId", memberId);
      model.addAttribute("count", count);
      return "resume/getResume";
   }
}