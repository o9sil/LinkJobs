package com.gdu.linkJobs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;
import com.gdu.linkJobs.common.KakaoLogin;

@Controller
public class CpMemberController {
	KakaoLogin login = null;
	
	// 카카오 로그인 및 유저 정보	
    @RequestMapping(value="/cpKakaoLogin")
    public String login(@RequestParam("code") String code, HttpSession session) {
    	    	
    	login = new KakaoLogin();
    	JsonNode jsonToken = login.getKakaoAccessToken(code, true);
    	JsonNode accessToken = jsonToken.get("access_token");
    	JsonNode userInfo = KakaoLogin.getKakaoUserInfo(accessToken);
    	
    	String id = userInfo.path("id").asText();
        String name = null;
        String email = null;
 
        // 유저정보 카카오에서 가져오기 Get properties
        JsonNode properties = userInfo.path("properties");
        JsonNode kakao_account = userInfo.path("kakao_account");
 
        name = properties.path("nickname").asText();
        email = kakao_account.path("email").asText();
 
        System.out.println("id : " + id);
        System.out.println("name : " + name);
        System.out.println("email : " + email);
        session.setAttribute("token",accessToken);
        session.setMaxInactiveInterval(450);
        return "redirect:/index.html";
    }
}

