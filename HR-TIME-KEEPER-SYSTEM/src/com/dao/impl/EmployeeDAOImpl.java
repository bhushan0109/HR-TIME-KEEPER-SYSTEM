package com.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.dao.IEmployeeDAO;
import com.vo.Employee;
import com.vo.TimeSheetTable;
import com.vo.Users;

public class EmployeeDAOImpl implements IEmployeeDAO {
	private Connection conn;
	private PreparedStatement pstmt;

	public EmployeeDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean doCreate(Employee vo) throws Exception {
		String sql = "INSERT INTO employee(eid, name, post, mobileNo,hireDate, annual_package) VALUES (?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, vo.getEid());
		this.pstmt.setString(2, vo.getName());
		this.pstmt.setString(3, vo.getPost());
		this.pstmt.setString(4, vo.getMobileNo());
		this.pstmt.setDate(5, new Date(vo.getHireDate().getTime()));
		this.pstmt.setFloat(6, vo.getAnnual_package());
		boolean a = this.pstmt.executeUpdate() > 0;
		String sql1 = "INSERT INTO users(uid, role, emailId,PASSWORD) VALUES (?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql1);
		this.pstmt.setInt(1, vo.getUsers().getUid());
		this.pstmt.setString(2, vo.getUsers().getRole());
		this.pstmt.setString(3, vo.getUsers().getEmailId());
		this.pstmt.setString(4, vo.getUsers().getPASSWORD());

		return this.pstmt.executeUpdate() > 0;

	}

	@Override
	public boolean doCreateTimeSheetTable(TimeSheetTable vo) throws Exception {

		String sql = "INSERT INTO timesheetTable(eid, name, role,total_hr_per_day, workingDate, per_day_salary,per_hour_rate,annual_package,time_sheet_status,leave_status) VALUES (?,?,?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, vo.getEid());
		this.pstmt.setString(2, vo.getName());
		this.pstmt.setString(3, vo.getRole());
		this.pstmt.setFloat(4, vo.getTotal_hr_per_day());
		this.pstmt.setDate(5, new Date(vo.getWorkingDate().getTime()));
		this.pstmt.setFloat(6, vo.getPer_day_salary());
		this.pstmt.setFloat(7, vo.getPer_hour_rate());
		this.pstmt.setFloat(8, vo.getPackage());
		this.pstmt.setString(9, vo.getTime_sheet_status());
		this.pstmt.setString(10, vo.getLeave_status());
		return this.pstmt.executeUpdate() > 0;

	}

	@Override
	public boolean doUpdate(Employee vo) throws Exception {
		String sql = "UPDATE employee SET name=?, post=?,mobileNo=?,hireDate=?, annual_package=? WHERE eid=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getName());
		this.pstmt.setString(2, vo.getPost());
		this.pstmt.setString(3, vo.getMobileNo());
		this.pstmt.setDate(4, new Date(vo.getHireDate().getTime()));
		this.pstmt.setFloat(5, vo.getAnnual_package());
		this.pstmt.setInt(6, vo.getEid());
		boolean a = this.pstmt.executeUpdate() > 0;

		String sql1 = "UPDATE users SET  role=?, emailId=?,PASSWORD=? WHERE uid=?";
		this.pstmt = this.conn.prepareStatement(sql1);

		this.pstmt.setString(1, vo.getUsers().getRole());
		this.pstmt.setString(2, vo.getUsers().getEmailId());
		this.pstmt.setString(3, vo.getUsers().getPASSWORD());
		this.pstmt.setInt(4, vo.getUsers().getUid());

		return this.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean resetPassword(Users vo) throws Exception {

		String sql1 = "UPDATE users SET emailId=?,PASSWORD=? WHERE emailId=?";
		this.pstmt = this.conn.prepareStatement(sql1);

		this.pstmt.setString(1, vo.getEmailId());
		this.pstmt.setString(2, vo.getPASSWORD());
		this.pstmt.setString(3, vo.getEmailId());

		return this.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean approvedTimeSheet(int id) throws Exception {

		String sql1 = "UPDATE timesheetTable SET time_sheet_status=? WHERE tid=?";
		this.pstmt = this.conn.prepareStatement(sql1);

		this.pstmt.setString(1, "Approved");
		this.pstmt.setInt(2, id);

		return this.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> eids) throws Exception {
		if (eids == null || eids.size() == 0) {
			return false;
		}
		try {
			StringBuffer buf = new StringBuffer("DELETE FROM employee WHERE eid IN(");
			Iterator<Integer> iter = eids.iterator();
			while (iter.hasNext()) {
				buf.append(iter.next()).append(",");
			}
			buf.delete(buf.length() - 1, buf.length()).append(")");
			this.pstmt = this.conn.prepareStatement(buf.toString());
			boolean a = this.pstmt.executeUpdate() == eids.size();

		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer buf1 = new StringBuffer("DELETE FROM users WHERE uid IN(");
		Iterator<Integer> iter1 = eids.iterator();
		while (iter1.hasNext()) {
			buf1.append(iter1.next()).append(",");
		}
		buf1.delete(buf1.length() - 1, buf1.length()).append(")");
		this.pstmt = this.conn.prepareStatement(buf1.toString());
		return this.pstmt.executeUpdate() == eids.size();
	}

	@Override
	public Employee findByEid(Integer eid) throws Exception {
		Employee ret = null;
		String sql = "SELECT * FROM employee WHERE eid=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, eid);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			ret = new Employee();
			ret.setEid(rs.getInt(1));
			ret.setName(rs.getString(2));
			ret.setPost(rs.getString(3));
			ret.setMobileNo(rs.getString(4));
			ret.setAnnual_package(rs.getFloat(5));
			ret.setHireDate(rs.getDate(6));

		}
		return ret;
	}

	@Override
	public Employee findUserByEmaildAndPassword(String emmailId, String Password) throws Exception {
		Employee ret = null;

		int uid = 0;
		String sql1 = "SELECT uid FROM users WHERE emailId=? and PASSWORD=?";
		this.pstmt = this.conn.prepareStatement(sql1);
		this.pstmt.setString(1, emmailId);
		this.pstmt.setString(2, Password);
		ResultSet rs1 = this.pstmt.executeQuery();
		if (rs1.next()) {
			ret = new Employee();
			uid = rs1.getInt(1);
		}

		String sql = "SELECT * FROM employee WHERE eid=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, uid);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			ret = new Employee();
			ret.setEid(rs.getInt(1));
			ret.setName(rs.getString(2));
			ret.setPost(rs.getString(3));
			ret.setMobileNo(rs.getString(4));
			ret.setAnnual_package(rs.getFloat(5));
			ret.setHireDate(rs.getDate(6));

		}
		return ret;
	}

	@Override
	public List<Employee> findAll() throws Exception {
		List<Employee> al = new ArrayList<>();
		String sql = "SELECT * FROM employee";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Employee ret = new Employee();
			ret.setEid(rs.getInt(1));
			ret.setName(rs.getString(2));
			ret.setPost(rs.getString(3));
			ret.setMobileNo(rs.getString(4));
			ret.setAnnual_package(rs.getFloat(5));
			ret.setHireDate(rs.getDate(6));
			al.add(ret);
		}
		return al;
	}

