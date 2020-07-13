package com.gdu.linkJobs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.MemberCareerMapper;
import com.gdu.linkJobs.mapper.MemberResumeCareerMapper;
import com.gdu.linkJobs.vo.MemberCareer;
import com.gdu.linkJobs.vo.MemberCareerAndJobAndArea;
import com.gdu.linkJobs.vo.MemberResumeCareer;

@Service
public class MemberCareerService {
	@Autowired  private MemberCareerMapper memberCareerMapper;
	@Autowired private MemberResumeCareerMapper memberResumeCareerMapper;
	
	//경력사항 리스트 출력
	public List<MemberCareerAndJobAndArea> getMemberCareerList(String memberId) {
		return memberCareerMapper.selectMemberCareerList(memberId);
	}
	 
	
	// 경력사항 학력 리스트 상세보기
	public MemberCareerAndJobAndArea getMemberCareerOne(int careerNo) {
		return memberCareerMapper.selectMemberCareerOne(careerNo);
	}
	
	//경력사항 추가
	public int addMemberCareer(MemberCareer memberCareer) {
		return memberCareerMapper.insertMemberCareer(memberCareer);
	}
	
	//경력사항 수정
	public int modifyMemberCareer(MemberCareer memberCareer) {
		return memberCareerMapper.updateMemberCareer(memberCareer);
	}
	
	//경력사항 삭제 (트렌젝션)
	public int removeMemberCareer(int careerNo) {
		return memberCareerMapper.deleteMemberCareer(careerNo);
	}
}
