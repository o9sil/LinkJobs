package com.gdu.linkJobs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.Job;
import com.gdu.linkJobs.vo.Job2;
import com.gdu.linkJobs.vo.Job3;

@Mapper
public interface JobMapper {
	
	public List<Job> selectJobListAll();
	public List<Job2> selectJob2ListAll();
	public List<Job3> selectJob3ListAll();
}
