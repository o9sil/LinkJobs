package com.gdu.linkJobs.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gdu.linkJobs.service.JobService;
import com.gdu.linkJobs.vo.JobAndJob2;

@RestController
public class JobRestController {
	
	@Autowired
	private JobService jobService;
	
	//selectRestJob 1,2
	@PostMapping("/getRestJob")
	public List<JobAndJob2> getRestJob(@RequestParam("jobNo") int jobNo){
		//System.out.println(jobNo+"<--jobNo");
		return jobService.getRestJob(jobNo);
	}

}
