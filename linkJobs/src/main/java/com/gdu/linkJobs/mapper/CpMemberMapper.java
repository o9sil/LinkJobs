package com.gdu.linkJobs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.AlterCpMemberPw;
import com.gdu.linkJobs.vo.CpMember;
import com.gdu.linkJobs.vo.LoginCpMember;

@Mapper
public interface CpMemberMapper {
	
	
	//기업회원 PW 수정
	public int updateCpMemberPw(AlterCpMemberPw alterCpMemberPw);
	
	//기업회원 ID 찾기
	public CpMember selectCpMemberId(CpMember cpMember);
	
	// 로그인
	public String selectLoginCpMember(LoginCpMember loginCpMember);
	// 회원가입
	public int insertCpMember(CpMember cpMember);
	// 회원가입 아이디 중복검사
	public int selectCpMemberIdCnt(String cpMemberId);
}
