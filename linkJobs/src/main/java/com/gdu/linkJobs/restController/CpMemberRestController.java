package com.gdu.linkJobs.restController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gdu.linkJobs.service.CpMemberService;

@RestController
public class CpMemberRestController {
	@Autowired
	private CpMemberService cpMemberService;
	// 아이디 중복검사
	@PostMapping("/checkCpMemberId")
	public int checkCpMemberId(Model model, HttpSession session, @RequestParam(value="checkCpMemberId") String checkCpMemberId) {
		return cpMemberService.getCpMemberIdCnt(checkCpMemberId);
	}
	
}
