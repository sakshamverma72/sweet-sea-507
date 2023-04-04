package com.masai.UI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.masai.DAO.BusDAO;
import com.masai.DAO.BusDAOImpl;
import com.masai.DTO.Bus;
import com.masai.DTO.BusImpl;
import com.masai.Exception.ExceptionInBus;

public class Admin {

	public static void adminMain(Scanner sc) {
		int choice = 0;

		do {
			System.out.println("1. Add bus ");
			System.out.println("2. Update bus details bus name, bus type and total seats");
			System.out.println("3. Delete bus details ");
			System.out.println("4. View bookings for a date range");
			System.out.println("5. View bookings for a bus name");
			System.out.println("0. Logout");
			choice = sc.nextInt();

			switch (choice) {
			case 0:
				return;
			case 1:
				addBus(sc);
				break;
			case 2:
				updateBusDetails(sc);
				break;
			case 3:
				deleteBusDetails(sc);
				break;
			case 4:
				viewBookingsForADateRange(sc);
				break;
			case 5:
				viewBookingsByBusName(sc);
				break;
			default:
				System.out.println("Invalid entry!");
				break;
			}
		} while (choice != 0);
		sc.close();
	}

	public static void addBus(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter bus name");
		String busName = sc.nextLine();
		System.out.println("Enter source");
		String source = sc.nextLine();
		System.out.println("Enter destination");
		String destination = sc.nextLine();
		System.out.println("Enter bus type AC/Sleeper");
		String bustype = sc.nextLine();
		System.out.println("Enter bus departure time YYYY-MM-DDTHH:MM:SS");
		LocalDateTime departureDateTime = LocalDateTime.parse(sc.nextLine());
		System.out.println("Enter bus arrival time YYYY-MM-DDTHH:MM:SS");
		LocalDateTime arrivalDateTime = LocalDateTime.parse(sc.nextLine());
		System.out.println("Enter total seats");
		int totalSeats = Integer.parseInt(sc.nextLine());

		Bus bus = new BusImpl(0, busName, source, destination, bustype, departureDateTime, arrivalDateTime, totalSeats);

		BusDAO busDAO = new BusDAOImpl();
		try {
			busDAO.addBus(bus);
			System.out.println("Bus added successfully");
		} catch (ExceptionInBus e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteBusDetails(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter bus Id");
		int busId = Integer.parseInt(sc.nextLine());

		BusDAO busDAO = new BusDAOImpl();
		try {
			busDAO.deleteBus(busId);
			System.out.println("Bus Deleted successfully");
		} catch (ExceptionInBus e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateBusDetails(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter bus name");
		String busName = sc.nextLine();

		System.out.println("Enter bus type AC/Sleeper");
		String bustype = sc.nextLine();

		System.out.println("Enter total seats");
		int totalSeats = Integer.parseInt(sc.nextLine());

		System.out.println("Enter bus Id");
		int busId = Integer.parseInt(sc.nextLine());

		Bus bus = new BusImpl(0, busName, null, null, bustype, null, null, totalSeats);

		BusDAO busDAO = new BusDAOImpl();
		try {
			busDAO.updateBus(bus, busId);
			System.out.println("Bus updated successfully");
		} catch (ExceptionInBus e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void viewBookingsForADateRange(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter starting date YYYY-MM-DD");
		LocalDate startingDate = LocalDate.parse(sc.nextLine());
		System.out.println("Enter ending time YYYY-MM-DD ");
		LocalDate endingDate = LocalDate.parse(sc.nextLine());
		System.out.println("Enter total seats");

		BusDAO busDAO = new BusDAOImpl();
		try {
			int n = busDAO.viewBookingsForADateRange(startingDate, endingDate);
			System.out.println("Total " + n + " bookings is in bewtween " + startingDate + " and " + endingDate);
		} catch (ExceptionInBus e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void viewBookingsByBusName(Scanner sc) {
		System.out.println("Enter busname");
		sc.nextLine();
		String busName = sc.nextLine();

		BusDAO busDAO = new BusDAOImpl();
		int n = 0;
		try {
			n = busDAO.viewBookingsByBusName(busName);
			System.out.println("Number of bookings are " + n + " with bus name " + busName);
			System.out.println();
		} catch (ExceptionInBus e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
