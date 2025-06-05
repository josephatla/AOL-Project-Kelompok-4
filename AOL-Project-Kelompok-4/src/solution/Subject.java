package solution;

import java.util.Scanner;

public class Subject {
	private String subjectName;
	private String description;
	private Lecturer lecturer;
	private String venue;
	private int creditHr;

	public Subject(String subjectName, String description, Lecturer lecturer, String venue, int creditHr) {
		this.subjectName = subjectName;
		this.description = description;
		this.lecturer = lecturer;
		this.venue = venue;
		this.creditHr = creditHr;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public String getDescription() {
		return description;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public String getVenue() {
		return venue;
	}

	public int getCreditHr() {
		return creditHr;
	}

	public static Subject createSubject(Scanner scanner) {

		Lecturer lecturer = Lecturer.createLecturer(scanner);

		System.out.println("----------------Subject's Details----------------");
		System.out.print("Subject Name: ");
		String subjectName = scanner.nextLine();

		System.out.print("Subject Description: ");
		String description = scanner.nextLine();

		System.out.print("\nVenue: ");
		String venue = scanner.nextLine();

		System.out.print("Credit Hour: ");
		int creditHr = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Subject's details created successfully.\n");

		return new Subject(subjectName, description, lecturer, venue, creditHr);
	}
}