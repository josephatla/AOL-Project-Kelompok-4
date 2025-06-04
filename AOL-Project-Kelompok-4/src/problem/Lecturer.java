package problem;

import java.util.Scanner;

public class Lecturer extends Name{
    private String officeAddr;
    private String officeNum;
    private String phoneNum;
    private String email;


    public void setOfficeAddr(String officeAddr) {
        this.officeAddr = officeAddr;
    }

    public void setOfficeNum(String officeNum) {
        this.officeNum = officeNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void createLecturer() {
        System.out.println("----------Lecturer's Details----------");
        Lecturer lec = new Lecturer();
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
        System.out.println("Name: " + this.getfName()+" "+this.getmName()+" "+this.getlName());
        System.out.println("Office room: " + this.officeAddr);
        System.out.println("office number: " + this.officeNum);
        System.out.println("Phone number: " + this.phoneNum);
        System.out.println("Email: " + this.email);
    }

    public static void main(String[] args) {
        Lecturer lecturer = new Lecturer();
        lecturer.createLecturer();
        lecturer.displayLecturer();
    }
}
