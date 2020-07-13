package com.gdu.linkJobs.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.linkJobs.mapper.MemberAcademicMapper;
import com.gdu.linkJobs.service.AreaService;
import com.gdu.linkJobs.service.MemberCareerService;
import com.gdu.linkJobs.service.MemberCertificateService;
import com.gdu.linkJobs.service.MemberService;
import com.gdu.linkJobs.service.ResumeService;
import com.gdu.linkJobs.service.MemberAcademicService;
import com.gdu.linkJobs.vo.Resume;
import com.gdu.linkJobs.vo.Area;
import com.gdu.linkJobs.vo.Member;
import com.gdu.linkJobs.vo.MemberAcademic;
import com.gdu.linkJobs.vo.MemberCareer;
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
	   
      
	  Member memberInfo = memberService.getMemberOne(memberId);
      List<MemberCareerAndJobAndArea> memberCareer = memberCareerService.getMemberCareerList(memberId);
      List<Area> areaList = areaService.getArea();
      List<MemberAcademic> memberAcademic = memberAcademicService.getMemberAcademic(memberId);
      List<MemberCertificate> certificateList = memberCertificateService.getMemberCertificateList(memberId);
      System.out.println("경력사항-->"+memberCareer+"ㅇㅁ너ㅏㅣ러미야ㅑㄹ");
      System.out.println(certificateList+"<--자격증ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
      model.addAttribute("memberInfo", memberInfo);
      model.addAttribute("memberAcademic", memberAcademic);
      System.out.println(memberAcademic+"<--이력서 회원학력");
      model.addAttribute("certificateList", certificateList);
      System.out.println("자격증정보-->"+certificateList);
      //model.addAttribute("memberCareer", memberCareer);
      model.addAttribute("areaList", areaList);
      System.out.println("지역목록"+areaList);
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