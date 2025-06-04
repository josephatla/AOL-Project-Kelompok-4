package problem;

import java.util.Scanner;

public class Subject extends Lecturer {
	// ATTRIBUTES
	private String subjectName;
	private String description;
	private Lecturer lecturer;
	private String venue;
	private int creditHr;

	// METHODS
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public void setCreditHr(int creditHr) {
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

	// method createSubject
	public void createSubject(Lecturer lec) {
		System.out.println("----------------Subject's Details----------------");
		Scanner scanner = new Scanner(System.in);
		setLecturer(lec);
		System.out.print("Subject Name: ");
		String subjectName = scanner.nextLine();
		setSubjectName(subjectName);
		System.out.print("Subject Description: ");
		String description = scanner.nextLine();
		setDescription(description);
		lec.createLecturer(); // create lecturer
		System.out.print("\nVenue: ");
		String venue = scanner.nextLine();
		setVenue(venue);
		System.out.print("Credit Hour: ");
		int creditHr = scanner.nextInt();
		setCreditHr(creditHr);
		System.out.println("Subject's details created successfully.\n");
	}

	public void displaySubject() {
		System.out.println("Subject Name: " + getSubjectName());
		System.out.println("Subject Description: " + getDescription());
		System.out.println("\nLecturer's information: ");
		this.getLecturer().displayLecturer();
		System.out.println("\nVenue: " + getVenue());
		System.out.println("Credit Hour: " + getCreditHr());
		System.out.println("\n");
	}

    // UNIT TESTING
    /*
    public static void main(String[] args){
        // CREATING THE OBJECTS OF THE CLASS
        Subject subject1 = new Subject();
        Subject subject2 = new Subject();

        // ENTERING SUBJECT #1 DETAILS
        String subject1Name = "Object Oriented Programming";
        subject1.setSubjectName(subject1Name);
        String subject1Desc = "This course teaches about modularity and software design around data, or objects, " +
                                "rather than functions and logic";
        subject1.setDescription(subject1Desc);
        String subject1Lec = "Dr Nordin Zakaria";
        subject1.setLecturer(subject1Lec);
        String subject1Venue = "Lecture Theater D1, Pocket D";
        subject1.setVenue(subject1Venue);
        int subject1CreditHr = 3;
        subject1.setCreditHr(subject1CreditHr);

        // ENTERING SUBJECT #2 DETAILS
        String subject2Name = "Discrete Mathematics";
        subject2.setSubjectName(subject2Name);
        String subject2Desc = "This course enables students to strengthen and increase the understanding of discrete " +
                                "mathematics with special emphasis on computer science applications.";
        subject2.setDescription(subject2Desc);
        String subject2Lec = "Sir Jale B Ahmad";
        subject2.setLecturer(subject2Lec);
        String subject2Venue = "Lecture Theater D3, Pocket D";
        subject2.setVenue(subject2Venue);
        int subject2CreditHr = 3;
        subject2.setCreditHr(subject2CreditHr);

        // DISPLAYING EACH SUBJECT DETAILS
        subject1.displaySubject();
        subject2.displaySubject();

    }*/
}