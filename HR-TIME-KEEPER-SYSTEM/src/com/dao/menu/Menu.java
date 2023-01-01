package com.dao.menu;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.factory.ServiceFactory;
import com.operation.CodeExit;
import com.operation.Employee_Add;
import com.operation.Employee_Remove;
import com.operation.Employee_Show;
import com.operation.Employee_Update;
import com.operation.RestartMenu;
import com.vo.Employee;
import com.vo.TimeSheetTable;

public class Menu {
	public void welcomeMenu() {
		System.out.println("\t\t*******************************************");
		System.out.println("\t\t\t  WELCOME TO HR TIMEKEEPER SYSTEM");
		System.out.println("\t\t*******************************************");
		System.out.println("\t\t\t    ");
		System.out.println("\t\t\t    -------WELCOME PAGE--------");

		System.out.println("\n\nPress 1 : ADMIN");
		System.out.println("Press 2 : MANAGER ");
		System.out.println("Press 3 : EMPLOYEE");
		System.out.println("Press 4 : REGISTER");
		System.out.println("Press 5 : EXITS");

	}

	public void loginMenu() {

		Scanner sc = new Scanner(System.in);
		Employee_Show epv = new Employee_Show();

		int i = 0;

		Menu menu = new Menu();

		System.out.println("\t\t*******************************************");
		System.out.println("\t\t\t    -------LOGIN PAGE--------");

		System.out.println("\n\nPress 1 : LOGIN");
		System.out.println("Press 2 : RE-SET-PASSWORD ");
		System.out.println("Press 3 : EXITS");
		System.out.println("Press 4 : RESTART");

		/*** Initialising loop for Menu Choices ***/
		while (i < 5) {
			try {

				System.out.print("\nPlease Enter choice :");
				i = Integer.parseInt(sc.nextLine());

				/** Switch Case Statements **/
				switch (i) {
				case 1: {
					System.out.print("Enter emailId -: ");
					String emailId = sc.nextLine();
					System.out.print("Enter password -: ");
					String password = sc.nextLine();

					Employee employee = ServiceFactory.getIEmployeeServiceInstance()
							.findUserByEmaildAndPassword(emailId, password);
					if (employee != null) {
						System.out.println("***********************************************");
						System.out.println("*************  User Login Succesfully  ************");
						System.out.println("***************************************************");
						System.out
								.println("************  USER : " + employee.getName().toUpperCase() + " ************");
						String role = ServiceFactory.getIEmployeeServiceInstance().findUserRoleByEmaild(emailId);
						if (role.equalsIgnoreCase("ADMIN")) {
							menu.AdminMenu();
						} else if (role.equalsIgnoreCase("TESTER")) {
							menu.employeeMenu("TESTER");
						} else if (role.equalsIgnoreCase("DEVELOPER")) {
							menu.employeeMenu("DEVELOPER");
						} else if (role.equalsIgnoreCase("MANAGER")) {
							menu.ManagerMenu();
						} else if (role.equalsIgnoreCase("DESIGNER")) {
							menu.employeeMenu("DESIGNER");
						}
						System.out.print("\nPress Enter to Continue...");
						sc.nextLine();
						menu.loginMenu();
						break;
					} else {
						System.out.println("*************  User Login Fail Please Try Again  ************");
						System.out.print("\nPress Enter to Continue...");
						sc.nextLine();
						menu.loginMenu();
						break;
					}

				}
				case 2: {
					System.out.print("\nPlease Enter EmailId ID :");
					String EmailId = sc.next();

					Employee_Update epu = new Employee_Update();

					epu.resetPassword(EmailId);

					System.out.print("\nPress Enter to Continue...");
					sc.nextLine();
					menu.loginMenu();
					break;
				}

				case 3: {
					CodeExit obj = new CodeExit();
					obj.out();
				}
				case 4: {
					RestartMenu restartMenu = new RestartMenu();
					restartMenu.restart();
				}
				}
			} catch (Exception e) {
				System.out.println("************* Worong Input Fail Please Try Again ************");
				menu.loginMenu();
				;
			}
		}

	}

