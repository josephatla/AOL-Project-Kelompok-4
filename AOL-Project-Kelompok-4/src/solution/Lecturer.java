package solution;

import java.util.Scanner;

public class Lecturer extends Name {
	private String officeAddr;
	private String officeNum;
	private String phoneNum;
	private String email;

	public Lecturer(String fName, String mName, String lName, String officeAddr, String officeNum, String phoneNum,
			String email) {
		super(fName, mName, lName);
		this.officeAddr = officeAddr;
		this.officeNum = officeNum;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	public String getOfficeAddr() {
		return officeAddr;
	}

	public String getOfficeNum() {
		return officeNum;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public static Lecturer createLecturer(Scanner scanner) {
		System.out.println("----------Lecturer's Details----------");
		System.out.print("Name of lecturer (First / Middle / Last): ");
		String first = scanner.next();
		String midd = scanner.next();
		String last = scanner.next();
		scanner.nextLine();

		System.out.print("\nOffice room: ");
		String officeAddr = scanner.nextLine();
		System.out.print("Office number: ");
		String officeNum = scanner.nextLine();
		System.out.print("Lecturer's phone number: ");
		String phoneNum = scanner.nextLine();
		System.out.print("Lecturer's email: ");
		String email = scanner.nextLine();
		System.out.println("Lecturer's details created successfully.");

		return new Lecturer(first, midd, last, officeAddr, officeNum, phoneNum, email);
	}

	public void displayLecturer() {
		System.out.println("Name: " + getfName() + " " + getmName() + " " + getlName());
		System.out.println("Office room: " + this.officeAddr);
		System.out.println("Office number: " + this.officeNum);
		System.out.println("Phone number: " + this.phoneNum);
		System.out.println("Email: " + this.email);
	}
}
