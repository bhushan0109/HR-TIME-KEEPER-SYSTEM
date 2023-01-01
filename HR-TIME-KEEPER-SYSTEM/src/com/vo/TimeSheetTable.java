package com.vo;

import java.util.Date;

public class TimeSheetTable {
	
	private Integer tid;
	private Integer eid;
	private String name;
	private String role;
	private Float total_hr_per_day;
	private Date workingDate;
	private Float per_day_salary;
	private Float per_hour_rate;
	private Float Package;
	private String time_sheet_status;
	private String leave_status;

	
	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getLeave_status() {
		return leave_status;
	}

	public void setLeave_status(String leave_status) {
		this.leave_status = leave_status;
	}

	public String getTime_sheet_status() {
		return time_sheet_status;
	}

	public void setTime_sheet_status(String time_sheet_status) {
		this.time_sheet_status = time_sheet_status;
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Float getTotal_hr_per_day() {
		return total_hr_per_day;
	}

	public void setTotal_hr_per_day(Float total_hr_per_day) {
		this.total_hr_per_day = total_hr_per_day;
	}

	public Date getWorkingDate() {
		return workingDate;
	}

	public void setWorkingDate(Date workingDate) {
		this.workingDate = workingDate;
	}

	public Float getPer_day_salary() {
		return per_day_salary;
	}

	public void setPer_day_salary(Float per_day_salary) {
		this.per_day_salary = per_day_salary;
	}

	public Float getPer_hour_rate() {
		return per_hour_rate;
	}

	public void setPer_hour_rate(Float per_hour_rate) {
		this.per_hour_rate = per_hour_rate;
	}

	public Float getPackage() {
		return Package;
	}

	public void setPackage(Float package1) {
		Package = package1;
	}

	@Override
	public String toString() {
		return "TimeSheetTable [tid=" + tid + ", eid=" + eid + ", name=" + name + ", role=" + role
				+ ", total_hr_per_day=" + total_hr_per_day + ", workingDate=" + workingDate + ", per_day_salary="
				+ per_day_salary + ", per_hour_rate=" + per_hour_rate + ", Package=" + Package + ", time_sheet_status="
				+ time_sheet_status + ", leave_status=" + leave_status + "]";
	}

}