	public void AdminMenu() throws Exception {

		Scanner sc = new Scanner(System.in);
		Employee_Show epv = new Employee_Show();

		int i = 0;

		Menu menu = new Menu();
		System.out.println("\t\t*******************************************");
		System.out.println("\t\t\t    ------- Function Menu ------------");
		System.out.println("\n\nPress 1 : To Add an Employee Details");
		System.out.println("Press 2 : To See an Employee Details ");
		System.out.println("Press 3 : To Remove an Employee");
		System.out.println("Press 4 : To Update Employee Details");
		System.out.println("Press 5 : To Show All Employee Details");

		System.out.println("Press 6 : To view report hour work");
		System.out.println("Press 7 : To view report leave");
		System.out.println("Press 8 : To view salary");
		System.out.println("Press 9 : To list of request draft Time Sheet");
		System.out.println("Press 10 : To Approved draft Time Sheet");
		
		System.out.println("Press 11 : To Approved leave Time Sheet");

		System.out.println("Press 12 : To Exit From HR TIMEKEEPER SYSTEM Portal");
		System.out.println("Press 13 : To RESTART");

		/*** Callining Mainmenu Class function ****/

		/*** Initialising loop for Menu Choices ***/
		while (i < 14) {
			try {

				System.out.print("\nPlease Enter choice :");
				i = Integer.parseInt(sc.nextLine());

				/** Switch Case Statements **/
				switch (i) {
				case 1: {
					/** Creating class's object and calling Function using that object **/
					Employee_Add ep = new Employee_Add();
					ep.addEmp();

					menu.AdminMenu();
					break;
				}
				case 2: {
					System.out.print("\nPlease Enter Employee's ID :");
					int s = sc.nextInt();
					try {
						epv.viewEmp(s);
					} catch (Exception e) {
						System.out.println(e);
					}

					System.out.print("\nPress Enter to Continue...");
					sc.nextLine();
					menu.AdminMenu();
					break;
				}

				case 3: {
					System.out.print("\nPlease Enter Employee's ID :");
					int s = sc.nextInt();
					Employee_Remove epr = new Employee_Remove();
					epr.removeFile(s);

					System.out.print("\nPress Enter to Continue...");
					sc.nextLine();
					menu.AdminMenu();
					;
					break;
				}
				case 4: {
					System.out.print("\nPlease Enter Employee's ID :");
					int empId = sc.nextInt();
					try {
						epv.viewEmp(empId);
					} catch (Exception e) {
						System.out.println(e);
					}
					Employee_Update epu = new Employee_Update();

					try {
						epu.updateEmp(empId);

						System.out.print("\nPress Enter to Continue...");
						sc.nextLine();
						menu.AdminMenu();
						;
						break;
					} catch (IOException e) {
						System.out.println(e);
					}
				}

				case 5: {
					try {
						epv.listAllEmployees();
						System.out.print("\nPress Enter to Continue...");
						sc.nextLine();
						menu.AdminMenu();
					} catch (Exception e) {
						System.out.println(e);
					}
				}

				case 6: {
					/** To view report hour work **/
					System.out.print("\nPlease Enter Employee's ID :");
					int s = sc.nextInt();
					float totalhr = 0;
					String employeeName = "";
					try {
						List<TimeSheetTable> timeSheetTableList = epv.findListTimeSheetTableByEid(s);
						if (timeSheetTableList != null) {
							if (!timeSheetTableList.isEmpty()) {
								System.out.println("view report hour work :");
								System.out.println("                         ");
								System.out.println(" DATE      :     HR         ");
								for (TimeSheetTable tlist : timeSheetTableList) {
									employeeName = tlist.getName();
									if (tlist.getLeave_status().equalsIgnoreCase("N")) {
										System.out
												.println(tlist.getWorkingDate() + " : " + tlist.getTotal_hr_per_day());
										totalhr = totalhr + tlist.getTotal_hr_per_day();
									}
								}
							} else {
								System.out.println("\n data empty");
							}
						} else {
							System.out.print("\n data null");
						}
					} catch (Exception e) {
						System.out.println(e);
					}

					System.out.println("Employee Name : " + employeeName);
					System.out.println("Total Working Hr:" + totalhr);
					System.out.print("\nPress Enter to Continue...");
					sc.nextLine();
					menu.AdminMenu();
					break;
				}
				case 7: {
					/** To See an view leave report Employee Details **/
					System.out.print("\nPlease Enter Employee's ID :");
					int s = sc.nextInt();
					float leave = 0;
					String employeeName = "";
					try {
						List<TimeSheetTable> timeSheetTableList = epv.findListTimeSheetTableByEid(s);
						if (timeSheetTableList != null) {
							if (!timeSheetTableList.isEmpty()) {
								System.out.println("view leave status :");
								for (TimeSheetTable tlist : timeSheetTableList) {
									employeeName = tlist.getName();

									System.out.println("                     ");
									System.out.println(" DATE      : LEAVE_STATUS         ");
									System.out.println(
											tlist.getWorkingDate() + " :    " + tlist.getLeave_status().toUpperCase());
									if (tlist.getLeave_status().equalsIgnoreCase("Y")) {
										leave = leave + 1;
									}
								}
							} else {
								System.out.println("\n data empty");
							}
						} else {
							System.out.print("\n data null");
						}
					} catch (Exception e) {
						System.out.println(e);
					}
					System.out.println("Employee Name : " + employeeName);
					System.out.println("Total leave days :" + leave + " days");
					System.out.print("\nPress Enter to Continue...");
					sc.nextLine();
					menu.AdminMenu();
					break;
				}
				case 8: {
					/** To See an Employee view salary Details **/
					System.out.print("\nPlease Enter Employee's ID :");
					int s = sc.nextInt();
					float totalhr = 0;
					float leave = 0;
					float total_salary = 0;
					float total_working_days = 0;
					String employeeName = "";
					try {
						List<TimeSheetTable> timeSheetTableList = epv.findListTimeSheetTableByEid(s);
						if (timeSheetTableList != null) {
							if (!timeSheetTableList.isEmpty()) {
								System.out.println("view report hour work :");
								System.out.println("                         ");
								System.out.println(" DATE      : HOUR : PER DAY SALARY    ");
								for (TimeSheetTable tlist : timeSheetTableList) {
									employeeName = tlist.getName();
									if (tlist.getLeave_status().equalsIgnoreCase("N")) {

										System.out.println(tlist.getWorkingDate() + " : " + tlist.getTotal_hr_per_day()
												+ " :     " + tlist.getPer_day_salary() + " INR");
										totalhr = totalhr + tlist.getTotal_hr_per_day();
										total_salary = total_salary + tlist.getPer_day_salary();
										total_working_days = total_working_days + 1;
									} else {

										leave = leave + 1;

									}
								}
							} else {
								System.out.println("\n data empty");
							}
						} else {
							System.out.print("\n data null");
						}
					} catch (Exception e) {
						System.out.println(e);
					}
					System.out.println("Employee Name : " + employeeName);
					System.out.println("Total Working Hour :" + totalhr + " Hour");

					System.out.println("Total total working  days  :" + total_working_days + " days");
					System.out.println("Total leave days  :" + leave + " days");
					System.out.println("Total salary till date  :" + total_salary + " INR");
					System.out.print("\nPress Enter to Continue...");
					sc.nextLine();
					menu.AdminMenu();
					break;
				}

				case 9: {

					/** To time sheet DRAFT REQUEST **/
					try {
						List<TimeSheetTable> timeSheetTableList = epv.findAllListTimeSheetTableByEid();
						if (timeSheetTableList != null) {
							if (!timeSheetTableList.isEmpty()) {
								System.out.println("view  time sheet request report :");
								System.out.println("                         ");
								System.out.println(" DATE      : HOUR : PER DAY SALARY    ");
								for (TimeSheetTable tlist : timeSheetTableList) {
									if (tlist.getTime_sheet_status().equalsIgnoreCase("draft")) {

										System.out.println("DRAFT LIST : " + tlist);
									}
								}
							} else {
								System.out.println("\n data empty");
							}
						} else {
							System.out.print("\n data null");
						}
					} catch (Exception e) {
						System.out.println(e);
					}
					System.out.print("\nPress Enter to Continue...");
					sc.nextLine();
					menu.AdminMenu();
					break;
				}

				case 10: {

					/** To time sheet DRAFT approved **/
					try {
						System.out.print("\nPlease Enter time sheet ID :");

						int id = sc.nextInt();

						Employee_Update epu = new Employee_Update();

						epu.approvedTimeSheet(id);

						System.out.print("\nPress Enter to Continue...");
						sc.nextLine();
						menu.AdminMenu();
						break;

					} catch (Exception e) {
						System.out.println("************* Worong Input Fail Please Try Again ************");
						menu.AdminMenu();
					}
				}
				
				case 11: {

					/** To leave approved **/
					try {
						System.out.print("\nPlease Enter time sheet ID :");

						int id = sc.nextInt();

						Employee_Update epu = new Employee_Update();

						epu.approvedLeave(id);

						System.out.print("\nPress Enter to Continue...");
						sc.nextLine();
						menu.AdminMenu();
						break;

					} catch (Exception e) {
						System.out.println("************* Worong Input Fail Please Try Again ************");
						menu.AdminMenu();
					}
				}
				
				
				case 12: {
					CodeExit obj = new CodeExit();
					obj.out();
				}
				case 13: {
					RestartMenu restartMenu = new RestartMenu();
					restartMenu.restart();
				}
				}
			} catch (Exception e) {
				System.out.println("************* Worong Input Fail Please Try Again ************");
				menu.AdminMenu();
			}
		}

	}

