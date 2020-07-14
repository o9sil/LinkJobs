package com.gdu.linkJobs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.Job;
import com.gdu.linkJobs.vo.Job2;
import com.gdu.linkJobs.vo.Job3;
import com.gdu.linkJobs.vo.JobAndJob2AndJob3;

@Mapper
public interface JobMapper {

	// Job 리스트 가져오기
	public List<Job> selectJobListAll();

	// Job2 리스트 가져오기
	public List<Job2> selectJob2ListAll();

	// Job3 리스트 가져오기
	public List<Job3> selectJob3ListAll();

	// 레스트 컨트롤러 용 job,job2리스트
	public List<JobAndJob2AndJob3> selectRestJob(int jobNo);

	// 레스트 컨트롤러 용 job3,job2리스트
	public List<JobAndJob2AndJob3> selectRestJob2(int job2No);

}
