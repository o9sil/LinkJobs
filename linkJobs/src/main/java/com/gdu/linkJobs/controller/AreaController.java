package com.gdu.linkJobs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AreaController {
	@GetMapping("/areaTest")
	public String areaTest() {
		
		return "areaTest";
	}
}
