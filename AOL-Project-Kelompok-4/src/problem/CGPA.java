package problem;

import java.util.Scanner;

public class CGPA {
	// data attributes
	private int creditHour;
	private int fullCreditHour;
	private String grade;
	private int numOfSubject;
	private double point;
	private double totalPoint;
	private double gpa;
	private double[] list = new double[10];

	// methods of operation
	public double calcGPA() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of subject: ");
		numOfSubject = scanner.nextInt();
		System.out.println("Enter according to respective number of subject.");
		for (int i = 0; i < numOfSubject; i++) {
			System.out.print("Enter credit hour: ");
			creditHour = scanner.nextInt();
			System.out.print("Enter grade: ");
			grade = scanner.next();
			switch (grade) {
			case "A":
				point = creditHour * 4.00;
				break;
			case "A-":
				point = creditHour * 3.75;
				break;
			case "B+":
				point = creditHour * 3.50;
				break;
			case "B":
				point = creditHour * 3.00;
				break;
			case "C+":
				point = creditHour * 2.50;
				break;
			case "C":
				point = creditHour * 2.00;
				break;
			case "D+":
				point = creditHour * 1.50;
				break;
			case "D":
				point = creditHour * 1.00;
				break;
			case "F":
				point = creditHour * 0.00;
				break;
			}
			totalPoint += point;
			fullCreditHour += creditHour;
		}
		gpa = totalPoint / fullCreditHour;

		return gpa;
	}

	public void add(double gpa, int i) {
		this.list[i] = gpa;
	}

	public void displayGPA() {
		for (int i = 0; i < list.length; i++) {
			System.out.println("GPA for semester " + (i + 1) + " : " + String.format("%.2f", list[i]));
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CGPA semester = new CGPA();
		ListOfCGPA fatiha = new ListOfCGPA();
		int index = 0;
		int option;

		System.out.println("CGPA CALCULATOR");
		System.out.print("Enter which option number: ");
		option = scanner.nextInt();
		while (option != 3) {
			if (option == 1) {
				System.out.print("What semester do you wish to calculate your gpa? ");
				index = scanner.nextInt();
				semester.add(semester.calcGPA(), (index - 1));
				semester.displayGPA();
				System.out.print("Do you wish to continue? [Press 3 to exit]: ");
				option = scanner.nextInt();
			} else if (option == 2) {
				System.out.println("CGPA: " + fatiha.calcCGPA());
				System.out.print("Do you wish to continue? [Press 3 to exit]: ");
				option = scanner.nextInt();
			} else {
				System.out.println("Invalid input. Please reenter the option number.");
				System.out.print("Enter which option number: ");
				option = scanner.nextInt();
			}

		}
		System.out.println("Thank you!!");
	}
}
