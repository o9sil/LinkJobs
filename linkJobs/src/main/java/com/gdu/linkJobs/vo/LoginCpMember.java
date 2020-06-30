package com.gdu.linkJobs.vo;

public class LoginCpMember {
	private String cpMemberId;
	private String cpMemberPw;
	

	public String getCpMemberId() {
		return cpMemberId;
	}
	public void setCpMemberId(String cpMemberId) {
		this.cpMemberId = cpMemberId;
	}
	public String getCpMemberPw() {
		return cpMemberPw;
	}
	public void setCpMemberPw(String cpMemberPw) {
		this.cpMemberPw = cpMemberPw;
	}

	@Override
	public String toString() {
		return "LoginCpMember [cpMemberId=" + cpMemberId + ", cpMemberPw=" + cpMemberPw + "]";
	}
	
	
	
}
