package com.gdu.linkJobs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.linkJobs.mapper.MemberCertificateMapper;
import com.gdu.linkJobs.vo.MemberCertificate;

@Service
@Transactional
public class MemberCertificateService {
	@Autowired
	private MemberCertificateMapper memberCertificateMapper;
	
	//자격증 등록
	public int addMemberCertificate(MemberCertificate memberCertificate) {
		return memberCertificateMapper.insertMemberCertificate(memberCertificate);
	}
	
	//자격증 수정
	public int modifyMemberCertificate(MemberCertificate memberCertificate) {
		return memberCertificateMapper.updateMemberCertificate(memberCertificate);
	}
	
	//자격증 하나만 가져오기
	public MemberCertificate getMemberCertificateOne(int certificateNo) {
		return memberCertificateMapper.selectMemberCertificateOne(certificateNo);
	}
	
	
	//자격증 삭제
	public int removeMemberCertificate(int certificateNo) {
		return memberCertificateMapper.deleteMemberCertificate(certificateNo);
	}
	
	//자격증 리스트 출력
	public List<MemberCertificate> getMemberCertificateList(String memberId){
		return memberCertificateMapper.selectMemberCertificateList(memberId);
	}
}