	@Override
	public List<Employee> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
			throws Exception {
		List<Employee> al = new ArrayList<>();
		String sql = "SELECT * FROM (SELECT eid,name,post,hireDate,salary,bonus,ROWNUM rn FROM employee WHERE " + column
				+ " LIKE ? AND ROWNUM<=?) temp WHERE temp.rn>?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setInt(2, currentPage * lineSize);
		this.pstmt.setInt(3, (currentPage - 1) * lineSize);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Employee emp = new Employee();
			emp.setEid(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setPost(rs.getString(3));
			emp.setHireDate(rs.getDate(4));
			emp.setAnnual_package(rs.getFloat(5));
			al.add(emp);
		}
		return al;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws Exception {
		String sql = "SELECT COUNT(eid) FROM employee WHERE " + column + " LIKE ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			return rs.getInt(1);
		}
		return null;
	}

	@Override
	public String findUserRoleByEmaild(String emailId) throws Exception {

		String role = "";
		String sql1 = "SELECT role FROM users WHERE emailId=?";
		this.pstmt = this.conn.prepareStatement(sql1);
		this.pstmt.setString(1, emailId);
		ResultSet rs1 = this.pstmt.executeQuery();
		if (rs1.next()) {
			role = rs1.getString(1);
		}
		return role;
	}

	@Override
	public List<TimeSheetTable> findListTimeSheetTableByEid(Integer eid) throws Exception {
		List<TimeSheetTable> al = new ArrayList<>();
		String sql = "SELECT * FROM timesheetTable WHERE eid=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, eid);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			TimeSheetTable ret = new TimeSheetTable();
			ret.setTid(rs.getInt(1));
			ret.setEid(rs.getInt(2));
			ret.setName(rs.getString(3));
			ret.setRole(rs.getString(4));
			ret.setTotal_hr_per_day(rs.getFloat(5));
			ret.setWorkingDate(rs.getDate(6));
			ret.setPer_day_salary(rs.getFloat(7));
			ret.setPer_hour_rate(rs.getFloat(8));
			ret.setPackage(rs.getFloat(9));
			ret.setTime_sheet_status(rs.getString(10));
			ret.setLeave_status(rs.getString(11));
			al.add(ret);
		}
		return al;
	}

	@Override
	public List<TimeSheetTable> findAllListTimeSheetTableByEid() throws SQLException {
		List<TimeSheetTable> al = new ArrayList<>();
		String sql = "SELECT * FROM timesheetTable ";
		this.pstmt = this.conn.prepareStatement(sql);

		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			TimeSheetTable ret = new TimeSheetTable();
			ret.setTid(rs.getInt(1));
			ret.setEid(rs.getInt(2));
			ret.setName(rs.getString(3));
			ret.setRole(rs.getString(4));
			ret.setTotal_hr_per_day(rs.getFloat(5));
			ret.setWorkingDate(rs.getDate(6));
			ret.setPer_day_salary(rs.getFloat(7));
			ret.setPer_hour_rate(rs.getFloat(8));
			ret.setPackage(rs.getFloat(9));
			ret.setTime_sheet_status(rs.getString(10));
			ret.setLeave_status(rs.getString(11));
			al.add(ret);
		}
		return al;
	}

	@Override
	public boolean approvedLeave(int id) throws SQLException {

		String sql1 = "UPDATE timesheetTable SET leave_status=? WHERE tid=?";
		this.pstmt = this.conn.prepareStatement(sql1);

		this.pstmt.setString(1, "Y");
		this.pstmt.setInt(2, id);

		return this.pstmt.executeUpdate() > 0;
	}

}
