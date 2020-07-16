package com.gdu.linkJobs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.ScrapMapper;
import com.gdu.linkJobs.vo.HireAnnouncement;
import com.gdu.linkJobs.vo.Scrap;

@Service
public class ScrapService {
	@Autowired
	private ScrapMapper scrapMapper;

	// scrap 출
	public List<Scrap> selectBoolean() {
		return scrapMapper.selectScrap();
	}

	// 스크랩 추가
	public int addScrap(Scrap scrap) {
		return scrapMapper.insertScrap(scrap);
	}

	// 스크랩 추가,취소
	public int modifyScrap(Scrap scrap) {
		return scrapMapper.updateScrap(scrap);
	}

	// 멤버별 스크랩기업
	public List<HireAnnouncement> getMemberScrapList(String memberId) {
		return scrapMapper.selectMemberScrap(memberId);
	}

}
