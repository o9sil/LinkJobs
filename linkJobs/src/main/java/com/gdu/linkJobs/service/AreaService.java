package com.gdu.linkJobs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.linkJobs.mapper.AreaMapper;
import com.gdu.linkJobs.vo.Area;
import com.gdu.linkJobs.vo.AreaAndArea2;

@Service
@Transactional
public class AreaService {
	@Autowired
	private AreaMapper areaMapper;
	
	//sido
	public List<Area> getArea(){
		return areaMapper.selectArea();
	}
	
	//gungu
	public List<AreaAndArea2> getArea2(int areaNo){
		return areaMapper.selectArea2(areaNo);
	}
	
	
}
