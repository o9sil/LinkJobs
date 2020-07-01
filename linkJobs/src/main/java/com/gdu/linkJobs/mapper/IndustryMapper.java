package com.gdu.linkJobs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.Industry;

@Mapper
public interface IndustryMapper {

	public List<Industry> selectIndustryList();
}
