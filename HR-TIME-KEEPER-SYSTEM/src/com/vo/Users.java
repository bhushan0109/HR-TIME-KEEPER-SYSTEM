package com.vo;

import java.util.Date;

public class Users {

	private Integer uid;
	private String role;
	private String PASSWORD;
	private String emailId;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Users [uid=" + uid + ", role=" + role + ", PASSWORD=" + PASSWORD + ", emailId=" + emailId + "]";
	}

}
