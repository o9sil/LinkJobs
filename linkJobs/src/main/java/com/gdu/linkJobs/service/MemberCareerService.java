package com.gdu.linkJobs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.MemberCareerMapper;
import com.gdu.linkJobs.vo.MemberCareer;
import com.gdu.linkJobs.vo.MemberCareerAndJobAndArea;

@Service
public class MemberCareerService {
	@Autowired  private MemberCareerMapper memberCareerMapper;
	
	//이력서 리스트 출력
	public List<MemberCareerAndJobAndArea> getMemberCareerList(String memberId) {
		return memberCareerMapper.selectMemberCareerList(memberId);
	}
	 
	
	// 이력서 학력 리스트 상세보기
	public MemberCareerAndJobAndArea getMemberCareerOne(int careerNo) {
		return memberCareerMapper.selectMemberCareerOne(careerNo);
	}
	
	//이력서 추가
	public int addMemberCareer(MemberCareer memberCareer) {
		return memberCareerMapper.insertMemberCareer(memberCareer);
	}
	
	//이력서 수정
	public int modifyMemberCareer(MemberCareer memberCareer) {
		return memberCareerMapper.updateMemberCareer(memberCareer);
	}
	
	//이력서 삭제
	public int removeMemberCareer(int careerNo) {
		return memberCareerMapper.deleteMemberCareer(careerNo);
	}
}
