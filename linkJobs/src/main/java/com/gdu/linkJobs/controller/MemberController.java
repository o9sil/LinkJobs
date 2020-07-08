package com.gdu.linkJobs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.linkJobs.service.AreaService;
import com.gdu.linkJobs.service.MemberService;
import com.gdu.linkJobs.vo.Area;
import com.gdu.linkJobs.vo.LoginMember;
import com.gdu.linkJobs.vo.Member;
import com.gdu.linkJobs.vo.MemberPic;
import com.gdu.linkJobs.vo.MemberPicForm;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private AreaService areaService;

	//사진 수정 폼
	@GetMapping("/modifyMemberPic")
	public String modifyMemberPic(HttpSession session) {
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		return "member/modifyMemberPic";

	}
	//사진 수정 액션
	@PostMapping("/modifyMemberPic")
	public String modifyMemberPic(HttpSession session,MemberPicForm memberPicForm) {
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		String memberId = (String) session.getAttribute("loginMember");
		memberPicForm.setMemberId(memberId);
		if(memberPicForm.getMemberPic() != null) {
			if(!memberPicForm.getMemberPic().getContentType().equals("image/jpeg") 
					&& !memberPicForm.getMemberPic().getContentType().equals("image/png")) {
				return "redirect:/modifyMemberPic";
			}
		}
		
		memberService.modifyMemberPic(memberPicForm);
		
		return "redirect:/getMemberDetail";
	}
	
	// 회원 탈퇴
	@GetMapping("/removeMember")
	public String removeMember(HttpSession session) {
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		return "member/removeMember";

	}

	// 회원 탈퇴 액션
	@PostMapping("removeMember")
	public String removeMember(HttpSession session, Member member) {
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		String memberId = (String) session.getAttribute("loginMember");
		member.setMemberId(memberId);
		memberService.removeMember(member);
		session.invalidate();
		return "redirect:/";
	}

	// 회원 비밀번호 수정 폼
	@GetMapping("/modifyMemberPw")
	public String modifyMemberPw(HttpSession session) {
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		return "member/modifyMemberPw";
	}

	// 회원 비밀번호 수정 액션
	@PostMapping("/modifyMemberPw")
	public String modifyMemberPw(HttpSession session, Member member) {
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}
		String memberId = (String) session.getAttribute("loginMember");
		member.setMemberId(memberId);
		memberService.modifyMemberPw(member);
		return "redirect:/modifyMemberPw";
	}

	// 회원정보 수정 폼
	@GetMapping("/modifyMember")
	public String modifyMember(Model model, HttpSession session) {
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}

		String memberId = (String) session.getAttribute("loginMember");
		Member member = memberService.getMemberOne(memberId);
		model.addAttribute("m", member);
		System.out.println(member + "<---member");

		List<Area> areaList = areaService.getArea();
		model.addAttribute("areaList", areaList);

		return "member/modifyMember";
	}

	// 회원정보 출력
	@GetMapping("/getMemberDetail")
	public String getMemberDetail(Model model, HttpSession session) {
		if (session.getAttribute("loginMember") == null) {
			return "redirect:/";
		}

		String memberId = (String) session.getAttribute("loginMember");
		Member member = memberService.getMemberOne(memberId);
		model.addAttribute("m", member);
		MemberPic mp=memberService.getMemberPic(memberId);
		model.addAttribute("mp", mp);
		
		System.out.println(member + "<---member");

		return "member/getMemberDetail";
	}

	// 회원정보 수정 액션
	@PostMapping("/modifyMember")
	public String modifyMember(Member member) {
		memberService.modifyMember(member);
		return "redirect:/getMemberDetail";
	}

	// 일반회원 회원가입 폼
	@GetMapping("/addMember")
	public String addMember(Model model, HttpSession session) {
		if (session.getAttribute("loginMember") != null) {
			return "redirect:/";
		}
		System.out.println("member insert sucess");
		List<Area> areaList = areaService.getArea();
		model.addAttribute("areaList", areaList);
		return "member/addMember";
	}

	// 일반회원 회원가입 액션
	@PostMapping("/addMember")
	public String addMember(Member member) {
		System.out.println(member);
		memberService.addMember(member);
		System.out.println(member);
		return "redirect:/";
	}

	// 중복 체크
	@PostMapping("/checkMemberId")
	public String checkMemberId(@RequestParam("memberIdCheck") String memberIdCheck, Model model, Member member,
			HttpSession session) {
		if (session.getAttribute("loginMember") != null) {
			return "redirect:/";
		}

		System.out.println(member);
		String memberId = memberService.memberIdCheck(memberIdCheck);
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

		List<Area> areaList = areaService.getArea();
		model.addAttribute("areaList", areaList);
		return "member/addMember";
	}

	// login form
	@GetMapping("/loginMember")
	public String loginMember(HttpSession session) {
		if (session.getAttribute("loginMember") != null) {
			return "redirect:/";
		}

		return "login/login";
	}

	// login action
	@PostMapping("/loginMember")
	public String loginMember(Model model, HttpSession session, LoginMember loginMember) {
		// 로그인 중
		if (session.getAttribute("loginMember") != null) {
			return "redirect:/";
		}

		String loginMemberId = memberService.loginMember(loginMember);

		// 회원가입 실패(회원이 아님)
		if (loginMemberId == null) {
			System.out.println(loginMember + "<--loginId");
			return "redirect:/loginMember";
		} else {
			System.out.println(loginMemberId + "<--loginId");
			session.setAttribute("loginMember", loginMemberId);
			return "redirect:/";
		}

	}

	// logout
	@GetMapping("/logoutMember")
	public String logoutMember(HttpSession session) {
		session.invalidate();

		return "redirect:/";
	}
}