package com.gdu.linkJobs.service;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.CpMemberMapper;
import com.gdu.linkJobs.vo.CpMember;
import com.gdu.linkJobs.vo.CpMemberForm;
import com.gdu.linkJobs.vo.LoginCpMember;

@Service
public class CpMemberService extends HttpServlet {
	@Autowired
	private static CpMemberMapper cpMemberMapper;
	
	
	public int getCpMemberIdCnt(String cpMemberId) {		
		return cpMemberMapper.selectCpMemberIdCnt(cpMemberId);
	}
	
	public LoginCpMember login(LoginCpMember loginCpMember) {
		
		return cpMemberMapper.selectLoginCpMember(loginCpMember);
	}
	
	public int addMember(CpMemberForm cpMemberForm) {
		CpMember cpMember = new CpMember();
		cpMember.setCpmemberId(cpMemberForm.getCpmemberId());
		cpMember.setCpmemberPw(cpMemberForm.getCpmemberPw());
		cpMember.setCpmemberLicenseNo(cpMemberForm.getCpmemberLicenseNo());
		cpMember.setCpmemberManager(cpMemberForm.getCpmemberManager());
		cpMember.setCpmemberCompany(cpMemberForm.getCpmemberCompany());
		cpMember.setCpmemberCeo(cpMemberForm.getCpmemberCeo());
		cpMember.setCpmemberPhonenum(cpMemberForm.getCpmemberPhonenum());
		cpMember.setCpmemberDate(cpMemberForm.getCpmemberDate());
		System.out.println(cpMember+"<--cpMemberService.addCpMember");
		int row = cpMemberMapper.insertCpMember(cpMember);
		return row;
	}
	
	
}
