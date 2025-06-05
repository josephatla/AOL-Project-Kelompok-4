package problem;

/*
 * Smell Code: Lazy Class
 * Reason: Memiliki fungsi yang mirip dengan CGPA dan melakukan tugas sederhana yang redundan
 * Solution: Remove Class
 * 
 * Smell Code: Unnecessary Abstraction
 * Reason: Keberadaan kelas ListOfCGPA merupakan abstraksi yang tidak diperlukan karena fungsionalitasnya dapat ditangani sepenuhnya oleh kelas CGPA
 * Solution: Remove Abstraction, Move Method and Field
 */

import java.util.Scanner;

public class ListOfCGPA {
	// data attributes
	private int numOfSemester;
	private double cgpa;
	private double gpa;

	// methods of operations
	public double calcCGPA() {
		double totalGPA = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of semester: ");
		numOfSemester = scanner.nextInt();
		for (int i = 0; i < numOfSemester; i++) {
			System.out.print("Enter gpa for semester " + (i + 1) + " : ");
			gpa = scanner.nextDouble();
			totalGPA += gpa;
		}
		cgpa = totalGPA / numOfSemester;

		return Double.parseDouble(String.format("%.2f", cgpa));
	}

}