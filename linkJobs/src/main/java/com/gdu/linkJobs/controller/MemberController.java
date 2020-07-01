package com.gdu.linkJobs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.linkJobs.service.AreaService;
import com.gdu.linkJobs.service.MemberService;
import com.gdu.linkJobs.vo.Area;
import com.gdu.linkJobs.vo.AreaAndArea2;
import com.gdu.linkJobs.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private AreaService areaService;
    
    //일반회원 회원가입 폼
    @GetMapping("/addMember")
    public String addMember(Model model) {
    	System.out.println("member insert sucess");
    	List<Area> areaList=areaService.getArea();
    	model.addAttribute("areaList", areaList);
    	return "member/addMember";
    }
    
    //일반회원 회원가입 액션
    @PostMapping("/addMember")
    public String addMember(Member member) {
    	memberService.addMember(member);
    	System.out.println(member);
    	return "redirect:/index";
    }
    // 중복 체크
    @PostMapping("/checkMemberId")
    public String checkMemberId(@RequestParam("memberIdCheck") String memberIdCheck, Model model ) {
       
       String memberId=memberService.memberIdCheck(memberIdCheck);
       System.out.println(memberId);
       if (memberId != null) { // 멤버아이디가 있으면 아이디를 사용 불가
          // 아이디를 사용 할 수 없습니다
          System.out.println("아이디를 사용할 수 없습니다");
          model.addAttribute("msg", "사용중인 아이디 입니다");
       } else { // 멤버아이디에 반환되는 값이 없으면 아이디 사용가능
          // 아이디를 사용할 수 있습니다
          System.out.println("아이디를 사용할 수 있습니다 ");
          model.addAttribute("confirmMemberId", memberIdCheck);
       }
       return "member/addMember";
    }
	
    
}
