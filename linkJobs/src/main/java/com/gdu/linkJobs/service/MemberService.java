package com.gdu.linkJobs.service;

import java.io.File;
import java.net.URL;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gdu.linkJobs.mapper.MemberAcademicMapper;
import com.gdu.linkJobs.mapper.MemberCertificateMapper;
import com.gdu.linkJobs.mapper.MemberMapper;
import com.gdu.linkJobs.mapper.MemberPicMapper;
import com.gdu.linkJobs.mapper.MemberWithdrawalMapper;
import com.gdu.linkJobs.mapper.SelfIntroductionMapper;
import com.gdu.linkJobs.vo.LoginMember;
import com.gdu.linkJobs.vo.Member;
import com.gdu.linkJobs.vo.MemberPic;
import com.gdu.linkJobs.vo.MemberPicForm;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private MemberPicMapper memberPicMapper;
	@Autowired
	private MemberWithdrawalMapper withdrawalMapper;
	@Autowired
	private MemberCertificateMapper certificateMapper;
	@Autowired
	private MemberAcademicMapper academicMapper;
	@Autowired
	private SelfIntroductionMapper introductionMapper;
	@Autowired 
	private JavaMailSender javaMailSender;

	
	//회원 아이디 찾기
	public int findMemberId(Member member) {
		Member returnMember = memberMapper.findMemberId(member);
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(returnMember.getMemberEmail());
		simpleMailMessage.setFrom("LinkJobs");
		simpleMailMessage.setSubject("LinkJobs ID 찾기");
		simpleMailMessage.setText("기업회원 ID" + returnMember.getMemberId() + "입니다.");
		
		javaMailSender.send(simpleMailMessage);
		
		return 0; 
	}
	
	
	//회원 비밀번호 찾기
	public int findMemberPw(Member member) {
		UUID uid = UUID.randomUUID(); //랜덤 문자열 생성
		
		String pw = uid.toString().substring(0,8);
		System.out.println(pw+ "<-- memberPW");
		member.setMemberPw(pw);
		
		int row = memberMapper.findMemberPw(member);
		System.out.println(row + "<=====row");
		
		if(row ==1) {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(member.getMemberEmail());
			simpleMailMessage.setFrom("");
			simpleMailMessage.setSubject("비밀번호 찾기 메일");
			simpleMailMessage.setText("변경된 비밀번호는" + pw + "입니다.");
			
			javaMailSender.send(simpleMailMessage);
		}
		
		return row;
	}
	
	
	// 회원 탈퇴 -> 회원 삭제
	public void removeMember(Member member) {
		academicMapper.removeMemberAcademic(member.getMemberId());
		certificateMapper.removeMemberCertificate(member.getMemberId());
		introductionMapper.removeSelfIntroduction(member.getMemberId());

		if (memberMapper.deleteMember(member) == 1) {
			System.out.println("memberDelete");
			memberMapper.deleteMember(member);
			withdrawalMapper.addMemberWithdrawal(member.getMemberId());
		} else {
			return;
		}

	}

	// 회원 비밀번호 수정
	public int modifyMemberPw(Member member) {
		return memberMapper.updateMemberPw(member);
	}

	// 이력서 회원정보 출력
	public Member getMemberOne(String memberId) {
		return memberMapper.selectMemberOne(memberId);
	}

	// 일반회원 회원가입
	public void addMember(Member member) {
		memberMapper.insertMember(member);
		memberPicMapper.insertMemberPic(member.getMemberId());

	}

	// 중복확인 (아이디)
	public String memberIdCheck(String memberId) {
		return memberMapper.memberIdCheck(memberId);
	}

	// loginMember
	public String loginMember(LoginMember loginMember) {
		return memberMapper.loginMember(loginMember);
	}

	// 회원정보수정
	public int modifyMember(Member member) {
		return memberMapper.updateMember(member);
	}

	// 사진 수정 액션
	public int modifyMemberPic(MemberPicForm memberPicForm) {

		// memberForm -> member
		MultipartFile mf = memberPicForm.getMemberPic();
		
		// 확장자 
		String originName = mf.getOriginalFilename();
		int lastDot = originName.lastIndexOf(".");
		String extention = originName.substring(lastDot);
		String memberPic = memberPicForm.getMemberId() + extention;

		// db에 저장
		MemberPic pic=new MemberPic();
		pic.setMemberId(memberPicForm.getMemberId());
		pic.setMemberPic(memberPic);

		int row = memberPicMapper.updateMemberPic(pic);

		// 2.파일 저장
		URL location = this.getClass().getResource("/static/img/default.jpg");
	    String path = location.getPath();
	    String rightPath = path.substring(0, path.lastIndexOf("/"));
	    System.out.println("경로 = " + rightPath);
		
		
		File file = new File(rightPath +"\\"+ memberPic);
		//기존의 파일 삭제
		if(file.exists()) {
			if(file.getName() != "default.jpg") {
				file.delete();
			}
		}
		
		//새로 추가
		try {
			mf.transferTo(file);
		} catch (Exception e) { 
			e.printStackTrace();
			throw new RuntimeException();
		}

		return row;

	}
	/*
	private MultipartFile MultipartFile(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	// 사진 수정 폼
	public MemberPic getMemberPic(String memberId) {
		return memberPicMapper.selectMeberPic(memberId);
	}

}
