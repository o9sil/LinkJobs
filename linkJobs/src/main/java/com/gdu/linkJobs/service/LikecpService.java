package com.gdu.linkJobs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.LikecpMapper;
import com.gdu.linkJobs.vo.HireAnnouncementAndCpMemberAndScrapAndLikecp;
import com.gdu.linkJobs.vo.Likecp;


@Service
public class LikecpService {
	@Autowired private LikecpMapper likecpMapper;
	
	
	//일반회원 관심기업의 공고 리스트 출력
	public List<HireAnnouncementAndCpMemberAndScrapAndLikecp> likecpListAnnouncement(String memberId){
		return likecpMapper.selectMemberLikecpAnnouncement(memberId);
	}
	
	//일반회원 관심기업 출력
	public List<HireAnnouncementAndCpMemberAndScrapAndLikecp> likecpList(String memberId){
		return likecpMapper.selectMemberLikecp(memberId);
	}
	
	//관심기업 출력 
	 public List<Likecp> getLikecp() { 
		 return likecpMapper.selectLikecp();
	 }
	 
	
	//관심기업 추가 
	public int addLikecp(Likecp likecp) {
		return likecpMapper.insertLikecp(likecp);
	}
	
	//관심기업 수정
	public int modifyLikecp(Likecp likecp) {
		return likecpMapper.updateLikecp(likecp);
	}
	
	

}
