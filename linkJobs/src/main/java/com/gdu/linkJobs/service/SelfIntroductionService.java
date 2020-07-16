package com.gdu.linkJobs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.linkJobs.mapper.SelfIntroductionMapper;
import com.gdu.linkJobs.vo.SelfIntroduction;

@Service
public class SelfIntroductionService {
	@Autowired
	private SelfIntroductionMapper selfIntroductionMapper;
	
	//자소서 리스트 출력
	public Map<String, Object> getSelfIntroductionList(String memberId,int beginRow, int rowPerPage){
		Map<String, Object> map = new HashMap<>();

		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);

		int totalRow = selfIntroductionMapper.totalSelfIntroduction(memberId);
		System.out.println(totalRow+"<--totalRow");		
		
		
		int lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage+=1;
		}
		System.out.println(lastPage+"<--lastPage");
		List<SelfIntroduction> list = selfIntroductionMapper.selectSelfIntroductionList(memberId, beginRow, rowPerPage);
		map.put("list", list);
		map.put("lastPage", lastPage);

		return map;
	}
	//자소서 하나 출력
	public SelfIntroduction getSelfIntroductionOne(int selfIntroductionNo) {
		return selfIntroductionMapper.selectSelfIntroductionOne(selfIntroductionNo);
	}
	
	//자소서 수정
	public int modifySelfIntroductio(SelfIntroduction selfIntroduction) {
		return selfIntroductionMapper.updateSelfIntroduction(selfIntroduction);
	}
	
	//자소서 삭제
	public int removeSelfIntroduction(int selfIntroductionNo) {
		return selfIntroductionMapper.deleteSelfIntroduction(selfIntroductionNo);
	}
	
	//자소서 추가
	public int addSelfIntroduction(SelfIntroduction selfIntroduction) {
		return selfIntroductionMapper.insertSelfIntroduction(selfIntroduction);
	}
	
}
