package com.operation;

import java.util.Scanner;

public class  Employee_Update {
	public void updateEmp(int i) throws Exception {

		EmployDetail emp = new EmployDetail();
		emp.getInfo1(i);

	}

	public void resetPassword(String emailId) throws Exception {
		EmployDetail emp = new EmployDetail();
		emp.resetPassword(emailId);
	}
	
	public void approvedTimeSheet(int id) throws Exception {
		EmployDetail emp = new EmployDetail();
		emp.approvedTimeSheet(id);
	}

	public void approvedLeave(int id) throws Exception  {
		EmployDetail emp = new EmployDetail();
		emp.approvedLeave(id);
		
	}
}