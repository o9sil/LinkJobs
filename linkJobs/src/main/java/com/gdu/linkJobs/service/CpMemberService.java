package com.gdu.linkJobs.service;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.CpMemberMapper;
import com.gdu.linkJobs.vo.CpMember;
import com.gdu.linkJobs.vo.LoginCpMember;

@Service
public class CpMemberService extends HttpServlet {	
	
	@Autowired
	private CpMemberMapper cpMemberMapper;	
	
	@Autowired private JavaMailSender javaMailSender;
	
	//기업회원 ID 찾기
	public int getCpMemberId(CpMember cpMember) {
		
		CpMember returnCpMember = cpMemberMapper.selectCpMemberId(cpMember); 
		System.out.println("cpMemberService getCpMemberId = " + returnCpMember);
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(returnCpMember.getCpMemberEmail());
		simpleMailMessage.setFrom("LinkJobs");
		simpleMailMessage.setSubject("LinkJobs ID 찾기");	
		simpleMailMessage.setText("기업회원 ID " + returnCpMember.getCpMemberId() + " 입니다.");
		
		javaMailSender.send(simpleMailMessage);
		
		return 0; 
	}
	
	
	//회원가입 전 기존 아이디 존재하는지 확인
	public int getCpMemberIdCnt(String cpMemberId) {
		return cpMemberMapper.selectCpMemberIdCnt(cpMemberId);
	}
	
	//로그인
	public String login(LoginCpMember loginCpMember) {		
		return cpMemberMapper.selectLoginCpMember(loginCpMember);
	}
	
	//회원가입
	public int addMember(CpMember cpMember) {		
		int row = cpMemberMapper.insertCpMember(cpMember);
		return row;
	}	
	
}