	public void employeeMenu(String role) throws Exception {

		Scanner sc = new Scanner(System.in);
		Employee_Show epv = new Employee_Show();

		int i = 0;

		Menu menu = new Menu();
		System.out.println("\t\t\t    ------- Employee Menu ------------");
		System.out.println("Press 1 : To See an Employee Details ");
		System.out.println("Press 2 : To Update Employee Details");
		System.out.println("Press 3 : To view report hour work");
		System.out.println("Press 4 : To view report leave");
		System.out.println("Press 5 : To view salary");
		System.out.println("Press 6 : To submit salary ");
		System.out.println("Press 7 : To Exit From HR TIMEKEEPER SYSTEM Portal");
		System.out.println("Press 8 : To RESTART");

		/*** Initialising loop for Menu Choices ***/
		while (i < 9) {
			try {

				System.out.print("\nPlease Enter choice :");
				i = Integer.parseInt(sc.nextLine());

				/** Switch Case Statements **/
				switch (i) {
				case 1: {
					/** To See an Employee Details **/
					System.out.print("\nPlease Enter Employee's ID :");
					int s = sc.nextInt();
					try {
						epv.viewEmp(s);
					} catch (Exception e) {
						System.out.println(e);
					}

					System.out.print("\nPress Enter to Continue...");
					sc.nextLine();
					menu.employeeMenu(role);
					break;
				}

				case 2: {
					/** To Update Employee Details **/
					System.out.print("\nPlease Enter Employee's ID :");
					int empId = sc.nextInt();
					try {
						epv.viewEmp(empId);
					} catch (Exception e) {
						menu.employeeMenu(role);
						break;
					}
					Employee_Update epu = new Employee_Update();

					try {
						epu.updateEmp(empId);

						System.out.print("\nPress Enter to Continue...");
						sc.nextLine();
						menu.employeeMenu(role);
						break;
					} catch (IOException e) {
						menu.employeeMenu(role);
						break;
					}
				}
				case 3: {
					/** To view report hour work **/
					System.out.print("\nPlease Enter Employee's ID :");
					int s = sc.nextInt();
					float totalhr = 0;
					String employeeName = "";
					try {
						List<TimeSheetTable> timeSheetTableList = epv.findListTimeSheetTableByEid(s);
						if (timeSheetTableList != null) {
							if (!timeSheetTableList.isEmpty()) {
								System.out.println("view report hour work :");
								System.out.println("                         ");
								System.out.println(" DATE      :     HR         ");
								for (TimeSheetTable tlist : timeSheetTableList) {
									employeeName = tlist.getName();
									if (tlist.getLeave_status().equalsIgnoreCase("N")) {
										System.out
												.println(tlist.getWorkingDate() + " : " + tlist.getTotal_hr_per_day());
										totalhr = totalhr + tlist.getTotal_hr_per_day();
									}
								}
							} else {
								System.out.println("\n data empty");
							}
						} else {
							System.out.print("\n data null");
						}
					} catch (Exception e) {
						System.out.println(e);
					}
					System.out.println("Employee Name : " + employeeName);
					System.out.println("Total Working Hr:" + totalhr);
					System.out.print("\nPress Enter to Continue...");
					sc.nextLine();
					menu.employeeMenu(role);
					break;
				}
				case 4: {
					/** To See an view leave report Employee Details **/
					System.out.print("\nPlease Enter Employee's ID :");
					int s = sc.nextInt();
					float leave = 0;
					String employeeName = "";
					try {
						List<TimeSheetTable> timeSheetTableList = epv.findListTimeSheetTableByEid(s);
						if (timeSheetTableList != null) {
							if (!timeSheetTableList.isEmpty()) {
								System.out.println("view leave status :");
								for (TimeSheetTable tlist : timeSheetTableList) {
									employeeName = tlist.getName();

									System.out.println("                     ");
									System.out.println(" DATE      : LEAVE_STATUS         ");
									System.out.println(
											tlist.getWorkingDate() + " :    " + tlist.getLeave_status().toUpperCase());
									if (tlist.getLeave_status().equalsIgnoreCase("Y")) {
										leave = leave + 1;
									}
								}
							} else {
								System.out.println("\n data empty");
							}
						} else {
							System.out.print("\n data null");
						}
					} catch (Exception e) {
						System.out.println(e);
					}
					System.out.println("Employee Name : " + employeeName);
					System.out.println("Total leave days :" + leave + " days");
					System.out.print("\nPress Enter to Continue...");
					sc.nextLine();
					menu.employeeMenu(role);
					break;
				}
				case 5: {
					/** To See an Employee salary Details **/
					System.out.print("\nPlease Enter Employee's ID :");
					int s = sc.nextInt();
					float totalhr = 0;
					float leave = 0;
					float total_salary = 0;
					float total_working_days = 0;
					String employeeName = "";
					try {
						List<TimeSheetTable> timeSheetTableList = epv.findListTimeSheetTableByEid(s);
						if (timeSheetTableList != null) {
							if (!timeSheetTableList.isEmpty()) {
								System.out.println("view report hour work :");
								System.out.println("                         ");
								System.out.println(" DATE      : HOUR : PER DAY SALARY    ");
								for (TimeSheetTable tlist : timeSheetTableList) {
									employeeName = tlist.getName();
									if (tlist.getLeave_status().equalsIgnoreCase("N")) {

										System.out.println(tlist.getWorkingDate() + " : " + tlist.getTotal_hr_per_day()
												+ " :     " + tlist.getPer_day_salary() + " INR");
										totalhr = totalhr + tlist.getTotal_hr_per_day();
										total_salary = total_salary + tlist.getPer_day_salary();
										total_working_days = total_working_days + 1;
									} else {

										leave = leave + 1;

									}
								}
							} else {
								System.out.println("\n data empty");
							}
						} else {
							System.out.print("\n data null");
						}
					} catch (Exception e) {
						System.out.println(e);
					}
					System.out.println("Employee Name : " + employeeName);
					System.out.println("Total Working Hour :" + totalhr + " Hour");

					System.out.println("Total total working  days  :" + total_working_days + " days");
					System.out.println("Total leave days  :" + leave + " days");
					System.out.println("Total salary till date  :" + total_salary + " INR");
					System.out.print("\nPress Enter to Continue...");
					sc.nextLine();
					menu.employeeMenu(role);
					break;
				}
				case 6: {
					/** To submit salary **/

					try {
						Employee_Add ep = new Employee_Add();
						ep.submit(role);
						System.out.print("\nPress Enter to Continue...");
						sc.nextLine();
						menu.employeeMenu(role);
						break;
					} catch (Exception e) {
						System.out.println("************* Worong Input Fail Please Try Again ************");
						System.out.print("\nPress Enter to Continue...");
						sc.nextLine();
						menu.employeeMenu(role);
						break;
					}
				}

				case 7: {
					CodeExit obj = new CodeExit();
					obj.out();
				}
				case 8: {
					RestartMenu restartMenu = new RestartMenu();
					restartMenu.restart();
				}
				}
			} catch (Exception e) {
				System.out.println("************* Worong Input Fail Please Try Again ************");
				System.out.print("\nPress Enter to Continue...");
				sc.nextLine();
				menu.employeeMenu(role);
				break;
			}
		}

	}

