package com.gdu.linkJobs.vo;

public class AlterCpMemberPw {
	private String cpMemberId;
	private String cpMemberPwBefore;
	private String cpMemberPwAfter;
	public String getCpMemberId() {
		return cpMemberId;
	}
	public void setCpMemberId(String cpMemberId) {
		this.cpMemberId = cpMemberId;
	}
	public String getCpMemberPwBefore() {
		return cpMemberPwBefore;
	}
	public void setCpMemberPwBefore(String cpMemberPwBefore) {
		this.cpMemberPwBefore = cpMemberPwBefore;
	}
	public String getCpMemberPwAfter() {
		return cpMemberPwAfter;
	}
	public void setCpMemberPwAfter(String cpMemberPwAfter) {
		this.cpMemberPwAfter = cpMemberPwAfter;
	}
	@Override
	public String toString() {
		return "AlterCpMemberPw [cpMemberId=" + cpMemberId + ", cpMemberPwBefore=" + cpMemberPwBefore
				+ ", cpMemberPwAfter=" + cpMemberPwAfter + "]";
	}
	
}
