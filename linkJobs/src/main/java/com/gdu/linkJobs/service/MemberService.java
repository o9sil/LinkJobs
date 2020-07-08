package com.gdu.linkJobs.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
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
		String path = "C:\\Users\\gd\\Desktop\\linkjobsSpring\\maven.1594088790603\\linkJobs\\src\\main\\resources\\static\\img";

		
		File file = new File(path +"\\"+ memberPic);
		//기존의 파일 삭제
		if(file.exists()) {
			file.delete();
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

	private MultipartFile MultipartFile(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	// 사진 수정 폼
	public MemberPic getMemberPic(String memberId) {
		return memberPicMapper.selectMeberPic(memberId);
	}

}