	public void ManagerMenu() throws Exception {

		Scanner sc = new Scanner(System.in);
		Employee_Show epv = new Employee_Show();

		int i = 0;

		Menu menu = new Menu();
		System.out.println("\t\t*******************************************");
		System.out.println("\t\t\t    ------- Function Menu ------------");
		System.out.println("\n\nPress 1 : To Add an Employee Details");
		System.out.println("Press 2 : To See an Employee Details ");
		System.out.println("Press 3 : To Remove an Employee");
		System.out.println("Press 4 : To Update Employee Details");
		System.out.println("Press 5 : To Show All Employee Details");

		System.out.println("Press 6 : To view report hour work");
		System.out.println("Press 7 : To view report leave");
		System.out.println("Press 8 : To view salary");

		System.out.println("Press 9 : To view all report hour work");
		System.out.println("Press 10 : To view all employee salary report");

		System.out.println("Press 11 : To Exit From HR TIMEKEEPER SYSTEM Portal");
		System.out.println("Press 12 : To RESTART");

		/*** Callining Mainmenu Class function ****/

		/*** Initialising loop for Menu Choices ***/
		while (i < 13) {
			try {

				System.out.print("\nPlease Enter choice :");
				i = Integer.parseInt(sc.nextLine());

				/** Switch Case Statements **/
				switch (i) {
				case 1: {
					/** Creating class's object and calling Function using that object **/
					Employee_Add ep = new Employee_Add();
					ep.addEmp();

					menu.ManagerMenu();
					break;
				}
				case 2: {
					System.out.print("\nPlease Enter Employee's ID :");
					int s = sc.nextInt();
					try {
						epv.viewEmp(s);
					} catch (Exception e) {
						System.out.println(e);
					}

					System.out.print("\nPress Enter to Continue...");
					sc.nextLine();
					menu.ManagerMenu();
					break;
				}

				case 3: {
					System.out.print("\nPlease Enter Employee's ID :");
					int s = sc.nextInt();
					Employee_Remove epr = new Employee_Remove();
					epr.removeFile(s);

					System.out.print("\nPress Enter to Continue...");
					sc.nextLine();
					menu.ManagerMenu();
					;
					break;
				}
				case 4: {
					System.out.print("\nPlease Enter Employee's ID :");
					int empId = sc.nextInt();
					try {
						epv.viewEmp(empId);
					} catch (Exception e) {
						System.out.println(e);
					}
					Employee_Update epu = new Employee_Update();

					try {
						epu.updateEmp(empId);

						System.out.print("\nPress Enter to Continue...");
						sc.nextLine();
						menu.ManagerMenu();
						;
						break;
					} catch (IOException e) {
						System.out.println(e);
					}
				}

				case 5: {
					try {
						epv.listAllEmployees();
						System.out.print("\nPress Enter to Continue...");
						sc.nextLine();
						menu.ManagerMenu();
					} catch (Exception e) {
						System.out.println(e);
					}
				}

				case 6: {
					/** To view report hour work **/
					System.out.print("\nPlease Enter Employee's ID :");
					int s = sc.nextInt();
					float totalhr = 0;
					String employeeName = "";
					try {
						List<TimeSheetTable> timeSheetTableList = epv.findListTimeSheetTableByEid(s);
						if (timeSheetTableList != null) {
							if (!timeSheetTableList.isEmpty()) {
								System.out.println("view report hour work :");
								System.out.println("                         ");
								System.out.println(" DATE      :     HR         ");
								for (TimeSheetTable tlist : timeSheetTableList) {
									employeeName = tlist.getName();
									if (tlist.getLeave_status().equalsIgnoreCase("N")) {
										System.out
												.println(tlist.getWorkingDate() + " : " + tlist.getTotal_hr_per_day());
										totalhr = totalhr + tlist.getTotal_hr_per_day();
									}
								}
							} else {
								System.out.println("\n data empty");
							}
						} else {
							System.out.print("\n data null");
						}
					} catch (Exception e) {
						System.out.println(e);
					}

					System.out.println("Employee Name : " + employeeName);
					System.out.println("Total Working Hr:" + totalhr);
					System.out.print("\nPress Enter to Continue...");
					sc.nextLine();
					menu.ManagerMenu();
					break;
				}
				case 7: {
					/** To See an view leave report Employee Details **/
					System.out.print("\nPlease Enter Employee's ID :");
					int s = sc.nextInt();
					float leave = 0;
					String employeeName = "";
					try {
						List<TimeSheetTable> timeSheetTableList = epv.findListTimeSheetTableByEid(s);
						if (timeSheetTableList != null) {
							if (!timeSheetTableList.isEmpty()) {
								System.out.println("view leave status :");
								for (TimeSheetTable tlist : timeSheetTableList) {
									employeeName = tlist.getName();

									System.out.println("                     ");
									System.out.println(" DATE      : LEAVE_STATUS         ");
									System.out.println(
											tlist.getWorkingDate() + " :    " + tlist.getLeave_status().toUpperCase());
									if (tlist.getLeave_status().equalsIgnoreCase("Y")) {
										leave = leave + 1;
									}
								}
							} else {
								System.out.println("\n data empty");
							}
						} else {
							System.out.print("\n data null");
						}
					} catch (Exception e) {
						System.out.println(e);
					}
					System.out.println("Employee Name : " + employeeName);
					System.out.println("Total leave days :" + leave + " days");
					System.out.print("\nPress Enter to Continue...");
					sc.nextLine();
					menu.ManagerMenu();
					break;
				}
				case 8: {
					/** To See an Employee salary Details **/
					System.out.print("\nPlease Enter Employee's ID :");
					int s = sc.nextInt();
					float totalhr = 0;
					float leave = 0;
					float total_salary = 0;
					float total_working_days = 0;
					String employeeName = "";
					try {
						List<TimeSheetTable> timeSheetTableList = epv.findListTimeSheetTableByEid(s);
						if (timeSheetTableList != null) {
							if (!timeSheetTableList.isEmpty()) {
								System.out.println("view report hour work :");
								System.out.println("                         ");
								System.out.println(" DATE      : HOUR : PER DAY SALARY    ");
								for (TimeSheetTable tlist : timeSheetTableList) {
									employeeName = tlist.getName();
									if (tlist.getLeave_status().equalsIgnoreCase("N")) {

										System.out.println(tlist.getWorkingDate() + " : " + tlist.getTotal_hr_per_day()
												+ " :     " + tlist.getPer_day_salary() + " INR");
										totalhr = totalhr + tlist.getTotal_hr_per_day();
										total_salary = total_salary + tlist.getPer_day_salary();
										total_working_days = total_working_days + 1;
									} else {

										leave = leave + 1;

									}
								}
							} else {
								System.out.println("\n data empty");
							}
						} else {
							System.out.print("\n data null");
						}
					} catch (Exception e) {
						System.out.println(e);
					}
					System.out.println("Employee Name : " + employeeName);
					System.out.println("Total Working Hour :" + totalhr + " Hour");

					System.out.println("Total total working  days  :" + total_working_days + " days");
					System.out.println("Total leave days  :" + leave + " days");
					System.out.println("Total salary till date  :" + total_salary + " INR");
					System.out.print("\nPress Enter to Continue...");
					sc.nextLine();
					menu.ManagerMenu();
					break;
				}

				case 9: {
					/** approved time sheet **/

					try {
						List<TimeSheetTable> timeSheetTableList = epv.findAllListTimeSheetTableByEid();
						if (timeSheetTableList != null) {
							if (!timeSheetTableList.isEmpty()) {

								for (TimeSheetTable tlist : timeSheetTableList) {
									String employeeName = "";
									float totalhr = 0;
									float leave = 0;
									float total_salary = 0;
									float total_working_days = 0;
									List<TimeSheetTable> singletimeSheetTableList = epv
											.findListTimeSheetTableByEid(tlist.getEid());
									for (TimeSheetTable timeSheetTable : singletimeSheetTableList) {
										employeeName = timeSheetTable.getName();
										if (timeSheetTable.getLeave_status().equalsIgnoreCase("N")) {
											totalhr = totalhr + timeSheetTable.getTotal_hr_per_day();
											total_salary = total_salary + timeSheetTable.getPer_day_salary();
											total_working_days = total_working_days + 1;
										} else {

											leave = leave + 1;

										}
									}
									System.out.println("Employee Name : " + employeeName);
									System.out.println("view report hour work :");
									System.out.println("                         ");
									System.out.println(" DATE      : HOUR : PER DAY SALARY    ");
									System.out.println(" ======================================");
									System.out.println("Total Working Hour :" + totalhr + " Hour");

									System.out.println("Total total working  days  :" + total_working_days + " days");
									System.out.println("Total leave days  :" + leave + " days");
									System.out.println("Total salary till date  :" + total_salary + " INR");
								}
							} else {
								System.out.println("\n data empty");
							}
						} else {
							System.out.print("\n data null");
						}
					} catch (Exception e) {
						System.out.println(e);
					}

					System.out.print("\nPress Enter to Continue...");
					sc.nextLine();
					menu.ManagerMenu();
					break;
				}
				case 10: {
					/** To See an to view all report hour work **/

					try {
						List<TimeSheetTable> timeSheetTableList = epv.findAllListTimeSheetTableByEid();
						if (timeSheetTableList != null) {
							if (!timeSheetTableList.isEmpty()) {

								for (TimeSheetTable tlist : timeSheetTableList) {
									String employeeName = "";
									float totalhr = 0;
									float leave = 0;
									float total_salary = 0;
									float total_working_days = 0;
									List<TimeSheetTable> singletimeSheetTableList = epv
											.findListTimeSheetTableByEid(tlist.getEid());
									for (TimeSheetTable timeSheetTable : singletimeSheetTableList) {
										employeeName = timeSheetTable.getName();
										if (timeSheetTable.getLeave_status().equalsIgnoreCase("N")) {

											totalhr = totalhr + timeSheetTable.getTotal_hr_per_day();
											total_salary = total_salary + timeSheetTable.getPer_day_salary();
											total_working_days = total_working_days + 1;
										} else {

											leave = leave + 1;

										}
									}
									System.out.println("Employee Name : " + employeeName);
									System.out.println("view report hour work :");
									System.out.println("                         ");
									System.out.println(" DATE      : HOUR : PER DAY SALARY    ");
									System.out.println(" ======================================");
									System.out.println("Total Working Hour :" + totalhr + " Hour");

									System.out.println("Total total working  days  :" + total_working_days + " days");
									System.out.println("Total leave days  :" + leave + " days");
									System.out.println("Total salary till date  :" + total_salary + " INR");
								}
							} else {
								System.out.println("\n data empty");
							}
						} else {
							System.out.print("\n data null");
						}
					} catch (Exception e) {
						System.out.println(e);
					}

					System.out.print("\nPress Enter to Continue...");
					sc.nextLine();
					menu.ManagerMenu();
					break;
				}

				case 11: {
					CodeExit obj = new CodeExit();
					obj.out();
				}
				case 12: {
					RestartMenu restartMenu = new RestartMenu();
					restartMenu.restart();
				}
				}
			} catch (Exception e) {
				System.out.println("************* Worong Input Fail Please Try Again ************");
				menu.welcomeMenu();
			}
		}

	}
}
