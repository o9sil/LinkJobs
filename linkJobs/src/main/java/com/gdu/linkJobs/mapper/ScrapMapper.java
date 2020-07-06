package com.gdu.linkJobs.mapper;

import org.apache.ibatis.annotations.Mapper;


import com.gdu.linkJobs.vo.Scrap;

@Mapper
public interface ScrapMapper {
	
	
	//스크랩 추가
	public int insertScrap(Scrap scrap);
	
	//스크랩 추가, 취소
	public int updateScrap(Scrap scrap);
}
