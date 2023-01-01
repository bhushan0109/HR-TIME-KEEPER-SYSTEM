package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.vo.Employee;
import com.vo.TimeSheetTable;
import com.vo.Users;


/**
 * This Interface shows available operations in Data Access Object to Business
 * Object, and wait the Business Object to call.
 */
public interface IEmployeeDAO extends IDAO<Integer, Employee> {

	Employee findUserByEmaildAndPassword(String emmailId, String Password) throws Exception;

	boolean resetPassword(Users vo) throws Exception;

	String findUserRoleByEmaild(String emailId) throws Exception;

	List<TimeSheetTable> findListTimeSheetTableByEid(Integer eid) throws Exception;

	List<TimeSheetTable> findAllListTimeSheetTableByEid() throws SQLException;

	boolean approvedTimeSheet(int id) throws Exception;

	boolean approvedLeave(int id) throws SQLException;
}
