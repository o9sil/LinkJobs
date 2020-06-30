package com.gdu.linkJobs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.AreaAndArea2;

@Mapper
public interface AreaAndArea2Mapper {
	//지역코드 리스트 출력용
	public List<AreaAndArea2> selectAreaAndArea2();
}
