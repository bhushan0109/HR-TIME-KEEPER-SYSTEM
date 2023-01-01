package com.vo;

import java.io.Serializable;
import java.util.Date;


public class Employee implements Serializable {

	private Integer eid;
	private String name;
	private String post;
	private String mobileNo;
	private Date hireDate;
	private Float annual_package;

	private Users users;

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Float getAnnual_package() {
		return annual_package;
	}

	public void setAnnual_package(Float annual_package) {
		this.annual_package = annual_package;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", post=" + post + ", mobileNo=" + mobileNo + ", hireDate="
				+ hireDate + ", annual_package=" + annual_package + ", users=" + users + "]";
	}

}
