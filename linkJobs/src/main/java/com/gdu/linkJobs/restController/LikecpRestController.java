package com.gdu.linkJobs.restController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gdu.linkJobs.service.LikecpService;
import com.gdu.linkJobs.vo.Likecp;

@RestController
public class LikecpRestController {
	@Autowired private LikecpService likecpService;
	
	
	@PostMapping("/insertLikecp")
	public int insertLikecp(HttpSession session, @RequestParam("likecpNo") int likecpNo ,@RequestParam("cpmemberId") String cpmemberId, @RequestParam("likecpBoolean") String likecpBoolean) {
		
		String memberId = (String)session.getAttribute("loginMember");
		Likecp likecp = new Likecp();
		likecp.setLikecpNo(likecpNo);
		likecp.setMemberId(memberId);
		likecp.setLikecpBoolean(likecpBoolean);
		likecp.setCpmemberId(cpmemberId);
		return likecpService.addLikecp(likecp);
	}
	
	
	
	@PostMapping("/modifyLikecp")
	public int modifyScrap(HttpSession session, @RequestParam("likecpNo") int likecpNo, @RequestParam("cpmemberId") String cpmemberId, @RequestParam("likecpBoolean") String likecpBoolean) {
		
		String memberId = (String)session.getAttribute("loginMember");
		
		Likecp likecp = new Likecp();
		likecp.setMemberId(memberId);
		likecp.setLikecpNo(likecpNo);
		likecp.setLikecpBoolean(likecpBoolean);
		likecp.setCpmemberId(cpmemberId);
		return likecpService.modifyLikecp(likecp);
	}
}
