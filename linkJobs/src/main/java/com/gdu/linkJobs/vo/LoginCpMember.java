package com.gdu.linkJobs.vo;

public class LoginCpMember {
	private String cpmemberId;
	private String cpmemberPw;
	
	@Override
	public String toString() {
		return "LoginCpmember [cpmemberId=" + cpmemberId + ", cpmemberPw=" + cpmemberPw + "]";
	}
	
	public String getCpmemberId() {
		return cpmemberId;
	}
	public void setCpmemberId(String cpmemberId) {
		this.cpmemberId = cpmemberId;
	}
	public String getCpmemberPw() {
		return cpmemberPw;
	}
	public void setCpmemberPw(String cpmemberPw) {
		this.cpmemberPw = cpmemberPw;
	}
	
}
