package com.gdu.linkJobs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.MemberCertificate;

@Mapper
public interface MemberCertificateMapper {
	
	//자격증 등록
	public int insertMemberCertificate(MemberCertificate memberCertificate);
	
	//자격증 수정
	public int updateMemberCertificate(MemberCertificate memberCertificate);
	
	//자격증 하나만 가져오기
	public MemberCertificate selectMemberCertificateOne(int certificateNo);
	
	//자격증 삭제
	public int deleteMemberCertificate(int certificateNo);
	
	//자격증 회원별 리스트 출력
	public List<MemberCertificate> selectMemberCertificateList(String memberId);
	
}
