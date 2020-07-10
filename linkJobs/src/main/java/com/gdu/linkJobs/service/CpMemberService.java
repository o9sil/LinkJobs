package com.gdu.linkJobs.service;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gdu.linkJobs.mapper.AreaMapper;
import com.gdu.linkJobs.mapper.CpMemberMapper;
import com.gdu.linkJobs.vo.AlterCpMemberPw;
import com.gdu.linkJobs.vo.AreaAndArea2;
import com.gdu.linkJobs.vo.CpMember;
import com.gdu.linkJobs.vo.LoginCpMember;

@Service
public class CpMemberService extends HttpServlet {	
	
	@Autowired
	private CpMemberMapper cpMemberMapper;	
	
	@Autowired
	private AreaMapper areaMapper;
	
	@Autowired private JavaMailSender javaMailSender;
	
	//기업회원 사진 저장
	public int modifyCpMemberPic(Map<String, Object> map) {
		
		String cpMemberId = (String) map.get("cpMemberId");
		MultipartFile cpMemberPic = (MultipartFile) map.get("cpMemberPic");

		// memberForm -> member
		//MultipartFile mf = cpMemberPic;
		
		System.out.println(cpMemberPic);
		// 확장자 
		String originName = cpMemberPic.getOriginalFilename();
		int lastDot = originName.lastIndexOf(".");
		String extention = originName.substring(lastDot);
		String memberPic = cpMemberId + extention;
		
		System.out.println("cpmemberPic = " + memberPic);

		// db에 저장
		Map<String, Object> map2 = new HashMap<>();
		map2.put("cpmemberId", cpMemberId);
		map2.put("cpmemberPic", memberPic);
		
		int row = cpMemberMapper.updateCpMemberPic(map2);

		// 2.파일 저장
		URL location = this.getClass().getResource("/static/img/LinkJobsLogo.png");
	    String path = location.getPath();
	    String rightPath = path.substring(0, path.lastIndexOf("/"));
	    System.out.println("경로 = " + rightPath);
		
		
		File file = new File(rightPath +"\\"+ memberPic);
		//기존의 파일 삭제
		if(file.exists()) {
			if(file.getName() != "LinkJobsLogo.png") {
				file.delete();
			}
		}
		
		//새로 추가
		try {
			cpMemberPic.transferTo(file);
		} catch (Exception e) { 
			e.printStackTrace();
			throw new RuntimeException();
		}

		return row;

	}
	
	//기업회원 사진 가져오기
	public String getCpMemberPic(String cpMemberId) {
		return cpMemberMapper.selectCpMemberPic(cpMemberId);
	}
		
	
	//기업회원 상세정보 수정
	public int modifyCpMemberDetail(CpMember cpMember, String areaSido, String areaGungu) {
		System.out.println("modifyCpMemberDetail = " + cpMember);
		System.out.println("modifyCpMemberDetail = " + areaSido);
		System.out.println("modifyCpMemberDetail = " + areaGungu);
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cpMember", cpMember);
		map.put("areaSido", areaSido);
		map.put("areaGungu", areaGungu);
		
		cpMemberMapper.updateCpMemberDetail(map);
		
		return 0;
		//return cpMemberMapper.updateCpMemberDetail(cpMember);
	}
	
	//기업회원 상세정보 가져오기
	public Map<String, Object> getCpMemberDetail(String cpMemberId) {
		
		CpMember cpMember = cpMemberMapper.selectCpMemberDetail(cpMemberId);
		
		System.out.println("getCpMemberDetail area2No = " + cpMember.getCpMemberArea2No());
		AreaAndArea2 areaAndArea2 = areaMapper.selectAreaSidoGungu(cpMember.getCpMemberArea2No());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cpMember", cpMember);
		map.put("areaAndArea2", areaAndArea2);
		
		return map;
	}
	
	//기업회원 PW 수정
	public int modifyCpMemberPw(AlterCpMemberPw alterCpMemberPw) {
		return cpMemberMapper.updateCpMemberPw(alterCpMemberPw);
	}
	
	//기업회원 PW 찾기
	public int findCpMemberPw(CpMember cpMember) {
		
		String pw = RandomStringUtils.randomNumeric(10);

		cpMember.setCpMemberPw(pw);
		
		int row = cpMemberMapper.updateCpMemberPwRandom(cpMember);
		
		if(row==1) {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(cpMember.getCpMemberEmail());
			simpleMailMessage.setFrom("LinkJobs");
			simpleMailMessage.setSubject("LinkJobs PW 찾기");	
			simpleMailMessage.setText("기업회원 PW " + pw + " 입니다.");
			
			javaMailSender.send(simpleMailMessage);
		}
		return row;
	}
	
	//기업회원 ID 찾기
	public int getCpMemberId(CpMember cpMember) {
		
		CpMember returnCpMember = cpMemberMapper.selectCpMemberId(cpMember); 
		//System.out.println("cpMemberService getCpMemberId = " + returnCpMember);
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(returnCpMember.getCpMemberEmail());
		simpleMailMessage.setFrom("LinkJobs");
		simpleMailMessage.setSubject("LinkJobs ID 찾기");	
		simpleMailMessage.setText("기업회원 ID " + returnCpMember.getCpMemberId() + " 입니다.");
		
		javaMailSender.send(simpleMailMessage);
		
		return 0; 
	}
	
	
	//회원가입 전 기존 아이디 존재하는지 확인
	public int getCpMemberIdCnt(String cpMemberId) {
		return cpMemberMapper.selectCpMemberIdCnt(cpMemberId);
	}
	
	//로그인
	public String login(LoginCpMember loginCpMember) {		
		return cpMemberMapper.selectLoginCpMember(loginCpMember);
	}
	
	//회원가입
	public int addMember(CpMember cpMember) {		
		int row = cpMemberMapper.insertCpMember(cpMember);
		return row;
	}	
	
}
