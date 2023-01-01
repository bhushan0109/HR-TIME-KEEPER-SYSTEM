package com.operation;

import java.util.Scanner;

import com.dao.menu.Menu;

public class RestartMenu {

	public void restart() {

		Scanner sc = new Scanner(System.in);

		int i = 0;

		Menu menu = new Menu();
		menu.welcomeMenu();
		/*** Initialising loop for loginMenu Menu Choices ***/
		while (i < 6) {
			try {
				System.out.print("\nPlease Enter choice :");
				i = Integer.parseInt(sc.nextLine());

				/** Switch Case Statements **/
				switch (i) {
				case 1: {
					menu.loginMenu();
					menu.welcomeMenu();
					break;
				}
				case 2: {
					menu.loginMenu();
					menu.welcomeMenu();
					break;

				}

				case 3: {
					menu.loginMenu();
					menu.welcomeMenu();
					break;
				}
				case 4: {
					Employee_Add ep = new Employee_Add();
					ep.addEmp();
					menu.welcomeMenu();
					break;

				}
				case 5: {
					CodeExit obj = new CodeExit();
					obj.out();
				}

				}
			} catch (Exception e) {
				System.out.println("************* Worong Input Fail Please Try Again ************");
				menu.welcomeMenu();
			}
		}
	}
}
