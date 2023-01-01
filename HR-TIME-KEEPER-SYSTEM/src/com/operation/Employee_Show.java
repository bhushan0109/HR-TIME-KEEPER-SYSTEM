package com.operation;

import java.util.List;

import com.factory.ServiceFactory;
import com.vo.Employee;
import com.vo.TimeSheetTable;


public class Employee_Show {
	public void viewEmp(int s) throws Exception {

		Employee Employee = ServiceFactory.getIEmployeeServiceInstance().findByEid(s);

		System.out.println(Employee.toString());
	}

	public void listAllEmployees() throws Exception {

		List<Employee> Employee = ServiceFactory.getIEmployeeServiceInstance().listAllEmployees();

		System.out.println(Employee.toString());
	}

	public String findUserRoleByEmaild(String emailId) throws Exception {

		String role = ServiceFactory.getIEmployeeServiceInstance().findUserRoleByEmaild(emailId);

		return role;
	}

	public List<TimeSheetTable> findListTimeSheetTableByEid(int eid) throws Exception {

		List<TimeSheetTable> TimeSheetTable = ServiceFactory.getIEmployeeServiceInstance().findListTimeSheetTableByEid(eid);

		return TimeSheetTable;
	}
	
	public List<TimeSheetTable> findAllListTimeSheetTableByEid() throws Exception {

		List<TimeSheetTable> TimeSheetTable = ServiceFactory.getIEmployeeServiceInstance().findAllListTimeSheetTableByEid();

		return TimeSheetTable;
	}


}