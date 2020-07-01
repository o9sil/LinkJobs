package com.gdu.linkJobs.restController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gdu.linkJobs.service.AreaService;
import com.gdu.linkJobs.vo.AreaAndArea2;

@RestController
public class AreaRestController {
	
	@Autowired
	private AreaService areaService;
	
	// 군구
	@PostMapping("/selectArea2")
	public List<AreaAndArea2> selectArea2(Model model, HttpSession session, @RequestParam("areaNo") int areaNo) {
		System.out.println(areaNo+"<--areaNo");
		List<AreaAndArea2> area2List=areaService.getArea2(areaNo);
		System.out.println(area2List);
		model.addAttribute("area2List", area2List);
		return area2List;
	}
}  