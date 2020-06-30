package com.gdu.linkJobs.service;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdu.linkJobs.mapper.CpMemberMapper;
import com.gdu.linkJobs.vo.LoginCpMember;

@WebServlet("/CpMemberService")
public class CpMemberService extends HttpServlet {
	@Autowired
	private CpMemberMapper cpMemberMapper;
	
	public static LoginCpMember login(LoginCpMember loginCpmember) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
