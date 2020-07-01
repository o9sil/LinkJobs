package com.gdu.linkJobs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;
import com.gdu.linkJobs.common.KakaoLogin;
import com.gdu.linkJobs.service.CpMemberService;
import com.gdu.linkJobs.vo.AlterCpMemberPw;
import com.gdu.linkJobs.vo.CpMember;
import com.gdu.linkJobs.vo.LoginCpMember;

@Controller
public class CpMemberController {
	KakaoLogin login = null;
	
	@Autowired
	private CpMemberService cpMemberService;	
	
	//기업회원 정보 수정 폼
	@GetMapping("/alterCpMemberDetail")
	public String alterCpMemberDetail(HttpSession session, Model model) {
		if(session.getAttribute("loginCpMember") == null) {
			return "redirect:/";
		}
		
		String loginCpMemberID = (String) session.getAttribute("loginCpMember");
		model.addAttribute("cpMember", cpMemberService.getCpMemberDetail(loginCpMemberID));
		
		return "cpMember/alterCpMemberDetail";
	}
	
	//비밀번호 수정 액션
	@PostMapping("/alterCpMemberPw")
	public String alterCpMemberPwAction(HttpSession session, AlterCpMemberPw alterCpMemberPw) {

		if(session.getAttribute("loginCpMember") == null) {
			return "redirect:/";
		}
		
		//System.out.println("session = " + session.getAttribute("loginCpMember"));
		//System.out.println("AlterCpMemberPw = " + alterCpMemberPw);
		
		//비밀번호 수정 성공
		if(cpMemberService.modifyCpMemberPw(alterCpMemberPw) == 1) {
			//System.out.println("비밀번호 수정 성공");
			return "redirect:/";
		}else {
			//System.out.println("비밀번호 수정 실패");
			return "redirect:/alterCpMemberPw";
		}
	}
	
	//비밀번호 수정 폼
	@GetMapping("/alterCpMemberPw")
	public String alterCpMemberPw(HttpSession session) {

		if(session.getAttribute("loginCpMember") == null) {
			return "redirect:/";
		}
		
		return "cpMember/alterCpMemberPw";
	}
	
	
	//ID 찾기 액션
	@PostMapping("/findCpMemberId")
	public String findCpMemberId(CpMember cpMember) {
		
		System.out.println(cpMemberService.getCpMemberId(cpMember));
		
		
		return "redirect:/loginCpMember";
	}
	
	//PW 찾기 액션
	@PostMapping("/findCpMemberPw")
	public String findCpMemberPw(CpMember cpMember) {
		
		System.out.println("findCpMemberPw Post");
		System.out.println(cpMember);
		
		if(cpMemberService.findCpMemberPw(cpMember) == 1) {
			return "redirect:/loginCpMember";
		} else {
			return "redirect:/findCpMember";
		}
	}
	
	
	// ID, PW 찾기 폼
	@GetMapping("/findCpMember")
	public String findCpMember(HttpSession session) {
		// 로그인 중
		if(session.getAttribute("loginCpMember") != null) {
			return "redirect:/";
		}
		
		return "cpMember/findCpMember";
	}
	
	// 회원가입 폼
	@GetMapping("/signUpCpMember")
	public String signUpCpMember(HttpSession session) {
		// 로그인 중
		if(session.getAttribute("loginCpMember") != null) {
			return "redirect:/";
		}
		return "cpMember/signUpCpMember";
		
	}
   
	// 회원가입 액션
	@PostMapping("/signUpCpMember")
	public String signUp(HttpSession session, CpMember cpMember) {
		// 로그인 중
		if(session.getAttribute("loginCpMember") != null) {
			return "redirect:/";
		}
		
		//System.out.println("회원가입 성공 여부 = ");
		cpMemberService.addMember(cpMember);
		
		return "redirect:/loginCpMember";
	}
	
	// 기업회원 로그아웃
	@GetMapping("/logoutCpMember")
	public String logoutCpMember(HttpSession session) {
		session.removeAttribute("loginCpMember");
		
		return "redirect:/";
	}
	   
	
	// 로그인 폼
	@GetMapping("/loginCpMember")
	public String login(Model model, HttpSession session) {
		// 로그인 중
		if(session.getAttribute("loginCpMember") != null) {
			return "redirect:/";
		}
		// 로그인이 아닐시
		
		model.addAttribute("cp", true);
		
		return "login/login";
	}
	
	// 기업회원 로그인 액션
	@PostMapping("/loginCpMember")
	public String login(Model model, HttpSession session, LoginCpMember loginCpmember) {
		// 로그인 중
		if(session.getAttribute("loginCpMember") != null) {
			return "redirect:/";
		}
		System.out.println(loginCpmember);
		String loginId = cpMemberService.login(loginCpmember);
		System.out.println(loginId +"<--returnLoginCpMember ID");
		
		//회원가입 실패(회원이 아님)
		if(loginId == null) {
			return "redirect:/loginCpMember";
		}else {
			session.setAttribute("loginCpMember", loginId);
			return "redirect:/";
		}
	}
	
	
	// 카카오 로그인 및 유저 정보	
    @RequestMapping(value="/cpKakaoLogin")
    public String login(@RequestParam("code") String code, HttpSession session) {
    	    	
    	login = new KakaoLogin();
    	JsonNode jsonToken = login.getKakaoAccessToken(code, true);
    	JsonNode accessToken = jsonToken.get("access_token");
    	JsonNode userInfo = KakaoLogin.getKakaoUserInfo(accessToken);
    	
    	String id = userInfo.path("id").asText();
        String name = null;
        String email = null;
 
        // 유저정보 카카오에서 가져오기 Get properties
        JsonNode properties = userInfo.path("properties");
        JsonNode kakao_account = userInfo.path("kakao_account");
 
        name = properties.path("nickname").asText();
        email = kakao_account.path("email").asText();
 
        System.out.println("id : " + id);
        System.out.println("name : " + name);
        System.out.println("email : " + email);
        session.setAttribute("token",accessToken);
        session.setMaxInactiveInterval(450);
        return "redirect:/index.html";
    }
}

