package com.gdu.linkJobs.vo;

public class Likecp {
	private int likecpNo;
	private String likecpBoolean;
	private String memberId;
	private String cpmemberId;
	private String likecpDate;
	public int getLikecpNo() {
		return likecpNo;
	}
	public void setLikecpNo(int likecpNo) {
		this.likecpNo = likecpNo;
	}
	public String getLikecpBoolean() {
		return likecpBoolean;
	}
	public void setLikecpBoolean(String likecpBoolean) {
		this.likecpBoolean = likecpBoolean;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getCpmemberId() {
		return cpmemberId;
	}
	public void setCpmemberId(String cpmemberId) {
		this.cpmemberId = cpmemberId;
	}
	public String getLikecpDate() {
		return likecpDate;
	}
	public void setLikecpDate(String likecpDate) {
		this.likecpDate = likecpDate;
	}
	@Override
	public String toString() {
		return "Likecp [likecpNo=" + likecpNo + ", likecpBoolean=" + likecpBoolean + ", memberId=" + memberId
				+ ", cpmemberId=" + cpmemberId + ", likecpDate=" + likecpDate + "]";
	}
	
}
