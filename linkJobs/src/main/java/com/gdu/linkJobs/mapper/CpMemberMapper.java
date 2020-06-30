package com.gdu.linkJobs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.CpMember;
import com.gdu.linkJobs.vo.LoginCpMember;
@Mapper
public interface CpMemberMapper {
	// 로그인
	public LoginCpMember selectLoginCpMember(LoginCpMember loginCpMember);
	// 회원가입
	public int insertCpMember(CpMember cpMember);
	// 회원가입 아이디 중복검사
	public int selectCpMemberIdCnt(String cpMemberId);
}
