package com.operation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.factory.ServiceFactory;
import com.vo.Employee;
import com.vo.TimeSheetTable;
import com.vo.Users;

public class EmployDetail {
	int employ_id;
	String name;
	String email;
	String position;
	float annual_package;
	String mobileNo;

	public void saveEmp() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Employee's name --------: ");
		name = sc.nextLine();
		System.out.print("Enter Employee's ID ----------: ");
		employ_id = sc.nextInt();

		System.out.print("Enter Employee's Position ----: ");
		position = sc.next();
		System.out.print("Enter Employee mobileNo --: ");
		mobileNo = sc.next();
		System.out.print("Enter Employee's DOB[yyyy-MM-dd] ------: ");
		String DOB = sc.next();

		System.out.print("Enter Employee's Email ID ----: ");
		email = sc.next();
		System.out.print("Enter Employee's password ----: ");
		String password = sc.next();
		System.out.print("Enter Employee role - ADMIN, TESTER, DEVELOPER, MANAGER, DESIGNER--: ");
		String role = sc.next();
		try {
			if (role.equalsIgnoreCase("ADMIN") || role.equalsIgnoreCase("ADMIN") || role.equalsIgnoreCase("TESTER")
					|| role.equalsIgnoreCase("DEVELOPER") || role.equalsIgnoreCase("MANAGER")
					|| role.equalsIgnoreCase("DESIGNER")) {
				role = role;
			} else {
				System.out.print(
						" you enter wrong input \n Enter Employee role - ADMIN, TESTER, DEVELOPER, MANAGER, DESIGNER--: ");
				System.out.print("Enter Employee role - ADMIN, TESTER, DEVELOPER, MANAGER, DESIGNER--: ");
				role = sc.next();
			}
		} catch (Exception e) {
			System.out.print(
					" you enter wrong input \n Enter Employee role - ADMIN, TESTER, DEVELOPER, MANAGER, DESIGNER--: ");
			System.out.print("Enter Employee role - ADMIN, TESTER, DEVELOPER, MANAGER, DESIGNER--: ");
			role = sc.next();
		}

		try {
			if (role.equalsIgnoreCase("ADMIN")) {
			} else if (role.equalsIgnoreCase("TESTER")) {
				annual_package = 1000000;

			} else if (role.equalsIgnoreCase("DEVELOPER")) {
				annual_package = 2000000;

			} else if (role.equalsIgnoreCase("MANAGER")) {
				annual_package = 3000000;

			} else if (role.equalsIgnoreCase("DESIGNER")) {
				annual_package = 3000000;

			}
		} catch (Exception e) {
			System.out.print(" you enter wrong input ");
			System.out.print("try again-:");
			role = sc.next();
		}

		Set<Integer> eids = new HashSet<>();
		eids.add(employ_id);
		ServiceFactory.getIEmployeeServiceInstance().delete(eids);
		Employee emp1 = new Employee();
		emp1.setEid(employ_id);
		emp1.setName(name);
		emp1.setPost(position);
		Date date = (new SimpleDateFormat("yyyy-MM-dd")).parse(DOB);
		emp1.setHireDate(date);
		emp1.setMobileNo(mobileNo);
		emp1.setAnnual_package(annual_package);

		Users usr = new Users();
		usr.setEmailId(email);
		usr.setRole(role.toUpperCase());
		usr.setPASSWORD(password);
		usr.setUid(employ_id);

		emp1.setUsers(usr);

		boolean insertion = ServiceFactory.getIEmployeeServiceInstance().insert(emp1);
		if (insertion == true) {
			System.out.println("User Registered Successfully");
		} else {
			System.out.println("User Registered Fails");
		}

	}

	public void getInfo1(int employ_id) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Employee's name --------: ");
		name = sc.nextLine();

		System.out.println("Enter Employee's Position ----: ");
		position = sc.next();
		System.out.print("Enter Employee mobileNo --: ");
		mobileNo = sc.next();
		System.out.print("Enter Employee's DOB [yyyy-MM-dd] ------: ");
		String DOB = sc.next();
