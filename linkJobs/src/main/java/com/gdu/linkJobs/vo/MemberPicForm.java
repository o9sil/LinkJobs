package com.gdu.linkJobs.vo;

import org.springframework.web.multipart.MultipartFile;

public class MemberPicForm {
	private String memberId;
	private MultipartFile memberPic;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public MultipartFile getMemberPic() {
		return memberPic;
	}
	public void setMemberPic(MultipartFile memberPic) {
		this.memberPic = memberPic;
	}
	
	
}	
