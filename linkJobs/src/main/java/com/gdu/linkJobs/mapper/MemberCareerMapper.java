package com.gdu.linkJobs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.MemberCareer;
import com.gdu.linkJobs.vo.MemberCareerAndJobAndArea;

@Mapper
public interface MemberCareerMapper {
	// 이력서 학력리스트 출력
	public List<MemberCareerAndJobAndArea> selectMemberCareerList(String memberId);
	
	// 이력서 상세보기
	public MemberCareerAndJobAndArea selectMemberCareerOne(int careerNo);
	
	// 이력서 추가
	public int insertMemberCareer(MemberCareer memberCareer);
}
 