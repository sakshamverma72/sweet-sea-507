package com.masai.UI;

import java.util.Scanner;

import com.masai.DAO.ProfileDAO;
import com.masai.DAO.ProfileDAOImpl;
import com.masai.Exception.UnableToEditProfile;

public class Profile {
public static void changeName(Scanner sc) {
	sc.nextLine();
	System.out.println("Enter new name");
	String name = sc.nextLine();
	ProfileDAO profile = new ProfileDAOImpl();
	try {
		profile.changeName(name);
		System.out.println("Name updated successfully");
	} catch (UnableToEditProfile e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void changeUserName(Scanner sc) {
	sc.nextLine();
	System.out.println("Enter new username");
	String username = sc.nextLine();
	ProfileDAO profile = new ProfileDAOImpl();
	try {
		profile.changeUserName(username);
		System.out.println("Username updated successfully");
	} catch (UnableToEditProfile e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void changeMobile(Scanner sc) {
	sc.nextLine();
	System.out.println("Enter new mobile number");
	String mobile = sc.nextLine();
	ProfileDAO profile = new ProfileDAOImpl();
	try {
		profile.changeMobile(mobile);
		System.out.println("Mobile number updated successfully");
	} catch (UnableToEditProfile e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void changePassword(Scanner sc) {
	sc.nextLine();
	System.out.println("Enter previous password");
	String oldPassword = sc.nextLine();
	System.out.println("Enter new password");
	String newPassword = sc.nextLine();
	ProfileDAO profile = new ProfileDAOImpl();
	try {
		profile.changePassword(oldPassword, newPassword);
		System.out.println("Pssword updated successfully");
	} catch (UnableToEditProfile e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


}
