package com.gdu.linkJobs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.HireAnnouncementAndCpMemberAndScrapAndLikecp;
import com.gdu.linkJobs.vo.Likecp;

@Mapper
public interface LikecpMapper {
		

	
		//일반회원 관심기업의 공고 리스트
		public List<HireAnnouncementAndCpMemberAndScrapAndLikecp> selectMemberLikecpAnnouncement(HireAnnouncementAndCpMemberAndScrapAndLikecp ha);
	
		//일반회원 관심기업 리스트 
		public List<HireAnnouncementAndCpMemberAndScrapAndLikecp> selectMemberLikecp(String memberId);
	
		//관심기업 정보 출력(예시)
		public List<Likecp> selectLikecp();
		
		//관심기업 추가
		public int insertLikecp(Likecp likecp);
		
		//관심기업 수정
		public int updateLikecp(Likecp likecp);
	
}