//		System.out.print("Enter Employee's annual_package ------: ");
//		annual_package = sc.nextFloat();

		System.out.print("Enter Employee's Email ID ----: ");
		email = sc.next();
		System.out.print("Enter Employee's password ----: ");
		String password = sc.next();
		System.out.print("Enter Employee role - ADMIN, TESTER, DEVELOPER, MANAGER, DESIGNER--: ");
		String role = sc.next();
		try {
			if (role.equalsIgnoreCase("ADMIN") || role.equalsIgnoreCase("ADMIN") || role.equalsIgnoreCase("TESTER")
					|| role.equalsIgnoreCase("DEVELOPER") || role.equalsIgnoreCase("MANAGER")
					|| role.equalsIgnoreCase("DESIGNER")) {
				role = role;
			} else {
				System.out.print(
						" you enter wrong input \n Enter Employee role - ADMIN, TESTER, DEVELOPER, MANAGER, DESIGNER--: ");
				System.out.print("Enter Employee role - ADMIN, TESTER, DEVELOPER, MANAGER, DESIGNER--: ");
				role = sc.next();
			}
		} catch (Exception e) {
			System.out.print(
					" you enter wrong input \n Enter Employee role - ADMIN, TESTER, DEVELOPER, MANAGER, DESIGNER--: ");
			System.out.print("Enter Employee role - ADMIN, TESTER, DEVELOPER, MANAGER, DESIGNER--: ");
			role = sc.next();
		}
		try {
			if (role.equalsIgnoreCase("ADMIN")) {
			} else if (role.equalsIgnoreCase("TESTER")) {
				annual_package = 1000000;

			} else if (role.equalsIgnoreCase("DEVELOPER")) {
				annual_package = 2000000;

			} else if (role.equalsIgnoreCase("MANAGER")) {
				annual_package = 3000000;

			} else if (role.equalsIgnoreCase("DESIGNER")) {
				annual_package = 3000000;

			}
		} catch (Exception e) {
			System.out.print(" you enter wrong input ");
			System.out.print("try again-:");
			role = sc.next();
		}

		Employee emp1 = new Employee();
		emp1.setEid(employ_id);
		emp1.setName(name);
		emp1.setPost(position);
		Date date = (new SimpleDateFormat("yyyy-MM-dd")).parse(DOB);
		emp1.setHireDate(date);
		emp1.setMobileNo(mobileNo);
		emp1.setAnnual_package(annual_package);
		Users usr = new Users();
		usr.setEmailId(email);
		usr.setRole(role.toUpperCase());
		usr.setPASSWORD(password);
		usr.setUid(employ_id);
		emp1.setUsers(usr);

		boolean insertion = ServiceFactory.getIEmployeeServiceInstance().update(emp1);
		if (insertion == true) {
			System.out.println("User Updated succesfully");
		} else {
			System.out.println("User Not Updated succesfully");
		}

	}

	public void resetPassword(String emailId) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter New password ----: ");
		String password = sc.next();

		Users usr = new Users();
		usr.setEmailId(emailId);
		usr.setPASSWORD(password);

		boolean insertion = ServiceFactory.getIEmployeeServiceInstance().resetPassword(usr);
		if (insertion == true) {
			System.out.println("User Password Set succesfully");
		} else {
			System.out.println("User Password Set  Fail Try Again");
		}

	}

	public void submit_timesheet(String role) throws Exception {
		float annual_package = 0;
		float constant_perday = 0;
		float per_hour_rate = 0;
		float per_day_salary = 0;

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Employee's ID ----------: ");
		employ_id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Employee's name --------: ");
		name = sc.nextLine();

		System.out.print("Enter total_hr_per_day --: ");
		float total_hr_per_day = sc.nextFloat();

		System.out.print("Enter  workingDate[yyyy-MM-dd] ------: ");
		String workingDate = sc.next();

		String time_sheet_status = "draft";
		System.out.print("Enter Employee's leave_status Y/N ----: ");
		String leave_status = sc.next();
		if (leave_status.equalsIgnoreCase("Y")) {
			leave_status.toUpperCase();
		} else if (leave_status.equalsIgnoreCase("N")) {
			leave_status.toUpperCase();
		} else {
			System.out.println("Wrong Input , please type Y / N");
			System.out.print("Enter Employee's leave_status Y/N ----: ");
			leave_status = sc.next();
		}

		try {
			if (role.equalsIgnoreCase("ADMIN")) {
				System.out.println("admin block");
			} else if (role.equalsIgnoreCase("TESTER")) {
				annual_package = 1000000;
				constant_perday = annual_package / 360;
				per_hour_rate = constant_perday / total_hr_per_day;
				per_day_salary = per_hour_rate * total_hr_per_day;

			} else if (role.equalsIgnoreCase("DEVELOPER")) {
				annual_package = 2000000;
				constant_perday = annual_package / 360;
				per_hour_rate = constant_perday / total_hr_per_day;
				per_day_salary = per_hour_rate * total_hr_per_day;

			} else if (role.equalsIgnoreCase("MANAGER")) {
				annual_package = 3000000;
				constant_perday = annual_package / 360;
				per_hour_rate = constant_perday / total_hr_per_day;
				per_day_salary = per_hour_rate * total_hr_per_day;

			} else if (role.equalsIgnoreCase("DESIGNER")) {
				annual_package = 3000000;
				constant_perday = annual_package / 360;
				per_hour_rate = constant_perday / total_hr_per_day;
				per_day_salary = per_hour_rate * total_hr_per_day;

			}
		} catch (Exception e) {
			System.out.print(" you enter wrong input ");
			System.out.print("try again-:");
			role = sc.next();
		}

		TimeSheetTable timeSheetTable = new TimeSheetTable();
		timeSheetTable.setEid(employ_id);
		timeSheetTable.setName(name);
		timeSheetTable.setRole(role);
		timeSheetTable.setPackage(annual_package);
		timeSheetTable.setPer_hour_rate(per_hour_rate);
		timeSheetTable.setTotal_hr_per_day(total_hr_per_day);
		timeSheetTable.setTime_sheet_status(time_sheet_status);
		timeSheetTable.setLeave_status(leave_status);
		timeSheetTable.setPer_day_salary(per_day_salary);

		Date date = (new SimpleDateFormat("yyyy-MM-dd")).parse(workingDate);
		timeSheetTable.setWorkingDate(date);

		boolean insertion = ServiceFactory.getIEmployeeServiceInstance().insertTimeSheetTable(timeSheetTable);
		if (insertion == true) {
			System.out.println("Time Sheet Submited Successfully");
		} else {
			System.out.println("Time Sheet Submited Fails");
		}

	}

	public void approvedTimeSheet(int id) throws Exception {
		Scanner sc = new Scanner(System.in);

		boolean insertion = ServiceFactory.getIEmployeeServiceInstance().approvedTimeSheet(id);
		if (insertion == true) {
			System.out.println("Time Sheet Approved  Successfully");
		} else {
			System.out.println("Time Sheet Approved  Fail Try Again");
		}
	}

	public void approvedLeave(int id) throws Exception {
		Scanner sc = new Scanner(System.in);

		boolean insertion = ServiceFactory.getIEmployeeServiceInstance().approvedLeave(id);
		if (insertion == true) {
			System.out.println("Leave Approved  Successfully");
		} else {
			System.out.println("Leave Sheet Approved  Fail Try Again");
		}
		
	}
}