package com.gdu.linkJobs.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.linkJobs.mapper.IndustryMapper;
import com.gdu.linkJobs.vo.Industry;

@Service
@Transactional
public class IndustryService {

	@Autowired private IndustryMapper industryMapper;
	
	public List<Industry> getIndustryList(){		
		return industryMapper.selectIndustryList();
	}
}
