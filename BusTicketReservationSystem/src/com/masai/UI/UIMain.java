package com.masai.UI;

import java.util.Scanner;

public class UIMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		starting(sc);
		sc.close();
	}

	public static void starting(Scanner sc) {
		int choice = 0;

		do {
			System.out.println("1. Admin Login ");
			System.out.println("2. Customer Login ");
			System.out.println("3. Customer Signup ");
			System.out.println("0. Exit");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				adminLogin(sc);
				break;
			case 2:
				Passengers.customerLogin(sc);
				break;
			case 3:
				Passengers.customerSignup(sc);
				break;
			case 0:
				System.out.println("Thank you for visiting!");
				break;
			default:
				System.out.println("Invalid choice!");
				break;
			}
		} while (choice != 0);

	}

	public static void adminLogin(Scanner sc) {
		String username = "s";
		String password = "s";
		while (true) {
			System.out.println("Enter username");
			username = sc.next();
			System.out.println("Enter password");
			password = sc.next();
			if (!username.equals("admin") || !password.equals("admin")) {
				System.out.println("Enter correct username password");
			} else {
				Admin.adminMain(sc);
				return;
			}
		}
	}
	
}
