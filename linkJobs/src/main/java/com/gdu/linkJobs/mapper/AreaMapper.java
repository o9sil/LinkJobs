package com.gdu.linkJobs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.Area;
import com.gdu.linkJobs.vo.AreaAndArea2;

@Mapper
public interface AreaMapper {

	//시도
	public List<Area> selectArea();
	//군구
	public List<AreaAndArea2> selectArea2(int areaNo);
}
