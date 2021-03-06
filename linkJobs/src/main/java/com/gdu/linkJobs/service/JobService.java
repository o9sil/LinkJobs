package com.gdu.linkJobs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.linkJobs.mapper.JobMapper;
import com.gdu.linkJobs.vo.Job;
import com.gdu.linkJobs.vo.Job2;
import com.gdu.linkJobs.vo.Job3;
import com.gdu.linkJobs.vo.JobAndJob2AndJob3;

@Service
@Transactional
public class JobService {

	@Autowired
	private JobMapper jobMapper;

	// job리스트 다 출력
	public Map<String, Object> getJobListAll() {

		Map<String, Object> map = new HashMap<String, Object>();

		List<Job> jobList = jobMapper.selectJobListAll();
		List<Job2> job2List = jobMapper.selectJob2ListAll();
		List<Job3> job3List = jobMapper.selectJob3ListAll();

		map.put("jobList", jobList);
		map.put("job2List", job2List);
		map.put("job3List", job3List);

		return map;
	}

	// selectRestJob
	public List<JobAndJob2AndJob3> getRestJob(int jobNo) {
		return jobMapper.selectRestJob(jobNo);
	}

	// selectRestJob2
	public List<JobAndJob2AndJob3> getRestJob2(int job2No) {
		System.out.println("selectRestJob2");
		return jobMapper.selectRestJob2(job2No);
	}
}
