package com.gdu.linkJobs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.Likecp;

@Mapper
public interface LikecpMapper {
		
		//관심기업 정보 출력(예시)
		public List<Likecp> selectLikecp();
		
		//관심기업 추가
		public int insertLikecp(Likecp likecp);
		
		//관심기업 수정
		public int updateLikecp(Likecp likecp);
	
}
