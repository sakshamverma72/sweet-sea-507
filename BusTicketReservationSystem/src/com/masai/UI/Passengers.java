package com.masai.UI;

import java.util.List;
import java.util.Scanner;

import com.masai.DAO.PassengersBusDAO;
import com.masai.DAO.PassengersBusDAOImpl;
import com.masai.DTO.Bus;
import com.masai.DTO.Customer;
import com.masai.DTO.CustomerImpl;
import com.masai.Exception.ExceptionInPassengers;

public class Passengers {

	public static void customerSignup(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter passenger Id");
		String id = sc.nextLine();
		System.out.println("Enter name");
		String name = sc.nextLine();
		System.out.println("Enter username");
		String username = sc.nextLine();
		System.out.println("Enter password");
		String password = sc.nextLine();
		System.out.println("Enter mobile number");
		String mobile = sc.nextLine();

		Customer customer = new CustomerImpl(id, name, username, password, mobile);

		PassengersBusDAO passengersBus = new PassengersBusDAOImpl();
		try {
			passengersBus.addPassengers(customer);
			System.out.println("Customer with name " + name + " added successfully.");
			System.out.println();
		} catch (ExceptionInPassengers e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void customerLogin(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter username");
		String username = sc.nextLine();
		System.out.println("Enter password");
		String password = sc.nextLine();

		Customer customer = new CustomerImpl(null, null, username, password, null);

		PassengersBusDAO passengersBus = new PassengersBusDAOImpl();
		try {
			if (!passengersBus.loginPassengers(customer)) {
				System.out.println("Invalid Username or password");
			} else {
				System.out.println("Login Successfully!");
				System.out.println();
				menu(sc);
			}
		} catch (ExceptionInPassengers e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void menu(Scanner sc) {
		int choice = 0;

		do {
			System.out.println("1. Show available buses");
			System.out.println("2. Book Ticket by bus number");
			System.out.println("3. Change profile");
			System.out.println("4. Booking history");
			System.out.println("5. Delete account");
			System.out.println("0. Logout");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				showAvailableBuse();
				break;
			case 2:
				bookTicketByBussNumber(sc);
				break;
			case 3:
				changeProfile(sc);
				break;
			case 4:
				bookingHistory();
				break;
			case 5 : deleteAccount(sc);
			case 0:
				CustomerLogin.passengerId = 0;
				return;
			default:
				System.out.println("Invalid choice!");
				break;
			}
		} while (choice != 0);

	}

	public static void showAvailableBuse() {

		PassengersBusDAO passengersBus = new PassengersBusDAOImpl();
		try {
			List<Bus> list = passengersBus.showAvailableBuse();
			if (list == null) {
				System.out.println("No bus available");
			} else {
				System.out.println(list);
			}

		} catch (ExceptionInPassengers e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void bookTicketByBussNumber(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter bus number");
		int busId = Integer.parseInt(sc.nextLine());

		PassengersBusDAO passengersBus = new PassengersBusDAOImpl();
		try {
			passengersBus.bookTicketByBussNumber(busId);
			System.out.println("Ticket booked successfully!");

		} catch (ExceptionInPassengers e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void changeProfile(Scanner sc) {
		sc.nextLine();
		int choice = 0;

		do {
			System.out.println("1. Change name");
			System.out.println("2. Change Username");
			System.out.println("3. Change password");
			System.out.println("4. Change mobile number");
			System.out.println("0. Exit");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				Profile.changeName(sc);
				break;
			case 2:
				Profile.changeUserName(sc);
				break;
			case 3:
				Profile.changePassword(sc);
				break;
			case 4:
				Profile.changeMobile(sc);
				break;
			case 0:
				return;
			default:
				System.out.println("Invalid choice!");
				break;
			}
		} while (choice != 0);
	}

	public static void bookingHistory() {
		PassengersBusDAO passengersBus = new PassengersBusDAOImpl();
		try {
			List<Bus> list = passengersBus.bookingHistory();

			for (Bus bus : list) {
				System.out.println("Bus Number = " + bus.getBusId() + " Busname = " + bus.getBusname() + ", Source = "
						+ bus.getSource() + ", Destination = " + bus.getDestination() + ", Departure Time = "
						+ bus.getDepartureTime() + ", Arrival Time = " + bus.getArrivalTime());
			}

		} catch (ExceptionInPassengers e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void deleteAccount(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter previous password");
		String oldPassword = sc.nextLine();
		PassengersBusDAO passengersBus = new PassengersBusDAOImpl();
		try {
			passengersBus.deleteAccount(oldPassword);
			System.out.println("Account deleted successfully!");

		} catch (ExceptionInPassengers e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
