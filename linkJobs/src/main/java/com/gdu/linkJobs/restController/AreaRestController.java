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
   public List<AreaAndArea2> selectArea2( HttpSession session, @RequestParam("areaSido") String areaSido) {
      System.out.println(areaSido+"<--areaSido");
      return areaService.getArea2(areaSido);
   }
}  