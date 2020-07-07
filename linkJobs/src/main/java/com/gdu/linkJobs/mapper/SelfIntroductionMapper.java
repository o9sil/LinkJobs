package com.gdu.linkJobs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.SelfIntroduction;

@Mapper
public interface SelfIntroductionMapper {
	// 자소서 리스트 출력
	public List<SelfIntroduction> selectSelfIntroductionList(String memberId);

	// 자소서 하나만 가지고 와 보여주기
	public SelfIntroduction selectSelfIntroductionOne(int selfIntroductionNo);

	// 자소서 수정
	public int updateSelfIntroduction(SelfIntroduction selfIntroduction);

	// 자소서 삭제
	public int deleteSelfIntroduction(int selfIntroductionNo);

	// 회원탈퇴용 자소서 삭제
	public int removeSelfIntroduction(String memberId);

	// 자소서 추가
	public int insertSelfIntroduction(SelfIntroduction selfIntroduction);
}
