package com.gdu.linkJobs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.linkJobs.mapper.AreaAndArea2Mapper;
import com.gdu.linkJobs.vo.AreaAndArea2;

@Service
@Transactional
public class AreaAndArea2Service {
	@Autowired
	private AreaAndArea2Mapper areaAndArea2Mapper;
	
	//areaAndArea2 List
	public List<AreaAndArea2> getAreaAndArea2(){
		return areaAndArea2Mapper.selectAreaAndArea2();
	}
}
