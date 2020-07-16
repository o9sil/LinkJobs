package com.gdu.linkJobs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.HireAnnouncement;
import com.gdu.linkJobs.vo.Scrap;

@Mapper
public interface ScrapMapper {
	
	//scrap 정보 출력(예시)
	public List<Scrap> selectScrap();
	
	//스크랩 추가
	public int insertScrap(Scrap scrap);
	
	//스크랩 추가, 취소
	public int updateScrap(Scrap scrap);
	
	//멤버별 스크랩기업
	public List<HireAnnouncement> selectMemberScrap(String memberId);
}
