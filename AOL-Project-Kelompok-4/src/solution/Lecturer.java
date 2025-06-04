package solution;

import java.util.Scanner;

public class Lecturer extends Name {
    private String officeAddr;
    private String officeNum;
    private String phoneNum;
    private String email;

    public Lecturer(String fName, String mName, String lName, String officeAddr, String officeNum, String phoneNum, String email) {
        super(fName, mName, lName);
        this.officeAddr = officeAddr;
        this.officeNum = officeNum;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public String getOfficeAddr() {
        return officeAddr;
    }

    public void setOfficeAddr(String officeAddr) {
        this.officeAddr = officeAddr;
    }

    public String getOfficeNum() {
        return officeNum;
    }

    public void setOfficeNum(String officeNum) {
        this.officeNum = officeNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void createLecturer() {
        System.out.println("----------Lecturer's Details----------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of lecturer (First / Middle / Last): ");
        String first = scanner.next();
        this.setfName(first);
        String midd = scanner.next();
        this.setmName(midd);
        String last = scanner.next();
        this.setlName(last);
        scanner.nextLine();
        System.out.print("\nOffice room: ");
        String officeAddr = scanner.nextLine();
        setOfficeAddr(officeAddr);
        System.out.print("Office number: ");
        String officeNum = scanner.nextLine();
        setOfficeNum(officeNum);
        System.out.print("Lecturer's phone number: ");
        String phoneNum = scanner.nextLine();
        setPhoneNum(phoneNum);
        System.out.print("Lecturer's email: ");
        String email = scanner.nextLine();
        setEmail(email);
        System.out.println("Lecturer's details created successfully.");
    }

    public void displayLecturer() {
        System.out.println("Name: " + getFullName());
        System.out.println("Office room: " + this.officeAddr);
        System.out.println("Office number: " + this.officeNum);
        System.out.println("Phone number: " + this.phoneNum);
        System.out.println("Email: " + this.email);
    }
}
