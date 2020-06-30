package com.gdu.linkJobs.mapper;

import com.gdu.linkJobs.vo.LoginCpMember;

public interface CpMemberMapper {
	// 로그인
	public LoginCpMember selectLoginCpMember(LoginCpMember loginCpMember);
}
