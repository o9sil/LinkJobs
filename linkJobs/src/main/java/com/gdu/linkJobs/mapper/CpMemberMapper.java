package com.gdu.linkJobs.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.AlterCpMemberPw;
import com.gdu.linkJobs.vo.CpMember;
import com.gdu.linkJobs.vo.LoginCpMember;

@Mapper
public interface CpMemberMapper {
	
	//기업회원 회원가입시 사진추가
	public int insertCpMemberPic(String cpMemberId);
	
	//기업회원 사진 수정
	public int updateCpMemberPic(Map<String, Object> map);
	
	//기업회원 사진 가져오기
	public String selectCpMemberPic(String cpMemberId);
		
	//기업회원 상세정보 가져오기
	public CpMember selectCpMemberDetail(String cpMemberId);
	
	//기업회원 정보수정
	public int updateCpMemberDetail(Map<String, Object> map);
	
	//기업회원 PW 찾기
	public int updateCpMemberPwRandom(CpMember cpMember);
	
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
