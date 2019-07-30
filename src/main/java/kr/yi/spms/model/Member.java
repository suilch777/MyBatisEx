package kr.yi.spms.model;

import java.util.Date;

public class Member {
	private String memberid;
	private String name;
	private String password;
	private Date regdate;
	
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Member [memberid=" + memberid + ", name=" + name + ", password=" + password + ", regdate=" + regdate
				+ "]";
	}
	
}
