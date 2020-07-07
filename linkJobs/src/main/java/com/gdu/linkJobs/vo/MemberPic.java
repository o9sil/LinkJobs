package com.gdu.linkJobs.vo;


public class MemberPic {
	private String memberId;
	private String memberPic;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPic() {
		return memberPic;
	}
	public void setMemberPic(String memberPic) {
		this.memberPic = memberPic;
	}
	@Override
	public String toString() {
		return "MemberPic [memberId=" + memberId + ", memberPic=" + memberPic + "]";
	}
}	
