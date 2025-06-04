package solution;

import java.util.Scanner;

public class CGPA {
    private static final int MAX_SEMESTERS = 10;
    private double[] semesterGPAs = new double[MAX_SEMESTERS]; 
    private int currentSemester = 0;

    public double[] getSemesterGPAs() {
        double[] copy = new double[currentSemester];
        System.arraycopy(semesterGPAs, 0, copy, 0, currentSemester);
        return copy;
    }

    public int getCurrentSemester() {
        return currentSemester;
    }

    public double calcGPA() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of subjects: ");
        int numOfSubjects = scanner.nextInt();

        double totalPoints = 0;
        int totalCreditHours = 0;

        for (int i = 0; i < numOfSubjects; i++) {
            System.out.println("\nSubject " + (i + 1) + ":");
            System.out.print("Enter credit hours: ");
            int creditHours = scanner.nextInt();

            System.out.print("Enter grade (A, A-, B+, B, etc.): ");
            String grade = scanner.next().toUpperCase();

            double gradePoint = getGradePoint(grade);
            if (gradePoint == -1) {
                System.out.println("Invalid grade entered. Please try again.");
                i--; 
                continue;
            }

            totalPoints += creditHours * gradePoint;
            totalCreditHours += creditHours;
        }

        if (totalCreditHours == 0) {
            System.out.println("No valid subjects entered.");
            return 0.0;
        }

        double gpa = totalPoints / totalCreditHours;
        System.out.printf("Calculated GPA: %.2f%n", gpa);
        return gpa;
    }

    private double getGradePoint(String grade) {
        return switch (grade) {
            case "A" -> 4.00;
            case "A-" -> 3.75;
            case "B+" -> 3.50;
            case "B" -> 3.00;
            case "C+" -> 2.50;
            case "C" -> 2.00;
            case "D+" -> 1.50;
            case "D" -> 1.00;
            case "F" -> 0.00;
            default -> -1;
        };
    }

    public void addSemesterGPA(double gpa, int semester) {
        if (semester < 1 || semester > MAX_SEMESTERS) {
            System.out.println("Semester must be between 1 and " + MAX_SEMESTERS);
            return;
        }
        semesterGPAs[semester - 1] = gpa;
        if (semester > currentSemester) {
            currentSemester = semester;
        }
    }

    public double calcCGPA() {
        if (currentSemester == 0) {
            System.out.println("No GPA data available.");
            return 0.0;
        }
        double total = 0;
        for (int i = 0; i < currentSemester; i++) {
            total += semesterGPAs[i];
        }
        double cgpa = total / currentSemester;
        return Math.round(cgpa * 100.0) / 100.0;
    }

    public void displaySemesterGPAs() {
        if (currentSemester == 0) {
            System.out.println("No semester GPA records found.");
            return;
        }
        System.out.println("\nSemester GPA Records:");
        for (int i = 0; i < currentSemester; i++) {
            System.out.printf("Semester %d: %.2f%n", (i + 1), semesterGPAs[i]);
        }
    }
}
