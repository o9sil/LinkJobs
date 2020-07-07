package com.gdu.linkJobs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.ScrapMapper;
import com.gdu.linkJobs.vo.Scrap;

@Service
public class ScrapService {
	@Autowired private ScrapMapper scrapMapper;
	
	
	
	//스크랩 추가 
	public int insertScrap(Scrap scrap) {
	
		return scrapMapper.insertScrap(scrap);
	}
	
	//스크랩 추가,취소
	public int modifyScrap(Scrap scrap) {
		return scrapMapper.updateScrap(scrap);
	}
	
	

}