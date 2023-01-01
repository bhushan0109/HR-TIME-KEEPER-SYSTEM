package com.operation;

import java.util.Scanner;

public class Employee_Add {
	public void addEmp() throws Exception {

		EmployDetail emp = new EmployDetail();
		emp.saveEmp();
	}
	public void submit(String role) throws Exception {

		EmployDetail emp = new EmployDetail();
		emp.submit_timesheet(role);
	}
	
}