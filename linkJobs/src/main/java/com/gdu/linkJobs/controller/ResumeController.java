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
import com.gdu.linkJobs.service.SelfIntroductionService;
import com.gdu.linkJobs.service.MemberAcademicService;
import com.gdu.linkJobs.vo.Resume;
import com.gdu.linkJobs.vo.AddResume;
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
   @Autowired private SelfIntroductionService selfIntroductionService;
   
   
   
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
   @GetMapping("/getDetailResume")
   public String getDetailResume(Resume resume, Model model) {
      List<Resume> resumelist = resumeService.getDetailResume(resume);
      model.addAttribute("resumelist", resumelist);
      
      return "resume/getDetailResume";
   }
   
   
   // 이력서 추가 폼
   @GetMapping("/addResume")
   public String addResume(HttpSession session, Model model, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {
	   if(session.getAttribute("loginMember") == null) {
	         return "redirect:/";
	   }

	  String memberId = (String) session.getAttribute("loginMember");
	   
	  int rowPerPage = 5;//
	  int beginRow = (currentPage-1)*rowPerPage;//
	  
	  
	  @SuppressWarnings("unchecked")
	  Member memberInfo = memberService.getMemberOne(memberId);													//회원정보
      List<MemberCareerAndJobAndArea> memberCareer = memberCareerService.getMemberCareerList(memberId);			//경력사항
      List<Area> areaList = areaService.getArea();																//지역선택	
      List<MemberAcademic> memberAcademic = memberAcademicService.getMemberAcademic(memberId);					//학력사항
      List<MemberCertificate> certificateList = memberCertificateService.getMemberCertificateList(memberId);	// 자격증정보
      Map<String, Object> jobMap = jobService.getJobListAll();
      Map<String, Object> map = selfIntroductionService.getSelfIntroductionList(memberId, beginRow, rowPerPage);//
      model.addAttribute("selfIntroList", map.get("list"));//
      model.addAttribute("currentPage", currentPage);//
      
      
      model.addAttribute("job", jobMap.get("jobList"));
      model.addAttribute("job2", jobMap.get("job2List"));
      model.addAttribute("job3", jobMap.get("job3List"));
		
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
   @PostMapping("/addResumePost")
   public String addResumePost(HttpSession session,Resume resume) { 
	   System.out.println("이력서추가액션!!!!!"+resume);
	   if (session.getAttribute("loginMember") == null) {
			return "redirect:/getAnnouncementList";
		}
	   
	  String memberId = (String) session.getAttribute("loginMember");

	  resume.setMemberId(memberId);

	  System.out.println("memberId--->"+memberId);
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
   public String selectResume(HttpSession session, Model model) {
      
      if(session.getAttribute("loginMember") == null) {
         return "redirect:/";
      }
      
      String memberId = (String) session.getAttribute("loginMember");
      List<Resume> list = resumeService.getResume(memberId);
      int count = resumeService.getResumeCount(memberId);
      System.out.println(count+"<--count");
      model.addAttribute("list", list);
      model.addAttribute("memberId", memberId);
      model.addAttribute("count", count);
      return "resume/getResume";
   }
}