package com.gdu.linkJobs.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.MemberPic;

@Mapper
public interface MemberPicMapper {
	
	//회원가입 시 사진 default값 지정
	public void insertMemberPic(String memberId);
	
	//사진 수정 
	public void updateMemberPic(MemberPic memberPic);
	
	
	//사진 수정용 select
	public MemberPic selectMeberPic(String memberId);
	
	//회원 탈퇴 
	public void deleteMemberPic(String memberId);
	
	
}
